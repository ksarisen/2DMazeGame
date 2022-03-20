package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * Punishment object to decrease player's score
 */
public class PunishmentRoadBlock extends Reward {
    public PunishmentRoadBlock(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
