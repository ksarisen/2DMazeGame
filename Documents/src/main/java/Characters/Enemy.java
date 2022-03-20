package Characters;

import java.lang.Math;
import java.awt.Point;

import Textures.Image;
import MazeGame.GamePanel;

/**
 * Class for the Enemy
 *
 * @author Yuwen Jia
 */
public class Enemy extends Character {
    int viewRange;

    /**
     * Creates an Enemy with the given parameters
     *
     * @param location a point where Character is located
     * @param texture an Image that represents the Character
     * @param speedX speed on the x-axis
     * @param speedY speed on the y-axis
     * @param map game panel that the Character belongs
     * @param viewRange the range that this Enemy can view
     */
    public Enemy(int viewRange, int speedX, int speedY, Image texture, Point location, GamePanel map) {
        super(location, texture, speedX, speedY, map);
        this.viewRange = viewRange;
        super.type="Police";
        return;
    }

    /**
     * Mutator method
     *
     * @param viewRange the range that this Enemy can view
     */
    public void setViewRange(int viewRange) {
        this.viewRange = viewRange;
    }

    /**
     * Accessor methods
     *
     * @param p the Player that this Enemy is chasing
     * @return this Enemy's view range, and it's distance towards the Player
     */
    public int getDistance(Player p) {
        return Math.abs(p.getLocation().x - super.getLocation().x) + Math.abs(p.getLocation().y - super.getLocation().y);
    }
    public int getViewRange() {
        return viewRange;
    }

    /**
     * TODO Description of the method (HAS TO BE FILLED BY YUWEN)
     *
     * @param p The Player that this Enemy is chasing
     * @return TODO HAS TO BE FILLED BY YUWEN
     */
    private int tightChase(Player p) {
        int times = 0;
        boolean check = true;
        while (check) {
            times++;
            int random1 = (int) (Math.random() * (2));
            if(p.getLocation().x - this.getLocation().x == 0)
            {
                random1=1;
            }
            if(p.getLocation().y - this.getLocation().y == 0)
            {
                random1=0;
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
            if(times==4)
            {break;}
        }
        return times;
    }

    /**
     * TODO Description of the method (HAS TO BE FILLED BY YUWEN)
     *
     * @param p The Player that this Enemy is chasing
     * @return  TODO HAS TO BE FILLED BY YUWEN
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
     * TODO Description of the method (HAS TO BE FILLED BY YUWEN)
     *
     * @param p The Player that this Enemy is chasing
     * @return  TODO HAS TO BE FILLED BY YUWEN
     */
    public void chase(Player p) {
        if (getDistance(p) <= viewRange) {
            if (tightChase(p) == 4)
                randomChase(p);

        } else {
            randomChase(p);
        }
        System.out.println("Enemy move");
    }

}

