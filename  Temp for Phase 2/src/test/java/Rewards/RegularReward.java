package test.java.Rewards;
import test.java.Textures.Image;

import java.awt.*;

/*
 * To collect a reward, the player should move the main character to the cell containing the reward, \
 * which lead to the reward being claimed (removed from the map) and
 * the reward amount being added to the total score of the player.
 */

public class RegularReward extends Reward {

    public RegularReward(int value, Image texture, Point location) {
        super(value, texture, location);
    }
}
