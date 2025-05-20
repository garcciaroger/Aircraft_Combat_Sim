package F35_Class;

public class Aircraft {
    // Plane Attributes
    private String manufacturer;
    private String model;
    private int fuelCapacity;
    private int payloadCapacity; //In LBS
    private int altitude;
    
    // Constructor
    public Aircraft(String manufacturer, String model, int fuelCapacity, int payloadCapacity, int altitude) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.fuelCapacity = fuelCapacity;
        this.payloadCapacity = payloadCapacity;
        this.altitude = altitude;
    }
    
    // Getters
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getFuelCapacity() { return fuelCapacity; }
    public int getPayloadCapacity() { return payloadCapacity; }
    public int getAltitude() { return altitude; }
    
    // Setters
    public void setAltitude(int altitude) { this.altitude = altitude; }
    public void setPayloadCapacity(int payloadCapacity) { this.payloadCapacity = payloadCapacity; }
    public void setFuelCapacity(int fuelCapacity) { this.fuelCapacity = fuelCapacity; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setModel(String model) { this.model = model; }
    
    // Basic aircraft methods
    public void taxi() { System.out.println("Taxiing......"); }
    public void takeOff() { System.out.println("Clear for takeoff!"); }
    public void land() { System.out.println("Clear for landing."); }
    public void climbToAltitude() { System.out.println("Climbing to " + altitude + " meters..."); }
}