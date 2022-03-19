package Characters;

import java.util.Random;
import java.awt.Point;

import Textures.Image;
import MazeGame.GamePanel;

public class Enemy extends Character {
    int viewRange;

    public Enemy(int viewRange, int speedX, int speedY, Image texture, Point location, GamePanel map) {
        super(location, texture, speedX, speedY, map);
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
        return p.getLocation().x - super.getLocation().x + p.getLocation().y - super.getLocation().y;
    }

    public void chase(Player p) {
        Random rand = new Random();
        boolean check = true;
        if (getDistance(p) <= viewRange) {
            while (check) {
                int random1 = rand.nextInt();
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
            }
        } else {
            while (check) {
                int random2 = rand.nextInt(3);
                if (random2 == 0) {
                    if (super.moveRight()) {
                        check=false;
                    }
                }
                else if (random2 == 1) {
                    if (super.moveLeft()) {
                        check=false;
                    }
                }
                else if (random2 == 2) {
                    if (super.moveUp()) {
                        check=false;
                    }
                }
                else if (random2 == 3) {
                    if (super.moveDown()) {
                        check=false;
                    }
                }
            }
        }
    }
}

