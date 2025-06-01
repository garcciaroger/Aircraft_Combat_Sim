package PlaneObjects.Models.BaseFile;
import PlaneObjects.Interfaces.Components.Engine;
import PlaneObjects.Methods.Land;
import PlaneObjects.Methods.TakeOff;

public abstract class Aircraft implements TakeOff, Land {
    private final String manufacturer;
    private final String model;
    private final double maxSpeed;
    private final int maxTakeoffWeight;
    private final int crewCapacity;
    private final Engine engine;
    private final int fuelCapacity;
    private final int maxAltitude;
    private final double range;

    public Aircraft(String manufacturer, String model, double maxSpeed, int maxTakeoffWeight,
                    int crewCapacity, Engine engine, int fuelCapacity, int maxAltitude, double range) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.crewCapacity = crewCapacity;
        this.engine = engine;
        this.fuelCapacity = fuelCapacity;
        this.maxAltitude = maxAltitude;
        this.range = range;
    }

    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public double getMaxSpeed() { return maxSpeed; }
    public int getMaxTakeoffWeight() { return maxTakeoffWeight; }
    public int getCrewCapacity() { return crewCapacity; }
    public Engine getEngine() { return engine; }
    public int getFuelCapacity() { return fuelCapacity; }
    public int getMaxAltitude() { return maxAltitude; }
    public double getRange() { return range; }

    @Override
    public String toString() {
        return String.format("""
            --- Aircraft Information ---
            Manufacturer        : %s
            Model               : %s
            Max Speed           : %.1f km/h
            Max Takeoff Weight  : %d kg
            Crew Capacity       : %d
            Fuel Capacity       : %d gallons
            Max Altitude        : %d feet
            Range               : %.1f nautical miles

            %s
            """,
            manufacturer, model, maxSpeed, maxTakeoffWeight, crewCapacity,
            fuelCapacity, maxAltitude, range,
            engine.toString()
        );
    }
}