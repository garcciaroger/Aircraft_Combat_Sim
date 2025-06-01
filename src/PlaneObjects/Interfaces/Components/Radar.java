package PlaneObjects.Interfaces.Components;
import java.util.ArrayList;
import java.util.List;

public class Radar {
    private String model;
    private int range; // in nautical miles
    private boolean active;
    private List<String> detectedTargets;

    public Radar(String model, int range) {
        this.model = model;
        this.range = range;
        this.active = false;
        this.detectedTargets = new ArrayList<>();
    }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public void activate() {
        active = true;
        System.out.println(model + " activated. Scanning for targets...");
        scanForTargets();
    }

    public void deactivate() {
        active = false;
        System.out.println(model + " deactivated.");
    }

    private void scanForTargets() {
        if (!active) {
            System.out.println(model + " is off. Cannot scan.");
            return;
        }
        detectedTargets.clear();
        detectedTargets.add("Enemy Aircraft - 45nm");
        detectedTargets.add("Surface Target - 30nm");

        System.out.println("Targets detected by " + model + ":");
        for (String target : detectedTargets) {
            System.out.println("→ " + target);
        }
    }

    public List<String> getDetectedTargets() {
        return detectedTargets;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return model + " (Range: " + range + " nm)";
    }
}