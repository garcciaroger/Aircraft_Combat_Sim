package F35_Class.Aircraft_Characteristics;
import F35_Class.Aircraft;

public class FighterJet extends Aircraft {
    // Fighter jet specific attributes
    private double maxSpeed; // in Mach
    private int maxG; // maximum G forces
    private double combatRadius; // in nautical miles

    // Constructor
    public FighterJet(String manufacturer, String model, int fuelCapacity, 
                     int payloadCapacity, int altitude, double maxSpeed, 
                     int maxG, int maxWeapons) {
        super(manufacturer, model, fuelCapacity, payloadCapacity, altitude);
        this.maxSpeed = maxSpeed;
        this.maxG = maxG;
        this.combatRadius = 0; // Default value
    }
    
    // Getters and setters
    public double getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }
    public void setCombatRadius(double combatRadius) { this.combatRadius = combatRadius; }

    public int getMaxG() { return maxG; }
    public void setMaxG(int maxG) { this.maxG = maxG; }
    public double getCombatRadius() { return combatRadius; }
    public void displayJetStats() {
        System.out.println("Displaying fighter jet stats...");
    }
}
