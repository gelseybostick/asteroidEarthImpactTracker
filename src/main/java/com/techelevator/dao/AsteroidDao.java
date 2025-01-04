package com.techelevator.dao;

import com.techelevator.model.Asteroid;

import java.util.List;

public interface AsteroidDao {

    List<Asteroid> getAsteroids();
    Asteroid getAsteroidById(int asteroidId);
    Asteroid getAsteroidByName(String name);
    Asteroid createAsteroid(Asteroid newAsteroid);
    Asteroid updateAsteroid(Asteroid modifiedAsteroid);
    int deleteAsteroidById(int asteroidId);
}
