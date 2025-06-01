package PlaneObjects.Models.BaseFile;

import PlaneObjects.Interfaces.Components.Engine;
import PlaneObjects.Interfaces.Components.Radar;
import PlaneObjects.Interfaces.Defense.ChaffFlares;

public class Fighter extends Aircraft {
    private final int maxG;
    private final boolean hasAfterBurner;
    private final double thrustWeightRatio;

    private ChaffFlares countermeasureSystem;
    private Radar radar;

    public Fighter(String manufacturer, String model, double maxSpeed, int maxTakeoffWeight,
                   int crewCapacity, Engine engine, int fuelCapacity, int maxAltitude,
                   double range, int maxG, boolean hasAfterBurner, double thrustWeightRatio,
                   ChaffFlares countermeasureSystem, Radar radar) {

        super(manufacturer, model, maxSpeed, maxTakeoffWeight, crewCapacity,
              engine, fuelCapacity, maxAltitude, range);

        this.maxG = maxG;
        this.hasAfterBurner = hasAfterBurner;
        this.thrustWeightRatio = thrustWeightRatio;

        this.countermeasureSystem = countermeasureSystem;
        this.radar = radar;
    }

    // Getters
    public int getMaxG() { return maxG; }
    public boolean hasAfterBurner() { return hasAfterBurner; }
    public double getThrustWeightRatio() { return thrustWeightRatio; }

    public ChaffFlares getCountermeasureSystem() { return countermeasureSystem; }
    public Radar getRadar() { return radar; }

    public void deployCountermeasures() {
        if (countermeasureSystem != null) {
            countermeasureSystem.deploy(); // Uses ChaffFlares logic
        } else {
            System.out.println("No countermeasure system available.");
        }
    }

    // toString override
    @Override
    public String toString() {
        return super.toString() + String.format("""
            Max G-Force          : %d
            Afterburner          : %s
            Thrust-Weight Ratio  : %.2f
            Radar Installed      : %s
            Countermeasures      : %s
            """,
            maxG,
            hasAfterBurner ? "YES" : "NO",
            thrustWeightRatio,
            radar != null ? "YES" : "NO",
            countermeasureSystem != null ? "YES" : "NO"
        );
    }
}