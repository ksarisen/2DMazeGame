package Characters;

import java.awt.Point;

import Objects.Road;
import Textures.Image;
import MazeGame.GamePanel;

/**
 * Abstract class for the enemy and the player
 *
 * @author Yuwen Jia
 * @author Reece Landry
 */
public abstract class Character {
    private GamePanel map;
    private Point location;
    private int speedX;
    private int speedY;
    private Image texture;
    public String type;

    /**
     * Creates a character given the parameters
     *
     * @param location a point where Character is located
     * @param texture  an Image that represents the Character
     * @param speedX   speed on the x-axis
     * @param speedY   speed on the y-axis
     * @param map      game panel that the Character belongs
     */
    public Character(Point location, Image texture, int speedX, int speedY, GamePanel map) {
        this.location = location;
        this.texture = texture;
        this.speedX = speedX;
        this.speedY = speedY;
        this.map = map;

    }

    /**
     * Accessor methods
     *
     * @return this Character's objects
     * @see Image
     * @see Point
     * @see GamePanel
     */

    public Point getLocation() {
        return location;
    }

    public Image getTexture() {
        return texture;
    }

    public GamePanel getMap() {
        return map;
    }

    /**
     * Mutator methods
     */

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setMap(GamePanel map) {
        this.map = map;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    /**
     * It moves the character towards north by subtracting Character's point on y-axis by 1
     *
     * @return the boolean value that says if this Character moved up or not
     */
    public boolean moveUp() {
        if (((int) this.location.getY() - 1) <= 0)
            return false;

        if (map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX()].getClass().getSimpleName().equals("Road") &
                (map.level.gameObjects[(int) this.location.getY() - 1][(int) this.location.getX()].getClass().getSimpleName().equals("Road") ||
                        map.level.gameObjects[(int) this.location.getY() - 1][(int) this.location.getX()].getClass().getSimpleName().equals("Helicopter"))) {
            if (map.level.gameObjects[(int) this.location.getY() - 1][(int) this.location.getX()].getClass().getSimpleName().equals("Helicopter")) {
                if (type.equals("Player")) {
                    this.texture = new Image("Car-North.png");
                    this.location.y = this.location.y - 1;
                    System.out.println("CAN MOVE UP");
                    return true;
                }
                return false;
            }
            Road r = (Road) map.level.gameObjects[this.location.y - 1][this.location.x];
            if (r.isSouth()) {
                if(type.equals("Police"))
                {
                    for(Enemy e: map.getEnemiesList())
                        if(e.getLocation().equals(new Point(this.location.x,this.location.y-1)))
                            return false;
                }
                this.location.y = this.location.y - 1;
                System.out.println("CAN MOVE UP");
                if (type.equals("Police")) {
                    this.texture = new Image("Police-North.png");
                } else {
                    this.texture = new Image("Car-North.png");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * It moves the character towards south by adding Character's point on y-axis by 1
     *
     * @return the boolean value that says if this Character moved down or not
     */
    public boolean moveDown() {
        if (((int) this.location.getY() + 1) >= 17)
            return false;

        if ((map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX()].getClass().getSimpleName().equals("Road") ||
                map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX()].getClass().getSimpleName().equals("Helicopter")) &
                map.level.gameObjects[(int) this.location.getY() + 1][(int) this.location.getX()].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y + 1][this.location.x];
            if (r.isNorth()) {
                if(type.equals("Police"))
                {
                    for(Enemy e: map.getEnemiesList())
                        if(e.getLocation().equals(new Point(this.location.x,this.location.y+1)))
                            return false;
                }
                this.location.y = this.location.y + 1;
                System.out.println("CAN MOVE DOWN");
                if (type.equals("Police")) {
                    this.texture = new Image("Police-South.png");
                } else {
                    this.texture = new Image("Car-South.png");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * It moves the character towards west by subtracting Character's point on x-axis by 1
     *
     * @return the boolean value that says if this Character moved left or not
     */
    public boolean moveLeft() {

        if (((int) this.location.getX() - 1) < 0)
            return false;
        if (map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX()].getClass().getSimpleName().equals("Road") &
                map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX() - 1].getClass().getSimpleName().equals("Road")) {
            Road r = (Road) map.level.gameObjects[this.location.y][this.location.x - 1];
            if (r.isEast()) {
                if(type.equals("Police"))
                {
                    for(Enemy e: map.getEnemiesList())
                        if(e.getLocation().equals(new Point(this.location.x-1,this.location.y)))
                            return false;
                }
                this.location.x = this.location.x - 1;
                System.out.println("CAN MOVE LEFT");
                if (type.equals("Police")) {
                    this.texture = new Image("Police-West.png");
                } else {
                    this.texture = new Image("Car-West.png");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * It moves the character towards east by adding Character's point on x-axis by 1
     *
     * @return the boolean value that says if this Character moved right or not
     */
    public boolean moveRight() {
        if (((int) this.location.getX() + 1) >= 24)
            return false;

        if (map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX()].getClass().getSimpleName().equals("Road") &
                (map.level.gameObjects[(int) this.location.getY()][(int) this.location.getX() + 1].getClass().getSimpleName().equals("Road"))) {
            Road r = (Road) map.level.gameObjects[this.location.y][this.location.x + 1];
            if (r.isWest()) {
                if(type.equals("Police"))
                {
                    for(Enemy e: map.getEnemiesList())
                        if(e.getLocation().equals(new Point(this.location.x+1,this.location.y)))
                        {
                            return false;
                        }
                }
                this.location.x = this.location.x + 1;
                System.out.println("CAN MOVE RIGHT");
                if (type.equals("Police")) {
                    this.texture = new Image("Police-East.png");
                } else {
                    this.texture = new Image("Car-East.png");
                }
                return true;
            }
        }
        return false;
    }
}
