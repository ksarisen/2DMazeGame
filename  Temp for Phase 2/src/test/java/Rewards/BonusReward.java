package test.java.Rewards;
import test.java.Textures.Image;

import java.awt.*;

/*
 * Not necessary for finishing the game, but contain a higher reward compared to the regular rewards and
 * collecting them improves the final score of the player.
 * A bonus reward appears randomly during the game, and disappears after a while.
 */

public class BonusReward extends Reward {
    public BonusReward(int value, Image texture, Point location) {
        super(value, texture, location);
    }
}
