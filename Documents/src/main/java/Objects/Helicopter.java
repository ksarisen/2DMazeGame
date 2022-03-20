package Objects;

import MazeGame.GameObject;
import Textures.Image;

/**
 * Creates Helicopter to be reached by the user to end the game
 *
 * @author Reece Landry
 */

public class Helicopter extends GameObject {

    /**
     * Creates object with helicopter image
     *
     * @param x helicopter's name
     */
    public Helicopter(String x) {
        super.texture = new Image("Helicopter.png");
    }
}
