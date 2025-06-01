// package PlaneObjects.Interfaces.Components;

// import PlaneObjects.Weapons.Weapon;
// import java.util.ArrayList;
// import java.util.List;

// public class Hardpoints {
//     private final int maxSlots;
//     private final List<Weapon> mountedWeapons;

//     public Hardpoints(int maxSlots) {
//         this.maxSlots = maxSlots;
//         this.mountedWeapons = new ArrayList<>();
//     }

//     public boolean addWeapon(Weapon weapon) {
//         if (mountedWeapons.size() < maxSlots) {
//             mountedWeapons.add(weapon);
//             System.out.println(weapon.getName() + " loaded onto hardpoint.");
//             return true;
//         } else {
//             System.out.println("No available hardpoints to load " + weapon.getName());
//             return false;
//         }
//     }

//     public void removeWeapon(String weaponName) {
//         mountedWeapons.removeIf(w -> w.getName().equalsIgnoreCase(weaponName));
//         System.out.println(weaponName + " removed from hardpoints.");
//     }

//     public List<Weapon> getMountedWeapons() {
//         return mountedWeapons;
//     }

//     public void displayLoadout() {
//         System.out.println("--- Weapon Loadout ---");
//         if (mountedWeapons.isEmpty()) {
//             System.out.println("No weapons mounted.");
//         } else {
//             for (Weapon w : mountedWeapons) {
//                 System.out.println(w);
//             }
//         }
//     }

//     public int getRemainingSlots() {
//         return maxSlots - mountedWeapons.size();
//     }

//     public int getMaxSlots() {
//         return maxSlots;
//     }
// }