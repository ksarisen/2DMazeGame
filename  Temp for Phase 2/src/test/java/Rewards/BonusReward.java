package test.java.Rewards;
import test.java.Textures.Image;

import java.awt.*;

/*
 * Not necessary for finishing the game, but contain a higher reward compared to the regular rewards and
 * collecting them improves the final score of the player.
 * A bonus reward appears randomly during the game, and disappears after a while.
 */

public class BonusReward extends Reward {
    public BonusReward(String name, int value, String description, Image texture, Point location) {
        super(name, value, description, texture, location);
    }
}
