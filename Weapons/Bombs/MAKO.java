package Weapons.Bombs;

public class MAKO extends Bomb {
    private boolean hypersonicMode; // Indicates if hypersonic mode is enabled

    // Constructor
    public MAKO(boolean hypersonicMode) {
        super("MAKO Missile", 500, 200, "Infrared and GPS", 5.0); // Name, weight, range, guidance system, speed (Mach)
        this.hypersonicMode = hypersonicMode;
    }

    // Getter and Setter for hypersonic mode
    public boolean isHypersonicModeEnabled() { return hypersonicMode; }
    public void setHypersonicMode(boolean hypersonicMode) { this.hypersonicMode = hypersonicMode; }

    // Override fire method to include hypersonic mode behavior
    @Override
    public void fire(String target) {
        if (isArmed()) {
            if (hypersonicMode) {
                System.out.println("Firing MAKO Missile at " + target + " in hypersonic mode at Mach 5+ speed.");
            } else {
                System.out.println("Firing MAKO Missile at " + target + " in standard mode.");
            }
        } else {
            System.out.println("MAKO Missile is not armed.");
        }
    }
}