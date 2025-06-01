package PlaneObjects.Interfaces.Capabilities;

public interface Stealth {
    boolean isStealthActive();
    void setStealthActive(boolean status);
    int getStealthLevel(); // Level 1-10, or a rating of stealth effectiveness

    default boolean hasStealthCapability() {
        return true; // Override if needed
    }

    default void activateStealthMode() {
        if (!isStealthActive()) {
            setStealthActive(true);
            System.out.println("🔇 Activating radar-evading stealth systems...");
        } else {
            System.out.println("🟢 Stealth is already active.");
        }
    }

    default void deactivateStealthMode() {
        if (isStealthActive()) {
            setStealthActive(false);
            System.out.println("🔊 Deactivating stealth systems...");
        } else {
            System.out.println("⚠️ Stealth is already off.");
        }
    }

    default void stealthStatusReport() {
        String status = isStealthActive() ? "ACTIVE" : "INACTIVE";
        System.out.printf("🛡 Stealth Status: %s | Effectiveness Level: %d%n", status, getStealthLevel());
    }
}