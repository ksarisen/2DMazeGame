package main.java.Rewards;
import main.java.MazeGame.GamePanel;
import main.java.Textures.Image;

import java.awt.*;

// Randomly appears!!
public class RegularReward extends Reward {
    public RegularReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
