package RewardsAndPunishments;
import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/*
 * All regular rewards have to be collected to win game.
 * Appears randomly at the beginning of the game.
 */
public class RegularReward extends Reward {
    public RegularReward(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
