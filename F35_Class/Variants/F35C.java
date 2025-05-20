package F35_Class.Variants;

import F35_Class.Aircraft_Characteristics.FighterJet;

public class F35C extends FighterJet {
    // F35C specific attributes
    private String variant; // Variant type (e.g., A, B, C)

    // Constructor with hardcoded values
    public F35C() {
        super("Lockheed Martin", "F-35C", 16000, 19000, 48000, 1.6, 9, 6); // Hardcoded values
        this.variant = "C";
    }

    // Getter and Setter for variant
    public String getVariant() { return variant; }
    public void setVariant(String variant) { this.variant = variant; }

    // F35C specific methods
    public void carrierLanding() {
        System.out.println("F35C performing carrier landing...");
    }

    public void foldWings() {
        System.out.println("F35C folding wings for carrier storage...");
    }

    // Method to display variant-specific details
    public void displayVariantDetails() {
        System.out.println("==========F-35C==========");
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