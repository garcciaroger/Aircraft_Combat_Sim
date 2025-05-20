package F35_Class;

public class DefenseMechanism {
    // Defense Mechanism Attributes
    private String type; // Type of defense mechanism (e.g., stealth, electronic warfare)
    private String model; // Model of the defense mechanism
    private int range; // Range of the defense mechanism (in miles)
    private String LockType; // Type of lock (e.g., radar, infrared)
    //Constructor
    public DefenseMechanism(String type, String model, int range, String LockType) {
        this.type = type;
        this.model = model;
        this.range = range;
        this.LockType = LockType;
    }
    // Setters
    public void setType(String type) {this.type = type;}
    public void setModel(String model) {this.model = model;}
    public void setRange(int range) {this.range = range;}
    public void setLockType(String LockType) {this.LockType = LockType;}
    // Getters
    public String getType() {return type;}
    public String getModel() {return model;}
    public int getRange() {return range;}
    public String getLockType() {return LockType;}
    // Methods
    public void activate() {System.out.println("Activating " + type + " defense mechanism...");}
    public void deactivate() {System.out.println("Deactivating " + type + " defense mechanism...");}
    public void engage() {System.out.println("Engaging " + type + " defense mechanism...");}
    public void disengage() {System.out.println("Disengaging " + type + " defense mechanism...");}
    public void displayInfo() {
        System.out.println("Defense Mechanism Type: " + type);
        System.out.println("Model: " + model);
        System.out.println("Range: " + range + " miles");
        System.out.println("Lock Type: " + LockType);
    }
}
