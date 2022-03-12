package Character;

import java.util.Random;
import java.awt.Point;
import Textures.Image;
import MazeGame.GamePanel;

public class Enemy extends Character {
    int viewrange;

     public Enemy(int viewrange, int speed, Image texture, Point location, GamePanel map) {
    	super(location, texture, speed, map);
        this.viewrange = viewrange;
        return;
    }

    public int getViewrange() {
        return viewrange;
    }

    public void setViewrange(int viewrange) {
        this.viewrange = viewrange;
    }

    public int distance(Player p) {
        return p.getLocation().x - this.getLocation().x + p.getLocation().y - this.getLocation().y;
    }

    public void chase(Player p) {
        Random rand = new Random();
        if (distance(p) <= viewrange) {
            int random1 = rand.nextInt();
            if (random1 == 0) {
                if (p.getLocation().x - this.getLocation().x < 0) {
                    this.moveLeft();
                } else {
                    this.moveRight();
                }
            } else {
                if (p.getLocation().y - this.getLocation().y < 0) {
                    this.moveUp();
                } else {
                    this.moveDown();
                }
            }
        } else {
            int random2 = rand.nextInt(3);
            if (random2 == 0) {
                if (this.moveRight()) {
                    return;
                }
                random2=1;
            }
            if (random2 == 1) {
                if(this.moveLeft())
                {
                    return;
                }
                random2=2;
            }
            if (random2 == 2) {
                if(this.moveUp())
                {
                    return;
                }
                random2=3;
            }
            if (random2 == 3) {
                if(this.moveDown())
                {
                    return;
                }
                random2=0;
            }
        }
        return;
    }
}
