package Weapons.Bombs;

import Weapons.Weapon;

public class Bomb extends Weapon {
    private String bombType; // e.g., Cluster, Bunker-Buster
    private double blastRadius; // in meters

    public Bomb(String name, int weight, int range, String bombType, double blastRadius) {
        super(name, weight, range);
        this.bombType = bombType;
        this.blastRadius = blastRadius;
    }

    public String getBombType() { return bombType; }
    public double getBlastRadius() { return blastRadius; }

    @Override
    public void fire(String target) {
        if (isArmed()) {
            System.out.println("Dropping bomb " + getName() + " on " + target + ". Type: " + bombType + ", Blast Radius: " + blastRadius + " meters.");
        } else {
            System.out.println("Bomb " + getName() + " is not armed.");
        }
    }
}