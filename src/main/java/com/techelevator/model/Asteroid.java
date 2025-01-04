package com.techelevator.model;

import java.time.LocalDate;
public class Asteroid {

        private int asteroidId;
        private String name;
        private int diameterInKm;
        private int velocityInKm;
        private double lethality;
        private LocalDate yearOfEnd;
        private String description;

        public int getAsteroidId() {
            return asteroidId;
        }

        public void setAsteroidId(int asteroidId) {
            this.asteroidId = asteroidId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDiameterInKm() {
            return diameterInKm;
        }

        public void setDiameterInKm(int diameterInKm) {
            this.diameterInKm = diameterInKm;
        }

        public int getVelocityInKm() {
            return velocityInKm;
        }

        public void setVelocityInKm(int velocityInKm) {
            this.velocityInKm = velocityInKm;
        }

        public double getLethality() {
            return lethality;
        }

        public void setLethality(double lethality) {
            this.lethality = lethality;
        }

        public LocalDate getYearOfEnd() {
            return yearOfEnd;
        }

        public void setYearOfEnd(String yearOfEnd) {
            this.yearOfEnd = LocalDate.parse(yearOfEnd);
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Asteroid() {}
        public Asteroid(int asteroidId, String name, int diameterInKm, int velocityInKm,
                        double lethality, String yearOfEnd, String description) {
            this.asteroidId = asteroidId;
            this.name = name;
            this.diameterInKm = diameterInKm;
            this.velocityInKm = velocityInKm;
            this.lethality = lethality;
            this.yearOfEnd = LocalDate.parse(yearOfEnd);
            this.description = description;
        }
        @Override
        public String toString() {
            return "Asteroid{" +
                    "asteroid_id=" + asteroidId +
                    ", name='" + name + '\'' +
                    ", diameter_in_km=" + diameterInKm +
                    ", velocity_in_km=" + velocityInKm +
                    ", lethal_percentage='" + lethality + '\'' +
                    ", year_of_end='" + yearOfEnd + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
}
