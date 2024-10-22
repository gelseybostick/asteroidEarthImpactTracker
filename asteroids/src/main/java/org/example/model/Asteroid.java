package org.example.model;

public class Asteroid {

    private String name;
    private int earliestYear;
    private int latestYear;
    private int potentialImpacts;
    private String impactProbability;
    private double velocity;
    private double absoluteMagnitude;
    private double estimatedDiameterInKm;
    private double palermoScaleCumulative;
    private double palermoScaleMax;
    private int torinoScale;
    public Asteroid(String name, int earliestYear, int potentialImpacts, String impactProbability,
                    double velocity, double estimatedDiameterInKm) {
        this.name = name;
        this.earliestYear = earliestYear;
        this.potentialImpacts = potentialImpacts;
        this.impactProbability = impactProbability;
        this.velocity = velocity;
        this.estimatedDiameterInKm = estimatedDiameterInKm;

    }
    public Asteroid(String name, int earliestYear, int latestYear, int potentialImpacts, String impactProbability,
                    double velocity, double absoluteMagnitude, double estimatedDiameterInKm, double palermoScaleCumulative,
                    double palermoScaleMax, int torinoScale) {
        this.name = name;
        this.earliestYear = earliestYear;
        this.latestYear = latestYear;
        this.potentialImpacts = potentialImpacts;
        this.impactProbability = impactProbability;
        this.velocity = velocity;
        this.absoluteMagnitude = absoluteMagnitude;
        this.estimatedDiameterInKm = estimatedDiameterInKm;
        this.palermoScaleCumulative = palermoScaleCumulative;
        this.palermoScaleMax = palermoScaleMax;
        this.torinoScale = torinoScale;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEarliestYear() {
        return earliestYear;
    }
    public void setEarliestYear(int earliestYear) {
        this.earliestYear = earliestYear;
    }
    public int getLatestYear() {
        return latestYear;
    }
    public void setLatestYear(int latestYear) {
        this.latestYear = latestYear;
    }
    public int getPotentialImpacts() {
        return potentialImpacts;
    }
    public void setPotentialImpacts(int potentialImpacts) {
        this.potentialImpacts = potentialImpacts;
    }
    public String getImpactProbability() {
        return impactProbability;
    }
    public void setImpactProbability(String impactProbability) {
        this.impactProbability = impactProbability;
    }
    public double getVelocity() {
        return velocity;
    }
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    public double getEstimatedDiameterInKm() {
        return estimatedDiameterInKm;
    }

    public void setEstimatedDiameterInKm(double estimatedDiameterInKm) {
        this.estimatedDiameterInKm = estimatedDiameterInKm;
    }

    public double getPalermoScaleCumulative() {
        return palermoScaleCumulative;
    }

    public void setPalermoScaleCumulative(double palermoScaleCumulative) {
        this.palermoScaleCumulative = palermoScaleCumulative;
    }

    public double getPalermoScaleMax() {
        return palermoScaleMax;
    }

    public void setPalermoScaleMax(double palermoScaleMax) {
        this.palermoScaleMax = palermoScaleMax;
    }

    public int getTorinoScale() {
        return torinoScale;
    }

    public void setTorinoScale(int torinoScale) {
        this.torinoScale = torinoScale;
    }
}
