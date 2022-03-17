package main.java.Rewards;
import main.java.Textures.Image;

import java.awt.*;

public class BonusReward extends Reward {
    public BonusReward(String name, int value, String description, Image texture, Point location) {
        super(name, value, description, texture, location, 25);
    }
}
