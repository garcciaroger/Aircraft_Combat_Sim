package PlaneObjects.Methods;
public interface TakeOff {
    default void takeOff() {
        System.out.println("Aircraft is Taxi and preparing for take off");
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Countdown Interrupted");
                return;
            }
            System.out.println("T-Minus " + i + " ");
        }
        System.out.println("Takeoff!");
    }
}