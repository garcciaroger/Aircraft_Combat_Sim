package Aircraft_Configuration;

//Aircraft Imports
import Aircraft_Simulator.Aircraft_Base.*;
import Aircraft_Simulator.Defense_Base.*;
import Aircraft_Simulator.Planes.*;
import Aircraft_Simulator.TargetingSystem.*;

public class AirplaneConfig {
    private Aircraft aircraft;
    private List<DefenseSystem> defenses;
    private List<TargetingSystem> targetingSystems;

    public AirplaneConfig(Aircraft aircraft, List<DefenseSystem> defenses, List<TargetingSystem> targetingSystems) {
        this.aircraft = aircraft;
        this.defenses = defenses;
        this.targetingSystems = targetingSystems;
    }

    // Getters
    public Aircraft getAircraft() {
        return aircraft;
    }

    public List<DefenseSystem> getDefenses() {
        return defenses;
    }

    public List<TargetingSystem> getTargetingSystems() {
        return targetingSystems;
    }

    // Setters
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void setDefenses(List<DefenseSystem> defenses) {
        this.defenses = defenses;
    }

    public void setTargetingSystems(List<TargetingSystem> targetingSystems) {
        this.targetingSystems = targetingSystems;
    }

    // Add more methods as needed for your configuration logic
}