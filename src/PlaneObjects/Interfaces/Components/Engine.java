package PlaneObjects.Interfaces.Components;

public class Engine {
    private String manufacturer;       // e.g., "Pratt & Whitney"
    private String modelName;          // e.g., "F135-PW-100"
    private String type;               // e.g., "Turbofan", "Turbojet", "Ramjet"
    private int thrust;                // in pounds-force (lbf)
    private double fuelConsumptionRate; // e.g., gallons/hour
    private boolean isOperational;

    public Engine(String manufacturer, String modelName, String type, int thrust, double fuelConsumptionRate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.type = type;
        this.thrust = thrust;
        this.fuelConsumptionRate = fuelConsumptionRate;
        this.isOperational = true; // default to operational
    }

    // Getters
    public String getManufacturer() { return manufacturer; }
    public String getModelName() { return modelName; }
    public String getType() { return type; }
    public int getThrust() { return thrust; }
    public double getFuelConsumptionRate() { return fuelConsumptionRate; }
    public boolean isOperational() { return isOperational; }

    // Setters
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public void setType(String type) { this.type = type; }
    public void setThrust(int thrust) { this.thrust = thrust; }
    public void setFuelConsumptionRate(double rate) { this.fuelConsumptionRate = rate; }

    // Methods
    public void shutDown() {
        isOperational = false;
        System.out.println("Engine has been shut down.");
    }

    public void startUp() {
        isOperational = true;
        System.out.println("Engine is now operational.");
    }

    @Override
    public String toString() {
        return String.format("""
            --- Engine Specs ---
            Manufacturer       : %s
            Model              : %s
            Type               : %s
            Thrust             : %d lbf
            Fuel Consumption   : %.2f gal/hr
            Operational        : %s
            """,
            manufacturer, modelName, type, thrust, fuelConsumptionRate, isOperational ? "YES" : "NO"
        );
    }
}