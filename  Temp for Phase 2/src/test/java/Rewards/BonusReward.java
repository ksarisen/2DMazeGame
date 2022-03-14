package test.java.Rewards;
import test.java.Textures.Image;

import java.awt.*;

public class BonusReward extends Reward {
    public BonusReward(String name, int value, String description, Image texture, Point location, int score) {
        super(name, value, description, texture, location, score);
    }
}
