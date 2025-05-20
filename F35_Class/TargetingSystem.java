package F35_Class;

public class TargetingSystem {
//Targeting System Attributes
    private String type; // Type of targeting system (e.g., radar, infrared)
    private String model; // Model of the targeting system
    private int range; // Range of the targeting system (in miles)
    private String lockType; // Type of lock (e.g., radar, infrared)
    private boolean active; // Active status

    // Constructor
    public TargetingSystem(String type, String model, int range, String lockType) {
        this.type = type;
        this.model = model;
        this.range = range;
        this.lockType = lockType;
        this.active = false; // Default to inactive
    }

    // Setters
    public void setType(String type) { this.type = type; }
    public void setModel(String model) { this.model = model; }
    public void setRange(int range) { this.range = range; }
    public void setLockType(String lockType) { this.lockType = lockType; }
    public void setActive(boolean active) { this.active = active; }

    // Getters
    public String getType() { return type; }
    public String getModel() { return model; }
    public int getRange() { return range; }
    public String getLockType() { return lockType; }
    public boolean isActive() { return active; }

    // Methods
    public void activate() {
        active = true;
        System.out.println("Activating " + type + " targeting system...");
    }

    public void deactivate() {
        active = false;
        System.out.println("Deactivating " + type + " targeting system...");
    }

    public void engage() {
        if (active) {
            System.out.println("Engaging " + type + " targeting system...");
        } else {
            System.out.println(type + " targeting system is not active.");
        }
    }

    public void disengage() {
        if (active) {
            System.out.println("Disengaging " + type + " targeting system...");
        } else {
            System.out.println(type + " targeting system is not active.");
        }
    }
    public void displayInfo() {
        System.out.println("Targeting System Type: " + type);
        System.out.println("Model: " + model);
        System.out.println("Range: " + range + " miles");
        System.out.println("Lock Type: " + lockType);
        System.out.println("Active Status: " + (active ? "Active" : "Inactive"));
    }
}
