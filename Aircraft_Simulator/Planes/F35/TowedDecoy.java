package Aircraft_Simulator.Planes.F35;
import Aircraft_Simulator.Defense_Base.Defense;

public class TowedDecoy extends Defense {
    // Towed Decoy Attributes
    private String decoyType;           // Type of decoy (e.g., radar)
    private boolean mimicRadarSignal;   // Mimic radar signal status
    private double length;              // Length in meters
    private double weight;              // Weight in kg
    private boolean deployed;           // Deployment status

    // No-argument constructor: hardcoded for F-35 (ALE-70 style)
    public TowedDecoy() {
        super(
            "Radar Decoy",    // type
            "ALE-70",         // model
            10,               // range in miles (example)
            "radar"           // lockType
        );
        this.decoyType = "Radar";
        this.mimicRadarSignal = false;
        this.length = 5.5;    // meters (example)
        this.weight = 20.0;   // kg (example)
        this.deployed = false;
    }

    // Parameterized constructor (optional/flexible)
    public TowedDecoy(String type, String model, int range, String lockType,
                      String decoyType, double length, double weight) {
        super(type, model, range, lockType);
        this.decoyType = decoyType;
        this.mimicRadarSignal = false;
        this.length = length;
        this.weight = weight;
        this.deployed = false;
    }

    // Setters
    public void setDecoyType(String decoyType) { this.decoyType = decoyType; }
    public void setLength(double length) { this.length = length; }
    public void setMimicRadarSignal(boolean mimicRadarSignal) { this.mimicRadarSignal = mimicRadarSignal; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setDeployed(boolean deployed) { this.deployed = deployed; }

    // Getters
    public String getDecoyType() { return decoyType; }
    public boolean isMimicRadarSignal() { return mimicRadarSignal; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public boolean isDeployed() { return deployed; }

    // Methods
    @Override
    public void activate() {
        deploy();
    }

    @Override
    public void deactivate() {
        retract();
    }

    public void deploy() {
        if (!deployed) {
            deployed = true;
            System.out.println("Deploying Towed Decoy...");
        } else {
            System.out.println("Towed Decoy is already deployed.");
        }
    }

    public void retract() {
        if (deployed) {
            deployed = false;
            System.out.println("Retracting Towed Decoy...");
        } else {
            System.out.println("Towed Decoy is not deployed.");
        }
    }

    public void startMimicRadar() {
        if (deployed && !mimicRadarSignal) {
            mimicRadarSignal = true;
            System.out.println("Towed Decoy is now mimicking radar signature!");
        } else if (!deployed) {
            System.out.println("Cannot mimic radar signature. Decoy is not deployed.");
        } else {
            System.out.println("Towed Decoy is already mimicking radar signature.");
        }
    }

    public void stopMimicRadar() {
        if (mimicRadarSignal) {
            mimicRadarSignal = false;
            System.out.println("Towed Decoy stopped mimicking radar signature.");
        } else {
            System.out.println("Towed Decoy is not mimicking radar signature.");
        }
    }

    public void displayStatus() {
        System.out.println("--- Towed Decoy Status ---");
        System.out.println("Type: " + getType());
        System.out.println("Model: " + getModel());
        System.out.println("Range: " + getRange() + " miles");
        System.out.println("Lock Type: " + getLockType());
        System.out.println("Decoy Type: " + decoyType);
        System.out.println("Deployed: " + deployed);
        System.out.println("Mimic Radar: " + mimicRadarSignal);
        System.out.println("Length: " + length + " meters");
        System.out.println("Weight: " + weight + " kg");
    }
}
