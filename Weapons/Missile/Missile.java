package Weapons.Missile;
import Weapons.Weapon;

public class Missile extends Weapon {
    private String guidanceSystem; // e.g., Radar, Infrared
    private double speed; // in Mach

    public Missile(String name, int weight, int range, String guidanceSystem, double speed) {
        super(name, weight, range);
        this.guidanceSystem = guidanceSystem;
        this.speed = speed;
    }

    public String getGuidanceSystem() { return guidanceSystem; }
    public double getSpeed() { return speed; }

    @Override
    public void fire(String target) {
        if (isArmed()) {
            System.out.println("Firing missile " + getName() + " at " + target + " using " + guidanceSystem + " guidance.");
        } else {
            System.out.println("Missile " + getName() + " is not armed.");
        }
    }
}