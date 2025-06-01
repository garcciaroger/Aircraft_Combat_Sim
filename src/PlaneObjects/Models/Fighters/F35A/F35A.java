package PlaneObjects.Models.Fighters.F35A;

import PlaneObjects.Interfaces.Capabilities.Nuclear;
import PlaneObjects.Interfaces.Capabilities.Stealth;
import PlaneObjects.Interfaces.Capabilities.Supersonic;
import PlaneObjects.Interfaces.Components.Engine;
import PlaneObjects.Interfaces.Components.Radar;
import PlaneObjects.Interfaces.Defense.ChaffFlares;
import PlaneObjects.Models.BaseFile.Fighter;

public class F35A extends Fighter implements Nuclear, Supersonic, Stealth {

    private int nuclearPayloadCount = 2;
    private boolean stealthActive = false;

    public F35A() {
        super(
            "Lockheed Martin",                          // Manufacturer
            "F-35A",                                    // Model
            1960,                                       // Max Speed (km/h)
            18000,                                      // Max Takeoff Weight (kg)
            1,                                          // Crew Capacity
            new Engine("Pratt & Whitney", "F135", "Turbofan", 43000, 35.5), // Engine
            18000,                                      // Fuel Capacity (gallons)
            50000,                                      // Max Altitude (feet)
            1380.0,                                     // Range (nautical miles)
            9,                                          // Max G
            true,                                       // Has Afterburner
            1.07,                                       // Thrust-to-Weight Ratio
            new ChaffFlares(),                          // Countermeasure system
            new Radar("AN/APG-81 AESA", 150)            // Radar (range in nm)
        );
    }

    // Nuclear Interface
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
        return true;
    }

    // Stealth Interface
    @Override
    public boolean hasStealthCapability() {
        return true;
    }

    @Override
    public boolean isStealthActive() {
        return stealthActive;
    }

    @Override
    public void setStealthActive(boolean active) {
        this.stealthActive = active;
    }

    @Override
    public int getStealthLevel() {
        return 9;
    }

    // Supersonic Capability handled via maxSpeed and instanceof

    @Override
    public String toString() {
        return super.toString() + String.format("""
            Variant             : F-35A Lightning II
            Nuclear Capable     : %s
            Stealth Capable     : %s
            Stealth Active      : %s (Level %d)
            Supersonic Capable  : %s
            """,
            isNuclearCapable() ? "YES" : "NO",
            hasStealthCapability() ? "YES" : "NO",
            isStealthActive() ? "YES" : "NO", getStealthLevel(),
            hasSupersonicCapability(getMaxSpeed()) ? "YES" : "NO"
        );
    }
}