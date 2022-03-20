package RewardsAndPunishments;
import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * All regular rewards have to be collected to win game.
 * Appears randomly at the beginning of the game.
 *
 * @author Kerem Sarisen
 */
public class RegularReward extends Reward {

    /**
     * Creates a regular reward with the given parameters
     *
     * @param location a point where this regular reward should be located
     * @param map a game panel where this regular reward is being used
     * @param texture an image of this regular reward
     * @param value score gift that regular reward holds
     */
    public RegularReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
