package Characters;

import java.awt.Point;

import Objects.Road;
import Textures.Image;
import MazeGame.GamePanel;


public abstract class Character {
    private GamePanel map;
    private Point location;
    private int speedx;
    private int speedy;
    private Image texture;

    /**
     * Creates a character given the parameters
     * @param location
     * @param texture
     * @param speedX
     * @param speedY
     * @param map
     * @author Reece Landry
     */
    public Character(Point location, Image texture, int speedX, int speedY, GamePanel map) {
        this.location = location;
        this.texture = texture;
        this.speedx = speedX;
        this.speedy = speedY;
        this.map = map;

    }


    public Point getLocation() {
        return location;
    }

    public Image getTexture() {
        return texture;
    }

    public int getSpeedX() {
        return speedx;
    }

    public int getSpeedY() {
        return speedy;
    }

    public GamePanel getMap() {
        return map;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    public void setLocation(int x, int y) {
        this.location = new Point(x,y);
    }

    public void setMap(GamePanel map) {
        this.map = map;
    }

    public void setSpeedX(int speedX) {
        this.speedx = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedy = speedY;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    public boolean moveUp () {
        if(((int)this.location.getY()-1)<=0)
            return false;

        if(map.level.gameObjects[(int)this.location.getY()][(int)this.location.getX()].getClass().getSimpleName().equals("Road") &
                map.level.gameObjects[(int)this.location.getY()-1][(int)this.location.getX()].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y-1][this.location.x];
            if (r.isSouth()) {
                this.location.y=this.location.y-1;
                System.out.println("CAN MOVE UP");
                return true;
            }
        }
        return false;
    }
    public boolean moveDown () {
        if(((int)this.location.getY()+1)>=17)
            return false;

        if(map.level.gameObjects[(int)this.location.getY()][(int)this.location.getX()].getClass().getSimpleName().equals("Road") &
                map.level.gameObjects[(int)this.location.getY()+1][(int)this.location.getX()].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y+1][this.location.x];
            if (r.isNorth()) {
                this.location.y=this.location.y+1;
                System.out.println("CAN MOVE DOWN");
                return true;
            }
        }
        return false;
    }

    public boolean moveLeft () {

        if(((int)this.location.getX()-1)<0)
            return false;
        if(map.level.gameObjects[(int)this.location.getY()][(int)this.location.getX()].getClass().getSimpleName().equals("Road") &
                map.level.gameObjects[(int)this.location.getY()][(int)this.location.getX()-1].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y][this.location.x-1];
            if (r.isEast()) {
                this.location.x=this.location.x-1;
                System.out.println("CAN MOVE LEFT");
                return true;
            }
        }
        return false;
    }

    public boolean moveRight () {
        if(((int)this.location.getX()+1)>=24)
            return false;

        if(map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX()].getClass().getSimpleName().equals("Road") &
                map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX() + 1].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y][this.location.x+1];
            if (r.isWest()) {
                this.location.x=this.location.x+1;
                System.out.println("CAN MOVE RIGHT");
                return true;
            }
        }
        return false;
    }
}
