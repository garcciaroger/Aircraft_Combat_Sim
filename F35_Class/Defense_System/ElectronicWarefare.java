package F35_Class.Defense_System;
import F35_Class.DefenseMechanism;

public class ElectronicWarefare extends DefenseMechanism {
    // Electronic Warfare Attributes
    private double frequencyMin; // Frequency in GHz
    private double frequencyMax; // Frequency in GHz
    private boolean active; // Active status
    private String mode; // Mode of operation (e.g., jamming, deception)

    // Constructor
    public ElectronicWarefare(String type, String model, int range, String lockType, 
                              double frequencyMin, double frequencyMax, String mode) {
        super(type, model, range, lockType); // Call the parent constructor
        this.frequencyMin = frequencyMin;
        this.frequencyMax = frequencyMax;
        this.active = false; // Default to inactive
        this.mode = mode;
    }

    // Setters
    public void setFrequencyMin(double frequencyMin) { this.frequencyMin = frequencyMin; }
    public void setFrequencyMax(double frequencyMax) { this.frequencyMax = frequencyMax; }
    public void setActive(boolean active) { this.active = active; }
    public void setMode(String mode) { this.mode = mode; }

    // Getters
    public double getFrequencyMin() { return frequencyMin; }
    public double getFrequencyMax() { return frequencyMax; }
    public boolean isActive() { return active; }
    public String getMode() { return mode; }

    // Methods
    @Override
    public void activate() {
        active = true;
        System.out.println("Activating Electronic Warfare system...");
    }

    @Override
    public void deactivate() {
        active = false;
        System.out.println("Deactivating Electronic Warfare system...");
    }

    public void engage() {
        System.out.println("Engaging Electronic Warfare system in " + mode + " mode...");
    }
}