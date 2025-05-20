package F35_Class.Targeting_System;
import F35_Class.TargetingSystem;

public class EOTS extends TargetingSystem {
    private String sensorType; // Type of sensor (e.g., infrared, electro-optical)
    private String resolution; // Resolution of the sensor (e.g., high, medium, low)
    private boolean nightVision; // Night vision capability
    private String[] targetList = new String[10]; // Array to hold target names
    private int targetCount = 0; // Counter for the number of targets
    private boolean active; // Active status
    private String type; // Type of targeting system (e.g., radar, infrared)

    // Constructor
    public EOTS(String type, String model, int range, String lockType, String sensorType, String resolution, boolean nightVision) {
        super(type, model, range, lockType); // Call the parent constructor
        this.sensorType = sensorType;
        this.resolution = resolution;
        this.nightVision = nightVision;
        this.active = false; // Default to inactive
    }
    // Setters
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public void setResolution(String resolution) { this.resolution = resolution; }
    public void setNightVision(boolean nightVision) { this.nightVision = nightVision; }
    public void setActive(boolean active) { this.active = active; }
    public void setType(String type) { this.type = type; }
    // Getters
    public String getSensorType() { return sensorType; }
    public String getResolution() { return resolution; }
    public boolean isNightVision() { return nightVision; }
    public boolean isActive() { return active; }
    public String getType() { return type; }
    // Methods
    public void activate() {
        active = true;
        System.out.println("Activating EOTS targeting system...");
    }
    public void deactivate() {
        active = false;
        System.out.println("Deactivating EOTS targeting system...");
    }
    public void engage() {
        if (active) {
            System.out.println("Engaging EOTS targeting system...");
        } else {
            System.out.println("EOTS targeting system is not active.");
        }
    }
    public void disengage() {
        if (active) {
            System.out.println("Disengaging EOTS targeting system...");
        } else {
            System.out.println("EOTS targeting system is not active.");
        }
    }
    public void addTarget(String target) {
        if (targetCount < targetList.length) {
            targetList[targetCount] = target;
            targetCount++;
            System.out.println("Target " + target + " added to EOTS targeting system.");
        } else {
            System.out.println("Target list is full. Cannot add more targets.");
        }
    }
}
