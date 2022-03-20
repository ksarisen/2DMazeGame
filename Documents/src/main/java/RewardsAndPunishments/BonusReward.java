package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * The bonus rewards are not necessary for fishing the game, but contain a higher
 * reward compared to the regular rewards and collecting them improves the final score of the player.
 * A bonus reward appears randomly during the game, and disappears after a while (few ticks).
 */
public class BonusReward extends Reward {
    public BonusReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
