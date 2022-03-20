package main.java.Rewards;
import main.java.MazeGame.GamePanel;
import main.java.Textures.Image;

import java.awt.*;

public class BonusReward extends Reward {
    public BonusReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
