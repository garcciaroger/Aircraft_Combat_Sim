package Aircraft_Simulator.Aircraft;

public class Bomber extends Aircraft {
    // Bomber-specific attributes
    private int bombBayCapacity;   // in pounds
    private boolean nuclearCapable; // Is the bomber nuclear-capable?
    // Constructor
    public Bomber(String manufacturer, String model, int fuelCapacity, int maxAltitude, 
                  double combatRadius, int bombBayCapacity, boolean nuclearCapable) {
        super(manufacturer, model, fuelCapacity, maxAltitude, combatRadius);
        this.bombBayCapacity = bombBayCapacity;
        this.nuclearCapable = nuclearCapable;
    }
    // Getters
    public int getBombBayCapacity() {return bombBayCapacity;}
    public boolean isNuclearCapable() {return nuclearCapable;}
    // Setters
    public void setBombBayCapacity(int bombBayCapacity) {this.bombBayCapacity = bombBayCapacity;}
    public void setNuclearCapable(boolean nuclearCapable) {this.nuclearCapable = nuclearCapable;}
    // Display bomber stats
    public void displayBomberStats() {
        System.out.println("Bomber Stats:");
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Model: " + getModel());
        System.out.println("Fuel Capacity: " + getFuelCapacity() + " gallons");
        System.out.println("Max Altitude: " + getMaxAltitude() + " feet");
        System.out.println("Combat Radius: " + getCombatRadius() + " nautical miles");
        System.out.println("Bomb Bay Capacity: " + bombBayCapacity + " pounds");
        System.out.println("Nuclear Capable: " + (nuclearCapable ? "Yes" : "No"));
    }
}
