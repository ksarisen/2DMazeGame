package main.java.Rewards;
import main.java.Textures.Image;

import java.awt.*;

// Randomly appears!!
public class RegularReward extends Reward {
    public RegularReward(String name, int value, String description, Image texture, Point location) {
        super(name, value, description, texture, location,10);
    }
}
