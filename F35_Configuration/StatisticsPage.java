package F35_Configuration;

import F35_Class.Variants.F35A;
import F35_Class.Variants.F35B; // Correct import for the F35 class
import F35_Class.Variants.F35C; // Correct import for the F35 class
import Weapons.Bombs.GBU22;
import Weapons.Bombs.MAKO;
import Weapons.Missile.AIM120;
import java.util.Scanner;

public class StatisticsPage {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== F-35 Statistics Menu ===");
            System.out.println("1. View Aircraft Variant");
            System.out.println("2. View Weapons Configuration");
            System.out.println("3. View Full Aircraft Statistics");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Creating F35 Objects
                    F35A f35a = new F35A();
                    f35a.displayVariantDetails();
                    F35B f35b = new F35B();
                    f35b.displayVariantDetails();
                    F35C f35c = new F35C();
                    f35c.displayVariantDetails();
                    break;

                case 2:
                    // Display the weapons configuration
                    System.out.println("Weapons Configuration:");
                    if (f35.getWeapons().isEmpty()) {
                        System.out.println("- No weapons configured.");
                    } else {
                        for (int i = 0; i < f35.getWeapons().size(); i++) {
                            System.out.println((i + 1) + ". " + f35.getWeapons().get(i).getName());
                        }
                    }
                    break;
                case 3:
                    // Display full aircraft statistics
                    displayFullStatistics(f35);
                    break;
                case 4:
                    // Return to the main menu
                    System.out.println("Returning to the main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}