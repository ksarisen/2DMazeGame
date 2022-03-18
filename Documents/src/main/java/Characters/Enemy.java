package Characters;

import java.util.Random;
import java.awt.Point;

import Textures.Image;
import MazeGame.GamePanel;

public class Enemy extends Character {
    int viewRange;

    public Enemy(int viewRange, int speedX, int speedY, Image texture, Point location, GamePanel map) {
        super(location, texture, speedX,speedY, map);
        this.viewRange = viewRange;
        return;
    }


    public int getViewRange() {
        return viewRange;
    }

    public void setViewRange(int viewRange) {
        this.viewRange = viewRange;
    }

    public int getDistance(Player p) {
        return p.getLocation().x- super.getLocation().x + p.getLocation().y - super.getLocation().y;
    }

    public void chase(Player p) {
        Random rand = new Random();
        if (getDistance(p) <= viewRange) {
            int random1 = rand.nextInt();
            if (random1 == 0) {
                if (p.getLocation().x - this.getLocation().x < 0) {
                    super.moveLeft();
                } else {
                    super.moveRight();
                }
            } else {
                if (p.getLocation().y - this.getLocation().y < 0) {
                    super.moveUp();
                } else {
                    super.moveDown();
                }
            }
        } else {
            int random2 = rand.nextInt(3);
            if (random2 == 0) {
                if (super.moveRight()) {
                    return;
                }
                random2=1;
            }
            if (random2 == 1) {
                if(super.moveLeft())
                {
                    return;
                }
                random2=2;
            }
            if (random2 == 2) {
                if(super.moveUp())
                {
                    return;
                }
                random2=3;
            }
            if (random2 == 3) {
                if(super.moveDown())
                {
                    return;
                }
                random2=0;
            }
        }
    }
}
