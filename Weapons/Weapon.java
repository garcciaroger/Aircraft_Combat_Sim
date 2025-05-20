package Weapons;

public abstract class Weapon {
    private String name;
    private int weight; // in lbs
    private int range; // in miles
    private boolean armed;

    public Weapon(String name, int weight, int range) {
        this.name = name;
        this.weight = weight;
        this.range = range;
        this.armed = false;
    }

    public String getName() { return name; }
    public int getWeight() { return weight; }
    public int getRange() { return range; }
    public boolean isArmed() { return armed; }

    public void arm() {
        armed = true;
        System.out.println(name + " is armed.");
    }

    public void disarm() {
        armed = false;
        System.out.println(name + " is disarmed.");
    }

    public abstract void fire(String target);
}