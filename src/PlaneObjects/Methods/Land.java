package PlaneObjects.Methods;
public interface Land {
    default void land() {
        System.out.println("Aircraft is approaching the runway for landing...");
        for (int i = 3; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Landing in " + i + "...");
        }
        System.out.println("Aircraft has landed safely.");
    }
}