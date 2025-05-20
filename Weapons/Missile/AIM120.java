package Weapons.Missile;
import Weapons.Weapon;

public class AIM120 extends Missile {
    // AIM-120 specific attributes
    private String radarMode; // e.g., Active, Semi-Active

    // Constructor
    public AIM120(String radarMode) {
        super("AIM-120 AMRAAM", 335, 100, "Radar", 4.0); // Name, weight, range, guidance system, speed
        this.radarMode = radarMode;
    }

    // Getter and Setter for radarMode
    public String getRadarMode() { return radarMode; }
    public void setRadarMode(String radarMode) { this.radarMode = radarMode; }

    // AIM-120 specific behavior
    @Override
    public void fire(String target) {
        if (isArmed()) {
            System.out.println("Firing AIM-120 AMRAAM at " + target + " in " + radarMode + " radar mode.");
        } else {
            System.out.println("AIM-120 AMRAAM is not armed.");
        }
    }
}