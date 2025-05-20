package Weapons.Gun;

import Weapons.Weapon;

public class Gun extends Weapon {
    private int rateOfFire; // in rounds per second
    private int ammunitionCapacity;
    private int currentAmmunition;

    public Gun(String name, int weight, int range, int rateOfFire, int ammunitionCapacity) {
        super(name, weight, range);
        this.rateOfFire = rateOfFire;
        this.ammunitionCapacity = ammunitionCapacity;
        this.currentAmmunition = ammunitionCapacity; // Start with full ammunition
    }

    public int getRateOfFire() { return rateOfFire; }
    public int getAmmunitionCapacity() { return ammunitionCapacity; }
    public int getCurrentAmmunition() { return currentAmmunition; }

    public void reload() {
        currentAmmunition = ammunitionCapacity;
        System.out.println(getName() + " reloaded. Ammunition: " + currentAmmunition);
    }

    @Override
    public void fire(String target) {
        if (isArmed() && currentAmmunition > 0) {
            System.out.println("Firing gun " + getName() + " at " + target + ".");
            currentAmmunition -= rateOfFire;
            System.out.println("Remaining ammunition: " + currentAmmunition);
        } else if (!isArmed()) {
            System.out.println("Gun " + getName() + " is not armed.");
        } else {
            System.out.println("Gun " + getName() + " is out of ammunition.");
        }
    }
}