package F35_Class.Variants;

import F35_Class.Aircraft_Characteristics.FighterJet;

public class F35A extends FighterJet {
    // F35A specific attributes
    private String variant; // Variant type (e.g., A, B, C)

    // Constructor with hardcoded values
    public F35A() {
        super("Lockheed Martin", "F-35A", 18000, 20000, 50000, 1.6, 9, 6); // Hardcoded values
        this.variant = "A";
    }

    // Getter and Setter for variant
    public String getVariant() { return variant; }
    public void setVariant(String variant) { this.variant = variant; }

    // F35A specific methods
    public void performStealthMission() {
        System.out.println("F35A performing a stealth mission...");
    }

    // Method to display variant-specific details
    public void displayVariantDetails() {
        System.out.println("==========F-35A==========");
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Model: " + getVariant());
        System.out.println("Payload Capacity: " + getPayloadCapacity());
        System.out.println("Fuel Capacity: " + getFuelCapacity());
        System.out.println("Max Altitude: " + getAltitude());
    }

    @Override
    public void displayJetStats() {
        super.displayJetStats();
        System.out.println("Variant: " + variant);
    }
}