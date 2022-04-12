package Characters;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * Class for the Enemy, which will chase the player when the player in view range or move randomly when far from the player.
 * But has half speed of the player
 *
 * @author Yuwen Jia
 */
public class Enemy extends Character {
    int viewRange;
    boolean chase;

    /**
     * Creates an Enemy with the given parameters
     *
     * @param location  a point where Character is located
     * @param texture   an Image that represents the Character
     * @param map       game panel that the Character belongs
     * @param viewRange the range that this Enemy can view
     */
    public Enemy(int viewRange, Image texture, Point location, GamePanel map) {
        super(location, texture, map);
        this.viewRange = viewRange;
        super.type = "Police";
    }

    /**
     * Accessors methods
     */

    /**
     * Calculate the distance between the enemy and player.
     *
     * @param p Player object that this Enemy is chasing
     * @return this Enemy's distance towards the Player
     */
    public int getDistance(Player p) {
        return Math.abs(p.getLocation().x - super.getLocation().x) + Math.abs(p.getLocation().y - super.getLocation().y);
    }

    /**
     * The enemy will move closer to player when the player in enemy's view range. If there is a BarrierGrass then move
     * another way.
     *
     * @param p The Player that this Enemy is chasing
     * @return the number of times that the enemy fail to move.
     */
    private int tightChase(Player p) {
        int times = 0;
        boolean check = true;
        while (check) {
            times++;
            int random1 = (int) (Math.random() * (2));
            if (p.getLocation().x - this.getLocation().x == 0) {
                random1 = 1;
            }
            if (p.getLocation().y - this.getLocation().y == 0) {
                random1 = 0;
            }
            if (random1 == 0) {
                if (p.getLocation().x - this.getLocation().x < 0) {
                    if (super.moveLeft())
                        check = false;
                } else {
                    if (super.moveRight())
                        check = false;
                }
            } else {
                if (p.getLocation().y - this.getLocation().y < 0) {
                    if (super.moveUp())
                        check = false;
                } else {
                    if (super.moveDown())
                        check = false;
                }
            }
            if (times == 4) {
                break;
            }
        }
        return times;
    }

    /**
     * When the enemy is far from the player, the enemy will move randomly
     *
     * @param p The Player that this Enemy is chasing
     */
    private void randomChase(Player p) {
        boolean check = true;
        while (check) {
            int random2 = (int) (Math.random() * (4));
            if (random2 == 0) {
                if (super.moveRight()) {
                    check = false;
                }
            } else if (random2 == 1) {
                if (super.moveLeft()) {
                    check = false;
                }
            } else if (random2 == 2) {
                if (super.moveUp()) {
                    check = false;
                }
            } else if (random2 == 3) {
                if (super.moveDown()) {
                    check = false;
                }
            }
        }
    }

    /**
     * The method which determine model of enemy's movement, and ensure the enemy will not be stuck.
     *
     * @param p The Player that this Enemy is chasing
     */
    public void chase(Player p) {
        chase = true;
        if (getDistance(p) <= viewRange) {
            if (tightChase(p) == 4)
                randomChase(p);

        } else {
            randomChase(p);
        }
        System.out.println("Enemy move");
    }

    public boolean getChase() {
        return chase;
    }

}

