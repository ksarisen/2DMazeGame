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
    private Image texture;
    public String type;

    /**
     * Creates a character given the parameters
     *
     * @param location a point where Character is located
     * @param texture  an Image that represents the Character
     * @param map      game panel that the Character belongs
     */
    public Character(Point location, Image texture,  GamePanel map) {
        this.location = location;
        this.texture = texture;
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
     * check whether the character can move to the direction we want without overlapping, and repaint the
     * image of the character, so that characters are heading in the direction we want.
     *
     * @return  whether the character can move to the direction without overlapping
     * @param direction  the direction which character want to move
     */
    private boolean checkOverlappingAndDrawTheDirection(String direction) {
        String temp = null;
        Point destination = null;
        switch (direction) {
            case "North":
                temp = "UP";
                destination = new Point(new Point(this.location.x, this.location.y - 1));
                break;
            case "West":
                temp = "LEFT";
                destination = new Point(new Point(this.location.x - 1, this.location.y));
                break;
            case "South":
                temp = "DOWN";
                destination = new Point(new Point(this.location.x, this.location.y + 1));
                break;
            case "East":
                temp = "RIGHT";
                destination = new Point(new Point(this.location.x + 1, this.location.y));
                break;
        }
        if (this.type.equals("Police")) {
            for (Enemy e : map.getEnemiesList())
                if (e.getLocation().equals(destination))
                    return false;
        }
        this.setLocation(destination);
        System.out.println("CAN MOVE " + temp);
        if (type.equals("Police")) {
            this.texture = new Image("Police-" + direction + ".png");
        } else {
            this.texture = new Image("Car-" + direction + ".png");
        }
        return true;
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
                return checkOverlappingAndDrawTheDirection("North");
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
                return checkOverlappingAndDrawTheDirection("South");
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
                return checkOverlappingAndDrawTheDirection("West");
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
                return checkOverlappingAndDrawTheDirection("East");
            }
        }
        return false;
    }
}
