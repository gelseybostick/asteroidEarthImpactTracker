package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Asteroid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAsteroidDao implements AsteroidDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcAsteroidDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Asteroid> getAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();

        String sql = "SELECT * FROM asteroids;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Asteroid asteroid = mapRowToAsteroid(results);
                asteroids.add(asteroid);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return asteroids;
    }

    @Override
    public Asteroid getAsteroidById(int asteroidId) {
        Asteroid asteroid = null;

        String sql = "SELECT * FROM asteroids WHERE asteroid_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, asteroidId);
            if (results.next()) {
                asteroid = mapRowToAsteroid(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return asteroid;
    }

    @Override
    public Asteroid getAsteroidByName(String name) {
        Asteroid asteroid = null;

        String sql = "SELECT * FROM asteroids WHERE name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            if (results.next()) {
                asteroid = mapRowToAsteroid(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return asteroid;
    }

    @Override
    public Asteroid createAsteroid(Asteroid asteroid) {
        Asteroid newAsteroid = null;

        String sql = "INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING asteroid_id;";

        try {
            int newAsteroidId = jdbcTemplate.queryForObject(sql, int.class,
                    asteroid.getName(), asteroid.getDiameterInKm(), asteroid.getVelocityInKm(), asteroid.getLethality(),
                    asteroid.getYearOfEnd(), asteroid.getDescription());
            newAsteroid = getAsteroidById(newAsteroidId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation " + e.getMessage(), e);
        }

        return newAsteroid;
    }

    @Override
    public Asteroid updateAsteroid(Asteroid asteroidToUpdate) {
        Asteroid modifiedAsteroid = null;

        String sql = "UPDATE asteroids " +
                "SET name = ?, diameter_in_km = ?, velocity_in_km = ?, lethal_percentage = ?, year_of_end = ?, description = ? " +
                "WHERE asteroid_id = ?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, asteroidToUpdate.getName(), asteroidToUpdate.getDiameterInKm(),
                    asteroidToUpdate.getVelocityInKm(), asteroidToUpdate.getLethality(), asteroidToUpdate.getYearOfEnd(),
                    asteroidToUpdate.getDescription(), asteroidToUpdate.getAsteroidId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }
            modifiedAsteroid = getAsteroidById(asteroidToUpdate.getAsteroidId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return modifiedAsteroid;
    }

    @Override
    public int deleteAsteroidById(int asteroidId) {
        int numberOfRows = 0;

        String deleteFromAsteroids = "DELETE FROM asteroids WHERE asteroid_id = ?;";

        try {
            numberOfRows += jdbcTemplate.update(deleteFromAsteroids, asteroidId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }
    private Asteroid mapRowToAsteroid(SqlRowSet results) {
        Asteroid asteroid = new Asteroid();
        asteroid.setAsteroidId(results.getInt("asteroid_id"));
        asteroid.setName(results.getString("name"));
        asteroid.setDiameterInKm(results.getInt("diameter_in_km"));
        asteroid.setVelocityInKm(results.getInt("velocity_in_km"));
        asteroid.setLethality(results.getDouble("lethal_percentage"));
        asteroid.setYearOfEnd(results.getString("year_of_end"));
        asteroid.setDescription(results.getString("description"));
        return asteroid;
    }
}
