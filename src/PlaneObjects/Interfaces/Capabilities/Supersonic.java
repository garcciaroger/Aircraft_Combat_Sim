package PlaneObjects.Interfaces.Capabilities;
public interface Supersonic {
    double MACH_1_KMH = 1235.0; // km/h at sea level
    default boolean isSupersonic(double speedKmh) {
        return speedKmh > MACH_1_KMH;
    }
    default void checkSupersonicStatus(double speedKmh, String aircraftModel) {
        String status = isSupersonic(speedKmh) ? "supersonic" : "subsonic";
        System.out.printf("%s is %s (%.1f km/h)%n", aircraftModel, status, speedKmh);
    }
    default boolean hasSupersonicCapability(double speedKmh) {
        return isSupersonic(speedKmh);
    }
    default double getMachSpeed(double speedKmh) {
        return speedKmh / MACH_1_KMH;
    }
}