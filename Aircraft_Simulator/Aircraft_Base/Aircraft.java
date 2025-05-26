package Aircraft_Simulator.Aircraft_Base;

public class Aircraft {
    // Plane Attributes
    private String manufacturer;
    private String model;
    private int fuelCapacity;
    private int maxAltitude;
    private double combatRadius; // in nautical miles

    // Constructor
    public Aircraft(String manufacturer, String model, int fuelCapacity, int maxAltitude, double combatRadius) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuelCapacity = fuelCapacity;
        this.maxAltitude = maxAltitude;
        this.combatRadius = combatRadius;
    }

    // Getters
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getFuelCapacity() { return fuelCapacity; }
    public int getMaxAltitude() { return maxAltitude; }
    public double getCombatRadius() { return combatRadius; }

    // Setters
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setModel(String model) { this.model = model; }
    public void setFuelCapacity(int fuelCapacity) { this.fuelCapacity = fuelCapacity; }
    public void setMaxAltitude(int maxAltitude) { this.maxAltitude = maxAltitude; }
    public void setCombatRadius(double combatRadius) { this.combatRadius = combatRadius; }

    // Basic aircraft methods
    public void taxi() { System.out.println("Taxiing..."); }
    public void takeOff() { System.out.println("Clear for takeoff!"); }
    public void land() { System.out.println("Clear for landing."); }
}
