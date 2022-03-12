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
        return p.getLocation().X - this.getLocation().X + p.getLocation().Y - this.getLocation().Y;
    }

    public void chase(Player p) {
        Random rand = new Random();
        if (distance(p) <= viewrange) {
            int random1 = rand.nextInt();
            if (random1 == 0) {
                if (p.getLocation().X - this.getLocation().X < 0) {
                    this.moveLeft();
                } else {
                    this.moveRight();
                }
            } else {
                if (p.getLocation().Y - this.getLocation().Y < 0) {
                    this.moveUp();
                } else {
                    this.moveDown();
                }
            }
        } else {
            int ramdom2 = rand.nextInt(3);
            if (ramdom2 == 0) {
                if (this.moveRight()) {
                    return;
                }
                ramdom2=1;
            }
            if (ramdom2 == 1) {
                if(this.moveLeft())
                {
                    return;
                }
                ramdom2=2;
            }
            if (ramdom2 == 2) {
                if(this.moveUp())
                {
                    return;
                }
                ramdom2=3;
            }
            if (ramdom2 == 3) {
                if(this.moveDown())
                {
                    return;
                }
                ramdom2=0;
            }
        }
        return;
    }
}
