package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

/**
 * Creates Punishment object to decrease player's score
 */
public class PunishmentRoadBlock extends Reward {

    /**
     * Creates Punishment Object with the given parameters
     *
     * @param value    score gift that reward holds
     * @param texture  an image of this road block
     * @param location a point where this road block should be located
     * @param map      a game panel where this road block is being used
     */
    public PunishmentRoadBlock(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }
}
