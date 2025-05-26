package Aircraft_Simulator.TargetingSystem;

public abstract class Targeting {
    protected String name;
    protected String sensorType;   // e.g., infrared, electro-optical, laser
    protected String resolution;   // e.g., high, medium, low
    protected boolean nightVision;
    protected boolean active;
    protected double targetingRange; // in nautical miles

    public Targeting(String name, String sensorType, String resolution, boolean nightVision, double targetingRange) {
        this.name = name;
        this.sensorType = sensorType;
        this.resolution = resolution;
        this.nightVision = nightVision;
        this.active = false;
        this.targetingRange = targetingRange;
    }

    // Common methods
    public void activate() {
        active = true;
        System.out.println(name + " activated.");
    }

    public void deactivate() {
        active = false;
        System.out.println(name + " deactivated.");
    }

    public boolean isActive() {
        return active;
    }

    public String getName() { return name; }
    public String getSensorType() { return sensorType; }
    public String getResolution() { return resolution; }
    public boolean hasNightVision() { return nightVision; }
    public double getTargetingRange() { return targetingRange; }
    public void setTargetingRange(double targetingRange) { this.targetingRange = targetingRange; }

    // Abstract for subclasses to implement specific targeting
    public abstract void engage();
    public abstract void disengage();
    public abstract void addTarget(String target);
    public abstract void displayTargets();
}
