package Aircraft_Simulator.Planes.F35;

public class DAS {
    private static final int SENSOR_COUNT = 6;
    private static final int COVERAGE_DEGREES = 360;
    private static final String SYSTEM_NAME = "AN/AAQ-37 DAS";
    private static final String PLATFORM = "F-35 Lightning II";
    private static final boolean MISSILE_WARNING = true;

    private boolean infraredSensorsActive;
    private boolean radarSensorsActive;

    public DAS() {
        this.infraredSensorsActive = false;
        this.radarSensorsActive = false;
    }

    // Getters for hardcoded attributes
    public int getSensorCount() { return SENSOR_COUNT; }
    public int getCoverageDegrees() { return COVERAGE_DEGREES; }
    public String getSystemName() { return SYSTEM_NAME; }
    public String getPlatform() { return PLATFORM; }
    public boolean hasMissileWarning() { return MISSILE_WARNING; }

    // Getters/Setters for runtime status
    public boolean isInfraredSensorsActive() { return infraredSensorsActive; }
    public boolean isRadarSensorsActive() { return radarSensorsActive; }
    public void setInfraredSensorsActive(boolean status) { this.infraredSensorsActive = status; }
    public void setRadarSensorsActive(boolean status) { this.radarSensorsActive = status; }

    public void activateInfraredSensors() {
        if (!infraredSensorsActive) {
            infraredSensorsActive = true;
            System.out.println("Infrared sensors activated.");
        } else {
            System.out.println("Infrared sensors already active.");
        }
    }

    public void deactivateInfraredSensors() {
        if (infraredSensorsActive) {
            infraredSensorsActive = false;
            System.out.println("Infrared sensors deactivated.");
        } else {
            System.out.println("Infrared sensors already inactive.");
        }
    }

    public void activateRadarSensors() {
        if (!radarSensorsActive) {
            radarSensorsActive = true;
            System.out.println("Radar sensors activated.");
        } else {
            System.out.println("Radar sensors already active.");
        }
    }

    public void deactivateRadarSensors() {
        if (radarSensorsActive) {
            radarSensorsActive = false;
            System.out.println("Radar sensors deactivated.");
        } else {
            System.out.println("Radar sensors already inactive.");
        }
    }

    // Display method
    public void displayStatus() {
        System.out.println("--- DAS Status ---");
        System.out.println("System: " + SYSTEM_NAME);
        System.out.println("Platform: " + PLATFORM);
        System.out.println("Sensors: " + SENSOR_COUNT + " IR");
        System.out.println("Coverage: " + COVERAGE_DEGREES + "°");
        System.out.println("Missile Warning: " + (MISSILE_WARNING ? "Enabled" : "Disabled"));
        System.out.println("Infrared Sensors Active: " + infraredSensorsActive);
        System.out.println("Radar Sensors Active: " + radarSensorsActive);
    }
}
