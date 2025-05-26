package Aircraft_Simulator.Planes.F35;
import Aircraft_Simulator.Aircraft_Base.StealthFighter;

public class F35A extends StealthFighter {
    public F35A() {
    super(
        "Lockheed Martin", // manufacturer
        "F-35A Lightning II",     // model
        18700,             // fuelCapacity (int)
        18000,          // payloadCapacity (int)
        50000,              // maxAltitude (int)
        1.6,                   // maxSpeed (double)
        9,                         // maxG (int)
        10,                  // maxWeapons (int)
        0.0015,       // radarCrossSection (double)
        770                // combatRadius (double)
    );
    }
    //Display the F-35A stats
    public void displayF35AStats() {
        System.out.println("F-35A Lightning II Stats:");
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Model: " + getModel());
        System.out.println("Fuel Capacity: " + getFuelCapacity() + " gallons");
        System.out.println("Max Altitude: " + getMaxAltitude() + " feet");
        System.out.println("Combat Radius: " + getCombatRadius() + " nautical miles");
        System.out.println("Payload Capacity: " + getPayloadCapacity() + " pounds");
        System.out.println("Max Speed: " + getMaxSpeed() + " Mach");
        System.out.println("Max G: " + getMaxG());
        System.out.println("Max Weapons: " + getMaxWeapons());
        System.out.println("Radar Cross Section: " + getRadarCrossSection() + " square meters");
    }
}