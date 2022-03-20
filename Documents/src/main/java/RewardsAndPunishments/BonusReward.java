package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * The bonus rewards are not necessary for fishing the game, but contain a higher
 * reward compared to the regular rewards and collecting them improves the final score of the player.
 * A bonus reward appears randomly during the game, and disappears after a while (few ticks).
 *
 * @author Kerem Sarisen
 */
public class BonusReward extends Reward {

    /**
     * Creates a bonus reward with the given parameters
     *
     * @param location a point where this bonus reward should be located
     * @param map a game panel where this bonus reward is being used
     * @param texture an image of the bonus reward
     * @param value score gift that bonus reward holds
     */
    public BonusReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
