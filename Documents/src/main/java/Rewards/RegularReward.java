package Rewards;
import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

// Randomly appears!!
public class RegularReward extends Reward {
    public RegularReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
