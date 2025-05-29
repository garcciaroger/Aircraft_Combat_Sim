//Importing Libraries
package Aircraft_Configuration;
import Aircraft_Simulator.Aircraft.Aircraft;
import Aircraft_Simulator.Defense.*;
import Aircraft_Simulator.Planes.F35.F35A;
import Aircraft_Simulator.TargetingSystem.Targeting;
import Weapons.Weapon;
import Weapons.Bombs.GBU22;
import Weapons.Bombs.MAKO;
import Weapons.Missile.AIM120;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class LoadoutSelector {
    // Main method to build and return an AirplaneConfig
    public AirplaneConfig selectLoadout() {
        Scanner scanner = new Scanner(System.in);
        // 1. Aircraft Selection (placeholder)
        System.out.println("Select Aircraft: ");
        System.out.println("1. F-35A");
        System.out.println("2. F-22");
        System.out.println("3. F-15EX");
        System.out.println("4. F-16");
        //Selection
        int choice = scanner.nextInt();
        Aircraft selectedAircraft = null;
        // TODO: Present options and instantiate the chosen aircraft
        switch (choice) {
            case 1:
                selectedAircraft = new F35A();                
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                throw new AssertionError();
        }
        // 2. Defense Systems Selection (placeholder)
        List<Defense> defenses = new ArrayList<>();
        defenses.add(new ChaffFlairs(10,8));
        // 3. Targeting Systems Selection (placeholder)
        // TODO: Present targeting options and add selected ones to the list
        // 4. Weapons Loadout Selection (placeholder)
        List<Weapon> loadout = new ArrayList<>();
        while (true) {
            System.out.println("Select Weapons (type number, 0 to finish): ");
            System.out.println("1. AIM-120");
            System.out.println("2. Mako Hypersonic");
            System.out.println("3. GBU22");

            int weaponChoice = scanner.nextInt();
            if (weaponChoice == 0) break;

            switch (weaponChoice) {
                case 1:
                    loadout.add(new AIM120());
                    System.out.println("AIM-120 added to loadout.");
                    break;
                case 2:
                    loadout.add(new MAKO()); 
                    System.out.println("Mako Hypersonic added to loadout.");
                    break;
                case 3:
                    loadout.add(new GBU22());
                    System.out.println("GBU-22 added to loadout.");
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }

        // TODO: Present weapon options and add selected ones to the list

        // 5. Build and return AirplaneConfig
        AirplaneConfig config = new AirplaneConfig(selectedAircraft, defenses, targeting, loadout);
        return config;
    }
}
