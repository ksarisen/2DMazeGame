package Characters;

import java.awt.Point;

import Objects.Road;
import Textures.Image;
import MazeGame.GamePanel;

// Abstract class for the enemy and the player
public abstract class Character {
    private GamePanel map;
    private Point location;
    private int speedX;
    private int speedY;
    private Image texture;

    /**
     * Creates a character given the parameters
     * @param location a point where Character is located
     * @param texture an Image that represents the Character
     * @param speedX speed on the x-axis
     * @param speedY speed on the y-axis
     * @param map game panel that the Character belongs
     * @author Reece Landry
     */
    public Character(Point location, Image texture, int speedX, int speedY, GamePanel map) {
        this.location = location;
        this.texture = texture;
        this.speedX = speedX;
        this.speedY = speedY;
        this.map = map;

    }

    // Accessor methods
    public Point getLocation() {
        return location;
    }
    public Image getTexture() {
        return texture;
    }
    public int getSpeedX() {
        return speedX;
    }
    public int getSpeedY() {
        return speedY;
    }
    public GamePanel getMap() {
        return map;
    }

    // Mutator methods
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
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
    public void setTexture(Image texture) {
        this.texture = texture;
    }

    // It moves the character towards north by subtracting Character's point on y-axis by 1
    public boolean moveUp () {
        if(((int)this.location.getY()-1)<=0)
            return false;

        if(map.level.gameObjects[(int)this.location.getY()][(int)this.location.getX()].getClass().getSimpleName().equals("Road") &
                map.level.gameObjects[(int)this.location.getY()-1][(int)this.location.getX()].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y-1][this.location.x];
            if (r.isSouth()) {
                this.location.y = this.location.y-1;
                System.out.println("CAN MOVE UP");
                return true;
            }
        }
        return false;
    }

    // It moves the character towards south by adding Character's point on y-axis by 1
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

    // It moves the character towards west by subtracting Character's point on x-axis by 1
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

    // It moves the character towards east by adding Character's point on x-axis by 1
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
