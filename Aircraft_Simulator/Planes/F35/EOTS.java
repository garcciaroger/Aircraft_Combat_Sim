package Aircraft_Simulator.Planes.F35;
import Aircraft_Simulator.TargetingSystem.Targeting;

public class EOTS extends Targeting {
    private String[] targetList = new String[10];
    private int targetCount = 0;

    // No-argument constructor with hardcoded values
    public EOTS() {
        super("EOTS", "Infrared/Electro-Optical", "High", true, 50); // 50 nm range
    }

    // Parameterized constructor for flexibility
    public EOTS(String sensorType, String resolution, boolean nightVision, double targetingRange) {
        super("EOTS", sensorType, resolution, nightVision, targetingRange);
    }

    // Target management methods
    @Override
    public void engage() {
        if (active) {
            System.out.println("EOTS engaging targets...");
        } else {
            System.out.println("EOTS is not active.");
        }
    }

    @Override
    public void disengage() {
        if (active) {
            System.out.println("EOTS disengaging targets...");
        } else {
            System.out.println("EOTS is not active.");
        }
    }

    @Override
    public void addTarget(String target) {
        if (targetCount < targetList.length) {
            targetList[targetCount++] = target;
            System.out.println("Target " + target + " added to EOTS.");
        } else {
            System.out.println("Target list full.");
        }
    }

    @Override
    public void displayTargets() {
        System.out.println("EOTS Tracked Targets:");
        for (int i = 0; i < targetCount; i++) {
            System.out.println(" - " + targetList[i]);
        }
    }
}
