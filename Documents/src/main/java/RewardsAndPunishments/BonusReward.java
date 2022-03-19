package RewardsAndPunishments;
import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

public class BonusReward extends Reward {
    public BonusReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
