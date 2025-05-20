package F35_Class.Defense_System;

public class DAAS {
   //Distriputed Aperture System (DAS) attributes
    private boolean infraredSensorsActive; // Status of infrared sensors
    private boolean radarSensorsActive; // Status of radar sensors
    // Constructor
    public DAAS() {
        this.infraredSensorsActive = false;
        this.radarSensorsActive = false;
    }
    // Getters 
    public boolean isInfraredSensorsActive() {
        return infraredSensorsActive;
    }
    public boolean isRadarSensorsActive() {
        return radarSensorsActive;
    }
    // Setters
    public void setInfraredSensorsActive(boolean infraredSensorsActive) {
        this.infraredSensorsActive = infraredSensorsActive;
    }
    public void setRadarSensorsActive(boolean radarSensorsActive) {
        this.radarSensorsActive = radarSensorsActive;
    }
    // Methods to activate and deactivate sensors
    public void activateInfraredSensors() {
        if (!infraredSensorsActive) {
            infraredSensorsActive = true;
            System.out.println("Infrared sensors activated.");
        } else {
            System.out.println("Infrared sensors already active.");
        }
    }
    public void deactivateInfraredSensors() {
        if (infraredSensorsActive) {
            infraredSensorsActive = false;
            System.out.println("Infrared sensors deactivated.");
        } else {
            System.out.println("Infrared sensors already inactive.");
        }
    }
    public void activateRadarSensors() {
        if (!radarSensorsActive) {
            radarSensorsActive = true;
            System.out.println("Radar sensors activated.");
        } else {
            System.out.println("Radar sensors already active.");
        }
    }
    public void deactivateRadarSensors() {
        if (radarSensorsActive) {
            radarSensorsActive = false;
            System.out.println("Radar sensors deactivated.");
        } else {
            System.out.println("Radar sensors already inactive.");
        }
    }
}
