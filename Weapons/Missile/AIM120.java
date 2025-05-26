package Weapons.Missile;

public class AIM120 extends Missile {
    // AIM-120 specific attribute
    private final String radarMode; // Always set to "Active" for AMRAAM

    // No-argument constructor: hardcoded stats
    public AIM120() {
        super("AIM-120 AMRAAM", 335, 100, "Radar", 4.0); // Name, weight, range, guidance, speed
        this.radarMode = "Active"; // Hardcoded value
    }

    // Getter for radarMode
    public String getRadarMode() { return radarMode; }

    // Override fire method
    @Override
    public void fire(String target) {
        if (isArmed()) {
            System.out.println("Firing AIM-120 AMRAAM at " + target + " in " + radarMode + " radar mode.");
        } else {
            System.out.println("AIM-120 AMRAAM is not armed.");
        }
    }

    // Optional: status display
    public void displayInfo() {
        System.out.println("Missile: " + getName());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Range: " + getRange() + " km");
        System.out.println("Guidance: " + getGuidanceSystem());
        System.out.println("Speed: Mach " + getSpeed());
        System.out.println("Radar Mode: " + radarMode);
    }
}
