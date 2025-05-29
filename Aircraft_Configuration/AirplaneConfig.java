//Packages
package Aircraft_Configuration;
//Importing package
import Aircraft_Simulator.Aircraft.Aircraft;
import Aircraft_Simulator.Defense.*;
import Aircraft_Simulator.TargetingSystem.Targeting;
import Weapons.Weapon;
import java.util.List;
//Airplane Configration Class
public class AirplaneConfig {
    private Aircraft aircraft;
    private List<Defense> defenses;
    private List<Targeting> targeting;
    private List<Weapon> loadout;
    // Constructor
    public AirplaneConfig(
            Aircraft aircraft,
            List<Defense> defenses,
            List<Targeting> targeting,
            List<Weapon> loadout) {
        this.aircraft = aircraft;
        this.defenses = defenses;
        this.targeting = targeting;
        this.loadout = loadout;
    }
    // Getters
    public Aircraft getAircraft() { return aircraft; }
    public List<Defense> getDefenses() { return defenses; }
    public List<Targeting> getTargeting() { return targeting; }
    public List<Weapon> getLoadout() { return loadout; }
}
