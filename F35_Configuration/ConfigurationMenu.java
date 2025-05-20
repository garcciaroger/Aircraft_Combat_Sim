package F35_Configuration;

import F35_Class.Variants.F35A;
import F35_Class.Variants.F35B; // Correct import for the F35 class
import F35_Class.Variants.F35C; // Correct import for the F35 class
import Weapons.Bombs.GBU22;
import Weapons.Bombs.MAKO;
import Weapons.Missile.AIM120;
import java.util.Scanner;

public class ConfigurationMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== F-35 Simulator Main Menu ===");
            System.out.println("1. View Plane Options and Capabilities");
            System.out.println("2. Enter Configuration Mode for Missions");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View Plane Options and Capabilities
                    displayPlaneOptions();
                    break;
                case 2:
                    // Enter Configuration Mode for Missions
                    enterConfigurationMode();
                    break;
                case 3:
                    // Exit the program
                    System.out.println("Exiting the simulator. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
 
        }
    }
}