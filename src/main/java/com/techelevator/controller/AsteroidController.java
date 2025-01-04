package com.techelevator.controller;

import com.techelevator.dao.AsteroidDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Asteroid;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/asteroids")
public class AsteroidController {

    private AsteroidDao asteroidDao;

    public AsteroidController(AsteroidDao asteroidDao) {
        this.asteroidDao = asteroidDao;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(method = RequestMethod.GET)
    public List<Asteroid> getAsteroids() {
        return asteroidDao.getAsteroids();
    }

    @RequestMapping(path = "/{asteroidId}", method = RequestMethod.GET)
    public Asteroid getAsteroidById(@PathVariable int asteroidId) {
        Asteroid asteroid = asteroidDao.getAsteroidById(asteroidId);

        if (asteroid == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asteroid Not Found");

        } else {
            return asteroidDao.getAsteroidById(asteroidId);
        }
    }
    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Asteroid createAsteroid(@Valid @RequestBody Asteroid newAsteroid) {
        Asteroid asteroid = null;

        try {
            asteroid = asteroidDao.createAsteroid(newAsteroid);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return asteroid;
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/{asteroidId}", method = RequestMethod.PUT)
    public Asteroid updateAsteroid(@PathVariable int asteroidId, @Valid @RequestBody Asteroid modifiedAsteroid) {
        Asteroid asteroid = null;

        try {
            modifiedAsteroid.setAsteroidId(asteroidId);
            asteroid = asteroidDao.updateAsteroid(modifiedAsteroid);
            if (asteroid == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asteroid not found");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return asteroid;
    }
    @RequestMapping(path = "/{asteroidId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int asteroidId) {
        try {
            int asteroidsDeleted = asteroidDao.deleteAsteroidById(asteroidId);
            if (asteroidsDeleted < 1) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asteroid to be deleted not found");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while deleting the asteroid");
        }
    }
}
