package CreateLoadout;

import Aircraft_Simulator.Aircraft_Base.Aircraft;
import Weapons.Bombs.Bomb;
import Weapons.Missile.Missile;
import java.util.*;

public class AircraftLoadout {
    private Aircraft aircraft;
    private List<Missile> missiles;
    private List<Bomb> bombs;

    public AircraftLoadout(Aircraft aircraft) {
        this.aircraft = aircraft;
        this.missiles = new ArrayList<>();
        this.bombs = new ArrayList<>();
    }

    public Aircraft getAircraft() { return aircraft; }
    public List<Missile> getMissiles() { return missiles; }
    public List<Bomb> getBombs() { return bombs; }

    public void addMissile(Missile missile) { missiles.add(missile); }
    public void addBomb(Bomb bomb) { bombs.add(bomb); }

    public int getTotalOrdnanceWeight() {
        int total = 0;
        for (Missile m : missiles) total += m.getWeight();
        for (Bomb b : bombs) total += b.getWeight();
        return total;
    }

    public void displayLoadout() {
        System.out.println("Aircraft: " + aircraft.getModel());
        System.out.println("Missiles:");
        for (Missile m : missiles) System.out.println(" - " + m.getName());
        System.out.println("Bombs:");
        for (Bomb b : bombs) System.out.println(" - " + b.getName());
    }
}
