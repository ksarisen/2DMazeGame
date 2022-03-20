package RewardsAndPunishments;
import MazeGame.GamePanel;
import Textures.Image;
import java.awt.Point;

/**
 * The game includes a minimum of two types of rewards.
 * Collectible object by the player on the map of the game
 *
 * @author Kerem Sarisen
 */
public abstract class Reward {

    private GamePanel map;
    private int value;
    private Image texture;
    private Point location;

    /**
     * Creates a reward with given parameters
     *
     * @param value score gift that reward holds
     * @param texture an image of this reward
     * @param location a point where this reward should be located
     * @param map a game panel where this reward is being used
     */
    public Reward(int value, Image texture, Point location, GamePanel map) {
        this.value = value;
        this.texture = texture;
        this.location = location;
        this.map = map;
    }

    /**
     * Mutators
     */
    public void setMap(GamePanel map) {
        this.map = map;
    }
    public void setLocation(Point location) {
        this.location = location;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setTexture(Image texture) {
        this.texture = texture;
    }

    /**
     * Accessors
     */
    public GamePanel getMap() {
        return map;
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
}
