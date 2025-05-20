package F35_Class.Variants;

import F35_Class.Aircraft_Characteristics.FighterJet;

public class F35B extends FighterJet {
    // F35B specific attributes
    private String variant; // Variant type (e.g., A, B, C)

    // Constructor with hardcoded values
    public F35B() {
        super("Lockheed Martin", "F-35B", 15000, 18000, 45000, 1.6, 9, 6); // Hardcoded values
        this.variant = "B";
    }

    // Getter and Setter for variant
    public String getVariant() { return variant; }
    public void setVariant(String variant) { this.variant = variant; }

    // F35B specific methods
    public void verticalTakeOff() {
        System.out.println("F35B performing vertical takeoff...");
    }

    public void hover() {
        System.out.println("F35B hovering in place...");
    }

    public void shortLanding() {
        System.out.println("F35B performing short landing...");
    }

    // Method to display variant-specific details
    public void displayVariantDetails() {
        System.out.println("==========F-35B==========");
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