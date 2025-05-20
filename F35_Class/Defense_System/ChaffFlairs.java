package F35_Class.Defense_System;

public class ChaffFlairs {
    //Chaff and flares attributes
    private int chaffCount; // Number of chaff deployed
    private int flareCount; // Number of flares deployed
    private boolean chaffDeployed; // Status of chaff deployment
    private boolean flareDeployed; // Status of flare deployment

    // Constructor
    public ChaffFlairs(int chaffCount, int flareCount) {
        this.chaffCount = chaffCount;
        this.flareCount = flareCount;
        this.chaffDeployed = false;
        this.flareDeployed = false;
    }
    // Getters
    public int getChaffCount() {
        return chaffCount;
    }
    public int getFlareCount() {
        return flareCount;
    }
    public boolean isChaffDeployed() {
        return chaffDeployed;
    }
    public boolean isFlareDeployed() {
        return flareDeployed;
    }
    // Setters
    public void setChaffCount(int chaffCount) {
        this.chaffCount = chaffCount;
    }
    public void setFlareCount(int flareCount) {
        this.flareCount = flareCount;
    }
    // Methods to deploy chaff and flares
    public void deployChaff() {
        if (chaffCount > 0 && !chaffDeployed) {
            chaffDeployed = true;
            chaffCount--;
            System.out.println("Chaff deployed! Remaining chaff: " + chaffCount);
        } else if (chaffDeployed) {
            System.out.println("Chaff already deployed!");
        } else {
            System.out.println("No chaff left to deploy!");
        }
    }
    public void deployFlare() {
        if (flareCount > 0 && !flareDeployed) {
            flareDeployed = true;
            flareCount--;
            System.out.println("Flare deployed! Remaining flares: " + flareCount);
        } else if (flareDeployed) {
            System.out.println("Flare already deployed!");
        } else {
            System.out.println("No flares left to deploy!");
        }
    }
}
