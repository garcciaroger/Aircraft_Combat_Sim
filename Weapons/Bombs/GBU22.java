package Weapons.Bombs;

public class GBU22 extends Bomb {
    private boolean precisionGuidance; // Indicates if precision guidance is enabled

    // Constructor
    public GBU22(boolean precisionGuidance) {
        super("GBU-22 Bomb", 2500, 20, "Guided", 600); // Name, weight, range, bomb type, blast radius
        this.precisionGuidance = precisionGuidance;
    }

    // Getter and Setter for precision guidance
    public boolean isPrecisionGuidanceEnabled() { return precisionGuidance; }
    public void setPrecisionGuidance(boolean precisionGuidance) { this.precisionGuidance = precisionGuidance; }

    // Override fire method to include precision guidance behavior
    @Override
    public void fire(String target) {
        if (isArmed()) {
            if (precisionGuidance) {
                System.out.println("Dropping GBU-22 Bomb on " + target + " with precision guidance.");
            } else {
                System.out.println("Dropping GBU-22 Bomb on " + target + " with standard guidance.");
            }
        } else {
            System.out.println("GBU-22 Bomb is not armed.");
        }
    }
}