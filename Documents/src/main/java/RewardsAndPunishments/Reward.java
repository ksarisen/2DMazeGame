package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * The game includes a minimum of two types of rewards.
 * Collectible object by the player on the map of the game
 *
 * @author Kerem Sarisen
 */
public abstract class Reward {

    private GamePanel map;
    private final int value;
    private Image texture;
    private final Point location;

    /**
     * Creates a reward with given parameters
     *
     * @param value    score gift that reward holds
     * @param texture  an image of this reward
     * @param location a point where this reward should be located
     * @param map      a game panel where this reward is being used
     */
    public Reward(int value, Image texture, Point location, GamePanel map) {
        this.value = value;
        this.texture = texture;
        this.location = location;
        this.map = map;
    }

    /**
     * Accessors
     */
    public GamePanel getMap() {
        return map;
    }

    /**
     * Mutators
     */
    public void setMap(GamePanel map) {
        this.map = map;
    }

    public Point getLocation() {
        return location;
    }

    public int getValue() {
        return value;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }
}
