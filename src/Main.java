import PlaneObjects.Interfaces.Components.Engine;
import PlaneObjects.Models.Fighters.F35A.F35A;

public class Main {
    public static void main(String[] args) {
        F35A jet = new F35A();

        System.out.println("=== F-35A Engine Info ===");

        Engine engine = jet.getEngine(); // Abstract reference

        System.out.println("Manufacturer    : " + engine.getManufacturer());
        System.out.println("Model           : " + engine.getModelName());
        System.out.println("Type            : " + engine.getType());
        System.out.println("Thrust          : " + engine.getThrust() + " lbf");
        System.out.println("Fuel Rate       : " + engine.getFuelConsumptionRate() + " gal/hr");
        System.out.println("Operational     : " + (engine.isOperational() ? "YES" : "NO"));
    }
}