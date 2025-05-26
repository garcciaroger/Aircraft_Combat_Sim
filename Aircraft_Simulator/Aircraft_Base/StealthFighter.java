package Aircraft_Simulator.Aircraft_Base;

public class StealthFighter extends Fighter {
    private double radarCrossSection; // in square meters
    private boolean stealthModeActive;

    public StealthFighter(String manufacturer, String model, int fuelCapacity,
                         int payloadCapacity, int maxAltitude, double maxSpeed,
                         int maxG, int maxWeapons, double radarCrossSection, double combatRadius) {
        super(manufacturer, model, fuelCapacity, maxAltitude, payloadCapacity, maxWeapons, maxSpeed, maxG, combatRadius);
        this.radarCrossSection = radarCrossSection;
        this.stealthModeActive = false;
    }

    public double getRadarCrossSection() {
        return stealthModeActive ? radarCrossSection * 0.1 : radarCrossSection;
    }

    public void setRadarCrossSection(double radarCrossSection) {
        this.radarCrossSection = radarCrossSection;
    }

    public boolean isStealthModeActive() {
        return stealthModeActive;
    }

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
