package Aircraft_Simulator.Aircraft;

public class Fighter extends Aircraft {
    private int payloadCapacity; // in pounds
    private int maxWeapons;      // maximum number of weapons
    private double maxSpeed;     // in Mach
    private int maxG;            // maximum G forces

    public Fighter(String manufacturer, String model, int fuelCapacity, int maxAltitude, 
                   int payloadCapacity, int maxWeapons, double maxSpeed, int maxG, double combatRadius) {
        super(manufacturer, model, fuelCapacity, maxAltitude, combatRadius); // Pass to parent!
        this.payloadCapacity = payloadCapacity;
        this.maxWeapons = maxWeapons;
        this.maxSpeed = maxSpeed;
        this.maxG = maxG;
    }

   // Getters
  public int getPayloadCapacity() { return payloadCapacity; }
  public int getMaxWeapons() { return maxWeapons; }
  public double getMaxSpeed() { return maxSpeed; }
  public int getMaxG() { return maxG; }

  // Setters
  public void setPayloadCapacity(int payloadCapacity) { this.payloadCapacity = payloadCapacity; }
  public void setMaxWeapons(int maxWeapons) { this.maxWeapons = maxWeapons; }
  public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }
  public void setMaxG(int maxG) { this.maxG = maxG; }

    // Access combatRadius using the parent's getter!
    public void displayJetStats() {
        System.out.println("Fighter Jet Stats: " +
            "\nPayload Capacity: " + payloadCapacity +
            "\nMax Weapons: " + maxWeapons +
            "\nMax Speed (Mach): " + maxSpeed +
            "\nMax G: " + maxG +
            "\nCombat Radius: " + getCombatRadius() + // <- parent getter
            "\nMax Altitude: " + getMaxAltitude() +
            "\nManufacturer: " + getManufacturer() +
            "\nModel: " + getModel());
    }
}

