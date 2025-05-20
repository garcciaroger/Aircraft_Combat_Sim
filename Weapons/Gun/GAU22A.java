package Weapons.Gun;

public class GAU22A extends Gun {
    // GAU-22/A specific attributes
    private boolean stealthModeEnabled;

    // Constructor
    public GAU22A() {
        super("GAU-22/A", 220, 1, 55, 182); // Name, weight, range, rate of fire, ammunition capacity
        this.stealthModeEnabled = false; // Default to stealth mode disabled
    }

    // Getter and Setter for stealth mode
    public boolean isStealthModeEnabled() { return stealthModeEnabled; }
    public void setStealthModeEnabled(boolean stealthModeEnabled) { this.stealthModeEnabled = stealthModeEnabled; }

    // Override fire method to include stealth mode behavior
    @Override
    public void fire(String target) {
        if (isArmed() && getCurrentAmmunition() > 0) {
            if (stealthModeEnabled) {
                System.out.println("Firing GAU-22/A at " + target + " in stealth mode.");
            } else {
                System.out.println("Firing GAU-22/A at " + target + ".");
            }
            int remainingAmmo = getCurrentAmmunition() - getRateOfFire();
            setCurrentAmmunition(remainingAmmo);
            System.out.println("Remaining ammunition: " + remainingAmmo);
        } else if (!isArmed()) {
            System.out.println("GAU-22/A is not armed.");
        } else {
            System.out.println("GAU-22/A is out of ammunition.");
        }
    }

    // Helper method to set current ammunition (not exposed in base class)
    private void setCurrentAmmunition(int ammunition) {
        try {
            java.lang.reflect.Field field = Gun.class.getDeclaredField("currentAmmunition");
            field.setAccessible(true);
            field.set(this, ammunition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
