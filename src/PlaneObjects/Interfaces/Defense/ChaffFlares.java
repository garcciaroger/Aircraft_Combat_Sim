package PlaneObjects.Interfaces.Defense;
public class ChaffFlares {
    private int chaffCount;
    private int flareCount;
    private final int maxChaff;
    private final int maxFlare;

    public ChaffFlares() {
        this(10, 8); // Default counts
    }

    public ChaffFlares(int maxChaff, int maxFlare) {
        this.maxChaff = maxChaff;
        this.maxFlare = maxFlare;
        this.chaffCount = maxChaff;
        this.flareCount = maxFlare;
    }

    public void deploy() {
        if (chaffCount > 0 && flareCount > 0) {
            chaffCount--;
            flareCount--;
            System.out.println("Deploying chaff and flares!");
            System.out.printf("Remaining: %d chaff, %d flares%n", chaffCount, flareCount);
        } else {
            System.out.println("No countermeasures left to deploy.");
        }
    }

    public void reload() {
        chaffCount = maxChaff;
        flareCount = maxFlare;
        System.out.println("Countermeasures reloaded to max capacity.");
    }

    // Optional getters if you want to access counts
    public int getChaffCount() { return chaffCount; }
    public int getFlareCount() { return flareCount; }
    public int getMaxChaff() { return maxChaff; }
    public int getMaxFlare() { return maxFlare; }
}