package CreateLoadout;

import Aircraft_Simulator.Aircraft_Base.Aircraft;
import Aircraft_Simulator.Planes.F35.F35A;
import Weapons.Missile.AIM120;
import Weapons.Bombs.MAKO;
import Weapons.Bombs.GBU22;
import java.util.*;

// Make sure you have AircraftLoadout.java in the same CreateLoadout package!
public class LoadoutSelector {
    public AircraftLoadout selectLoadout() {
        Scanner scanner = new Scanner(System.in);
        // Step 1: List available aircraft
        System.out.println("Available Aircraft:");
        System.out.println("1. F-35A Lightning II");
        System.out.println("2. F-22 Raptor");
        System.out.println("3. F-15 Eagle EX");
        System.out.println("4. F-16 Fighting Falcon");
        System.out.print("Select an aircraft by number (1-4): ");
       
        int choice = scanner.nextInt();
        Aircraft selectedAircraft = null;
        switch (choice) {
            case 1:
                selectedAircraft = new F35A();                
                break;
            case 2:
                // Assume F22 Raptor is defined similarly
                System.out.println("F-22 Raptor not implemented yet.");
                return null;
            case 3:
                // Assume F15 Eagle EX is defined similarly
                System.out.println("F-15 Eagle EX not implemented yet.");
                return null;
            case 4:
                // Assume F16 Fighting Falcon is defined similarly
                System.out.println("F-16 Fighting Falcon not implemented yet.");
                return null;
            default:
                System.out.println("Invalid choice. Exiting.");
                return null;
        }

        AircraftLoadout loadout = new AircraftLoadout(selectedAircraft);
        System.out.println("Selected Aircraft: " + selectedAircraft.getModel());

    }
}
