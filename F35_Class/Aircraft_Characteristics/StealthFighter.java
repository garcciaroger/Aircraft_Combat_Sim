package F35_Class.Aircraft_Characteristics;

public class StealthFighter extends FighterJet {
    // Stealth-specific attributes
    private double radarCrossSection; // in square meters (smaller is better)
    private boolean stealthModeActive;
    // Constructor
    public StealthFighter(String manufacturer, String model, int fuelCapacity, 
                         int payloadCapacity, int altitude, double maxSpeed, 
                         int maxG, int maxWeapons, double radarCrossSection,
                         int maxDefenseSystems) {
        super(manufacturer, model, fuelCapacity, payloadCapacity, altitude, 
              maxSpeed, maxG, maxWeapons);
        this.radarCrossSection = radarCrossSection;
        this.stealthModeActive = false;
    }
    // Getters and setters
    public double getRadarCrossSection() {
        return stealthModeActive ? radarCrossSection * 0.1 : radarCrossSection;
    }
    
    public void setRadarCrossSection(double radarCrossSection) {
        this.radarCrossSection = radarCrossSection;
    }
    
    public boolean isStealthModeActive() {
        return stealthModeActive;
    }
    // Stealth-specific methods
    public void activateStealthMode() {
        if (!stealthModeActive) {
            stealthModeActive = true;
            System.out.println(getModel() + " activating stealth mode");
            System.out.println("Radar cross-section reduced to " + getRadarCrossSection() + " square meters");
        } else {
            System.out.println("Stealth mode already active");
        }
    }
    public void deactivateStealthMode() {
        if (stealthModeActive) {
            stealthModeActive = false;
            System.out.println(getModel() + " deactivating stealth mode");
            System.out.println("Radar cross-section returned to " + radarCrossSection + " square meters");
        } else {
            System.out.println("Stealth mode already inactive");
        }
    }
   
}
