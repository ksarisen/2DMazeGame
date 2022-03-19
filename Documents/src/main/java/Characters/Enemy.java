package Characters;

import java.lang.Math;
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
        return Math.abs(p.getLocation().x - super.getLocation().x) + Math.abs(p.getLocation().y - super.getLocation().y);
    }

    private int tightChase(Player p) {
        int times = 0;
        boolean check = true;
        while (check) {
            times++;
            int random1 = (int) (Math.random() * (2));
            System.out.println(random1 + "random1");
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

    private void randomChase(Player p) {
        boolean check = true;
        while (check) {
            int random2 = (int) (Math.random() * (4));
            System.out.println(random2 + "random2");
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

