package PlaneObjects.Interfaces.Capabilities;

public interface Nuclear {
    int getNuclearPayloadCount();  
    void setNuclearPayloadCount(int count);

    boolean isNuclearCapable(); // NEW - true if aircraft design supports nuclear weapons

    default void deployNuclearPayload() {
        if (!isNuclearCapable()) {
            System.out.println("❌ This aircraft is not nuclear-capable.");
            return;
        }

        if (getNuclearPayloadCount() > 0) {
            System.out.println("⚠️ Deploying nuclear payload...");
            setNuclearPayloadCount(getNuclearPayloadCount() - 1);
            System.out.println("Remaining nuclear payloads: " + getNuclearPayloadCount());
        } else {
            System.out.println("❌ No nuclear payloads remaining.");
        }
    }

    default boolean hasNuclearPayload() {
        return getNuclearPayloadCount() > 0;
    }
}