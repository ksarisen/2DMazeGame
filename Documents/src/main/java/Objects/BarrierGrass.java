package Objects;

import Textures.Image;

/**
 * Creates grass
 *
 * @author Reece Landry
 */

public class BarrierGrass extends GameObject {

    /**
     * Creates object with grass image
     *
     * @param s grass' name
     */
    public BarrierGrass(String s) {
        super.texture = new Image("Grass.png");
    }
}
