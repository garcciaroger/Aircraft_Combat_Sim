import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class CombatSimulatorDemo {
    public static void main(String[] args) {
        // Launch the mission simulator
        JFrame frame = new JFrame("F-35 Combat Mission Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MissionSimulatorPanel());
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    // Mission simulator panel
    static class MissionSimulatorPanel extends JPanel implements ActionListener {
        private Timer timer;
        private int playerX = 100;
        private int playerY = 300;
        private int playerAltitude = 25000; // feet
        private double playerSpeed = 0.9; // Mach
        private int fuel = 100; // percentage
        private boolean stealthActive = false;
        
        private List<EnemyAircraft> enemyAircraft = new ArrayList<>();
        private List<GroundTarget> groundTargets = new ArrayList<>();
        private List<Missile> missiles = new ArrayList<>();
        
        private Mission currentMission;
        private boolean missionStarted = false;
        private boolean missionComplete = false;
        private String missionResult = "";
        
        private Random random = new Random();
        
        // Mission types
        private enum MissionType {
            AIR_SUPERIORITY,
            GROUND_STRIKE,
            MIXED
        }
        
        // Mission class
        private class Mission {
            private MissionType type;
            private String name;
            private String description;
            private int enemiesRequired;
            private int targetsRequired;
            private int enemiesDestroyed;
            private int targetsDestroyed;
            
            public Mission(MissionType type, String name, String description, 
                          int enemiesRequired, int targetsRequired) {
                this.type = type;
                this.name = name;
                this.description = description;
                this.enemiesRequired = enemiesRequired;
                this.targetsRequired = targetsRequired;
                this.enemiesDestroyed = 0;
                this.targetsDestroyed = 0;
            }
            
            public boolean isComplete() {
                return enemiesDestroyed >= enemiesRequired && 
                       targetsDestroyed >= targetsRequired;
            }
            
            public String getStatus() {
                String status = "Mission: " + name + "\n";
                if (type == MissionType.AIR_SUPERIORITY || type == MissionType.MIXED) {
                    status += "Air targets: " + enemiesDestroyed + "/" + enemiesRequired + "\n";
                }
                if (type == MissionType.GROUND_STRIKE || type == MissionType.MIXED) {
                    status += "Ground targets: " + targetsDestroyed + "/" + targetsRequired;
                }
                return status;
            }
        }
        
        // Enemy aircraft class
        private class EnemyAircraft {
            private int x;
            private int y;
            private int altitude;
            private String type;
            private boolean destroyed;
            
            public EnemyAircraft(int x, int y, int altitude, String type) {
                this.x = x;
                this.y = y;
                this.altitude = altitude;
                this.type = type;
                this.destroyed = false;
            }
            
            public void update() {
                if (!destroyed) {
                    // Basic AI - move toward player with some randomness
                    if (x > playerX) x -= 1 + random.nextInt(2);
                    else if (x < playerX) x += 1 + random.nextInt(2);
                    
                    if (y > playerY) y -= random.nextInt(2);
                    else if (y < playerY) y += random.nextInt(2);
                    
                    // Adjust altitude based on player
                    if (Math.abs(altitude - playerAltitude) > 5000) {
                        if (altitude < playerAltitude) altitude += 1000;
                        else altitude -= 1000;
                    }
                }
            }
            
            public boolean checkHit(Missile missile) {
                if (destroyed) return false;
                
                // Check if missile is close enough to hit
                boolean altitudeMatch = Math.abs(altitude - missile.targetAltitude) < 3000;
                boolean positionMatch = Math.abs(x - missile.x) < 20 && Math.abs(y - missile.y) < 20;
                
                if (altitudeMatch && positionMatch) {
                    destroyed = true;
                    currentMission.enemiesDestroyed++;
                    return true;
                }
                return false;
            }
        }
        
        // Ground target class
        private class GroundTarget {
            private int x;
            private int y;
            private String type;
            private boolean destroyed;
            
            public GroundTarget(int x, int y, String type) {
                this.x = x;
                this.y = y;
                this.type = type;
                this.destroyed = false;
            }
            
            public boolean checkHit(Missile missile) {
                if (destroyed) return false;
                
                // Ground targets are at altitude 0
                boolean altitudeMatch = missile.targetAltitude < 3000; // Low enough to hit ground
                boolean positionMatch = Math.abs(x - missile.x) < 30 && Math.abs(y - missile.y) < 30;
                
                if (altitudeMatch && positionMatch) {
                    destroyed = true;
                    currentMission.targetsDestroyed++;
                    return true;
                }
                return false;
            }
        }
        
        // Missile class
        private class Missile {
            private int x;
            private int y;
            private int targetAltitude;
            private int speed;
            private int range;
            private int distanceTraveled;
            private boolean active;
            
            public Missile(int x, int y, int targetAltitude) {
                this.x = x;
                this.y = y;
                this.targetAltitude = targetAltitude;
                this.speed = 15;
                this.range = 500;
                this.distanceTraveled = 0;
                this.active = true;
            }
            
            public void update() {
                if (!active) return;
                
                // Find nearest target and move toward it
                int targetX = getWidth();
                int targetY = y;
                
                // Check for air targets first
                for (EnemyAircraft enemy : enemyAircraft) {
                    if (!enemy.destroyed && Math.abs(enemy.altitude - targetAltitude) < 5000) {
                        // This enemy is at a suitable altitude
                        targetX = enemy.x;
                        targetY = enemy.y;
                        break;
                    }
                }
                
                // If no air target and missile is low enough, check ground targets
                if (targetX == getWidth() && targetAltitude < 10000) {
                    for (GroundTarget target : groundTargets) {
                        if (!target.destroyed) {
                            targetX = target.x;
                            targetY = target.y;
                            break;
                        }
                    }
                }
                
                // Move toward target
                if (x < targetX) x += speed;
                else if (x > targetX) x -= speed;
                
                if (y < targetY) y += speed/2;
                else if (y > targetY) y -= speed/2;
                
                distanceTraveled += speed;
                
                // Check if missile has reached its range limit
                if (distanceTraveled > range) {
                    active = false;
                }
                
                // Check for hits
                for (EnemyAircraft enemy : enemyAircraft) {
                    if (enemy.checkHit(this)) {
                        active = false;
                        break;
                    }
                }
                
                for (GroundTarget target : groundTargets) {
                    if (target.checkHit(this)) {
                        active = false;
                        break;
                    }
                }
            }
        }
        
        public MissionSimulatorPanel() {
            setBackground(new Color(135, 206, 235)); // Sky blue
            timer = new Timer(50, this);
            
            // Add key listeners for controlling the aircraft
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (!missionStarted) {
                        startMission();
                        return;
                    }
                    
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP -> playerY -= 10;
                        case KeyEvent.VK_DOWN -> playerY += 10;
                        case KeyEvent.VK_LEFT -> playerX -= 10;
                        case KeyEvent.VK_RIGHT -> playerX += 10;
                        case KeyEvent.VK_W -> changeAltitude(1000);
                        case KeyEvent.VK_S -> changeAltitude(-1000);
                        case KeyEvent.VK_SPACE -> fireMissile();
                        case KeyEvent.VK_Z -> toggleStealth();
                        case KeyEvent.VK_R -> {
                            if (missionComplete) resetSimulator();
                        }
                    }
                }
            });
        }
        
        private void startMission() {
            // Create a random mission
            MissionType[] types = MissionType.values();
            MissionType missionType = types[random.nextInt(types.length)];
            
            switch (missionType) {
                case AIR_SUPERIORITY:
                    currentMission = new Mission(missionType, "Eagle Eye", 
                        "Eliminate all enemy aircraft in the area to secure air superiority.",
                        3, 0);
                    break;
                case GROUND_STRIKE:
                    currentMission = new Mission(missionType, "Surgical Strike", 
                        "Destroy all ground targets while minimizing collateral damage.",
                        0, 4);
                    break;
                case MIXED:
                    currentMission = new Mission(missionType, "Total Dominance", 
                        "Eliminate both air and ground threats in the combat zone.",
                        2, 2);
                    break;
            }
            
            // Create enemies based on mission type
            if (missionType == MissionType.AIR_SUPERIORITY || missionType == MissionType.MIXED) {
                for (int i = 0; i < currentMission.enemiesRequired; i++) {
                    enemyAircraft.add(new EnemyAircraft(
                        700 + random.nextInt(200),
                        100 + random.nextInt(400),
                        15000 + random.nextInt(20000),
                        random.nextBoolean() ? "MiG-29" : "Su-35"
                    ));
                }
            }
            
            // Create ground targets based on mission type
            if (missionType == MissionType.GROUND_STRIKE || missionType == MissionType.MIXED) {
                String[] targetTypes = {"SAM Site", "Radar Station", "Command Center", "Fuel Depot"};
                for (int i = 0; i < currentMission.targetsRequired; i++) {
                    groundTargets.add(new GroundTarget(
                        500 + random.nextInt(400),
                        100 + random.nextInt(500),
                        targetTypes[random.nextInt(targetTypes.length)]
                    ));
                }
            }
            
            missionStarted = true;
            timer.start();
        }
        
        private void resetSimulator() {
            // Reset all mission variables
            playerX = 100;
            playerY = 300;
            playerAltitude = 25000;
            playerSpeed = 0.9;
            fuel = 100;
            stealthActive = false;
            
            enemyAircraft.clear();
            groundTargets.clear();
            missiles.clear();
            
            missionStarted = false;
            missionComplete = false;
            missionResult = "";
            
            repaint();
        }
        
        private void changeAltitude(int delta) {
            playerAltitude += delta;
            if (playerAltitude < 1000) playerAltitude = 1000;
            if (playerAltitude > 50000) playerAltitude = 50000;
            System.out.println("Altitude: " + playerAltitude + " feet");
        }
        
        private void fireMissile() {
            if (missiles.size() < 6) { // Limit active missiles
                System.out.println("F-35 firing missile!");
                missiles.add(new Missile(playerX + 30, playerY, playerAltitude));
            } else {
                System.out.println("Maximum missiles already in flight!");
            }
        }
        
        private void toggleStealth() {
            stealthActive = !stealthActive;
            System.out.println("Stealth mode: " + (stealthActive ? "ACTIVE" : "INACTIVE"));
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Enable anti-aliasing for smoother shapes
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Draw ground
            g2d.setColor(new Color(101, 67, 33));
            g2d.fillRect(0, getHeight() - 50, getWidth(), 50);
            
            // If mission hasn't started, show start screen
            if (!missionStarted) {
                drawStartScreen(g2d);
                return;
            }
            
            // If mission is complete, show results
            if (missionComplete) {
                drawMissionComplete(g2d);
                return;
            }
            
            // Draw missiles
            for (Missile missile : missiles) {
                if (missile.active) {
                    g2d.setColor(Color.RED);
                    g2d.fillOval(missile.x, missile.y, 6, 6);
                    
                    // Draw missile trail
                    g2d.setColor(new Color(255, 255, 255, 128));
                    g2d.drawLine(missile.x - 10, missile.y, missile.x, missile.y);
                }
            }
            
            // Draw ground targets
            for (GroundTarget target : groundTargets) {
                if (!target.destroyed) {
                    g2d.setColor(Color.DARK_GRAY);
                    g2d.fillRect(target.x - 15, target.y - 15, 30, 30);
                    g2d.setColor(Color.WHITE);
                    g2d.drawString(target.type, target.x - 30, target.y - 20);
                } else {
                    // Draw destroyed target
                    g2d.setColor(new Color(139, 69, 19));
                    g2d.fillOval(target.x - 20, target.y - 20, 40, 40);
                    g2d.setColor(new Color(255, 69, 0));
                    g2d.fillOval(target.x - 10, target.y - 10, 20, 20);
                }
            }
            
            // Draw enemy aircraft
            for (EnemyAircraft enemy : enemyAircraft) {
                if (!enemy.destroyed) {
                    // Draw enemy aircraft
                    drawAircraft(g2d, enemy.x, enemy.y, Color.RED, enemy.type, false);
                    
                    // Draw altitude indicator
                    String alt = (enemy.altitude / 1000) + "k";
                    g2d.setColor(Color.WHITE);
                    g2d.drawString(alt, enemy.x - 5, enemy.y + 30);
                } else {
                    // Draw explosion
                    g2d.setColor(Color.ORANGE);
                    g2d.fillOval(enemy.x - 20, enemy.y - 20, 40, 40);
                    g2d.setColor(Color.RED);
                    g2d.fillOval(enemy.x - 10, enemy.y - 10, 20, 20);
                }
            }
            
            // Draw player aircraft (F-35A)
            drawAircraft(g2d, playerX, playerY, Color.BLUE, "F-35A", stealthActive);
            
            // Draw HUD information
            drawHUD(g2d);
        }
        
        private void drawStartScreen(Graphics2D g) {
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("F-35 Combat Mission Simulator", getWidth()/2 - 250, getHeight()/2 - 100);
            
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Press any key to start a random mission", getWidth()/2 - 150, getHeight()/2);
            
            g.setFont(new Font("Monospaced", Font.PLAIN, 14));
            g.drawString("Controls:", getWidth()/2 - 200, getHeight()/2 + 50);
            g.drawString("Arrow Keys: Move aircraft", getWidth()/2 - 200, getHeight()/2 + 70);
            g.drawString("W/S: Increase/decrease altitude", getWidth()/2 - 200, getHeight()/2 + 90);
            g.drawString("Space: Fire missile", getWidth()/2 - 200, getHeight()/2 + 110);
            g.drawString("Z: Toggle stealth mode", getWidth()/2 - 200, getHeight()/2 + 130);
        }
        
        private void drawMissionComplete(Graphics2D g) {
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Mission Complete: " + missionResult, getWidth()/2 - 250, getHeight()/2 - 50);
            
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Press R to start a new mission", getWidth()/2 - 120, getHeight()/2 + 50);
        }
        
        private void drawHUD(Graphics2D g) {
            // Draw semi-transparent HUD background
            g.setColor(new Color(0, 0, 0, 128));
            g.fillRect(10, 10, 280, 130);
            
            g.setColor(Color.GREEN);
            g.setFont(new Font("Monospaced", Font.BOLD, 14));
            g.drawString("F-35 Combat Mission Simulator", 20, 30);
            g.drawString("Altitude: " + playerAltitude + " ft | Speed: Mach " + playerSpeed, 20, 50);
            g.drawString("Fuel: " + fuel + "% | Stealth: " + (stealthActive ? "ACTIVE" : "INACTIVE"), 20, 70);
            
            // Draw mission status
            String[] missionStatus = currentMission.getStatus().split("\n");
            for (int i = 0; i < missionStatus.length; i++) {
                g.drawString(missionStatus[i], 20, 90 + (i * 20));
            }
            
            // Draw controls reminder
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
            g.drawString("W/S: Alt | Arrows: Move | Space: Fire | Z: Stealth", getWidth() - 350, getHeight() - 60);
        }
        
        private void drawAircraft(Graphics2D g, int x, int y, Color color, String label, boolean stealth) {
            // Set transparency if stealth is active
            if (stealth) {
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            }
            
            // Draw aircraft triangle
            g.setColor(color);
            Polygon aircraft = new Polygon();
            aircraft.addPoint(x + 30, y); // Nose
            aircraft.addPoint(x - 15, y - 15); // Left wing
            aircraft.addPoint(x - 15, y + 15); // Right wing
            g.fillPolygon(aircraft);
            
            // Draw outline
            g.setColor(Color.BLACK);
            g.drawPolygon(aircraft);
            
            // Reset transparency
            if (stealth) {
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            }
            
            // Draw label
            g.setColor(Color.WHITE);
            g.drawString(label, x - 15, y - 20);
            
            // Draw altitude indicator for player
            if (label.startsWith("F-35")) {
                String alt = (playerAltitude / 1000) + "k";
                g.drawString(alt, x - 5, y + 30);
            }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (missionComplete) return;
            
            // Update missiles
            for (int i = missiles.size() - 1; i >= 0; i--) {
                Missile missile = missiles.get(i);
                missile.update();
                if (!missile.active) {
                    missiles.remove(i);
                }
            }
            
            // Update enemy aircraft
            for (EnemyAircraft enemy : enemyAircraft) {
                enemy.update();
            }
            
            // Reduce fuel slowly
            if (fuel > 0) {
                if (random.nextInt(50) == 0) fuel--;
            }
            
            // Check mission completion
            if (currentMission.isComplete()) {
                missionComplete = true;
                missionResult = "SUCCESS";
            } else if (fuel <= 0) {
                missionComplete = true;
                missionResult = "FAILED - Out of fuel";
            }
            
            repaint();
        }
    }
}