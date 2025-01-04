-- database DoomsdayAsteroid
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS asteroids;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

--users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE asteroids (
    asteroid_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    diameter_in_km INTEGER NOT NULL,
    velocity_in_km INTEGER NOT NULL,
    lethal_percentage DECIMAL(7, 3) NOT NULL,
    year_of_end DATE NULL,
    description VARCHAR(500) NULL
);

-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************


-- Users
-- Password for all users is password
INSERT INTO
    users (username, password_hash, role)

VALUES
    ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER'),
    ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN');

INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description)

VALUES ('Bartholomew the Destroyer, Ender of Realms', 53, 1000000.00, 90.99, '2030-01-01', 'A reasonably sized asteroid ready to take a hefty chunk out of life as we know and cherish it.');

INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description)

VALUES ('Jack', 8, 15.00, 95.15, '2813-06-27', 'A big fan of marbles, Jack is especially keen on obliterating our precious blue marble, explicitly for fun.');

INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description)

VALUES ('The Nameless', 87, 50000.00, 70.50, '2701-05-27', 'Possesses a name too terrifying and incomprehensible to be known by mortals and only whispered by the stars.');

INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description)

VALUES ('Linda', 100, 50000.00, 100.00, '2999-12-31', 'Like most Lindas, Linda enjoys crocheting. A mother of 3, she is used to cleaning up messes, and is here to bring about a complete and absolute end to all life should the others fail.');

INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description)

VALUES ('Asbeston', 1, 2, 80, '2031-07-19', 'A dainty asteroid in size in comparison to the others, but unfortunately made completely of asbestos.');

INSERT INTO asteroids (name, diameter_in_km, velocity_in_km, lethal_percentage, year_of_end, description)

VALUES ('Pusheen', 50, 100, 25, '2025-07-23', 'Adorable and a little bit mischievous, Pusheen is rolling towards the Earth but only slightly lethal to the general Earth population.');

COMMIT TRANSACTION;
