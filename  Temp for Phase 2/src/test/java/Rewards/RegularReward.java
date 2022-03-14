package test.java.Rewards;
import test.java.Textures.Image;

import java.awt.*;

// Randomly appears!!
public class RegularReward extends Reward {
    public RegularReward(String name, int value, String description, Image texture, Point location, int score) {
        super(name, value, description, texture, location,score);
    }
}
