package PlaneObjects.Models.BaseFile;

import PlaneObjects.Interfaces.Capabilities.Nuclear;
import PlaneObjects.Interfaces.Capabilities.Stealth;
import PlaneObjects.Interfaces.Capabilities.Supersonic;
import PlaneObjects.Interfaces.Components.Engine;

public class Bomber extends Aircraft implements Nuclear, Supersonic, Stealth {

    private int bombBayCapacity;       // in pounds
    private boolean isNuclearCapable;  // indicates if this aircraft supports nuclear payloads
    private int nuclearPayloadCount;

    private boolean isStealthActive;
    private int stealthLevel;

    public Bomber(String manufacturer, String model, double maxSpeed, int maxTakeoffWeight,
                  int crewCapacity, Engine engine, int fuelCapacity, int maxAltitude,
                  double range, int bombBayCapacity, boolean isNuclearCapable, int nuclearPayloadCount) {

        super(manufacturer, model, maxSpeed, maxTakeoffWeight, crewCapacity,
              engine, fuelCapacity, maxAltitude, range);

        this.bombBayCapacity = bombBayCapacity;
        this.isNuclearCapable = isNuclearCapable;
        this.nuclearPayloadCount = nuclearPayloadCount;

        this.isStealthActive = false;
        this.stealthLevel = 5;
    }

    // === Nuclear Interface Implementation ===
    @Override
    public int getNuclearPayloadCount() {
        return nuclearPayloadCount;
    }

    @Override
    public void setNuclearPayloadCount(int count) {
        this.nuclearPayloadCount = count;
    }

    @Override
    public boolean isNuclearCapable() {
        return isNuclearCapable;
    }

    // === Stealth Interface Implementation ===
    @Override
    public boolean isStealthActive() {
        return isStealthActive;
    }

    @Override
    public void setStealthActive(boolean active) {
        this.isStealthActive = active;
    }

    @Override
    public int getStealthLevel() {
        return stealthLevel;
    }

    public void setStealthLevel(int level) {
        this.stealthLevel = level;
    }

    // === Custom ===
    public int getBombBayCapacity() {
        return bombBayCapacity;
    }

    public void setBombBayCapacity(int bombBayCapacity) {
        this.bombBayCapacity = bombBayCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("""
            Bomb Bay Capacity   : %d lbs
            Nuclear Capable     : %s
            Nuclear Payloads    : %d
            Stealth Active      : %s
            Stealth Level       : %d
            """,
            bombBayCapacity,
            isNuclearCapable ? "YES" : "NO",
            nuclearPayloadCount,
            isStealthActive ? "YES" : "NO",
            stealthLevel
        );
    }
}