package F35_Class.Defense_System;
import F35_Class.DefenseMechanism;

public class TowedDecoy extends DefenseMechanism {
    // Towed Decoy Attributes
    private String decoyType; // Type of decoy (e.g., radar, infrared)
    private boolean mimicRadarSignal; // Mimic radar signal status
    private double length; // Length of the decoy in meters
    private double weight; // Weight of the decoy in kg
    private boolean deployed; // Deployment status

    // Constructor
    public TowedDecoy(String type, String model, int range, String lockType, 
                      String decoyType, double length, double weight) {
        super(type, model, range, lockType); // Call the parent constructor
        this.decoyType = decoyType;
        this.mimicRadarSignal = false; // Default to not mimicking
        this.length = length;
        this.weight = weight;
        this.deployed = false; // Default to not deployed
    }

    // Setters
    public void setDecoyType(String decoyType) { this.decoyType = decoyType; }
    public void setLength(double length) { this.length = length; }
    public void setMimicRadarSignal(boolean mimicRadarSignal) { this.mimicRadarSignal = mimicRadarSignal; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setDeployed(boolean deployed) { this.deployed = deployed; }

    // Getters
    public String getDecoyType() { return decoyType; }
    public boolean isMimicRadarSignal() { return mimicRadarSignal; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean isDeployed() { return deployed; }

    // Methods
    @Override
    public void activate() {
        deployed = true;
        System.out.println("Activating Towed Decoy system...");
    }

    @Override
    public void deactivate() {
        deployed = false;
        System.out.println("Deactivating Towed Decoy system...");
    }

    public void deploy() {
        if (!deployed) {
            deployed = true;
            System.out.println("Deploying Towed Decoy...");
        } else {
            System.out.println("Towed Decoy is already deployed.");
        }
    }

    public void retract() {
        if (deployed) {
            deployed = false;
            System.out.println("Retracting Towed Decoy...");
        } else {
            System.out.println("Towed Decoy is not deployed.");
        }
    }
    
}
