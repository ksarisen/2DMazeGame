package Objects;

import MazeGame.GameObject;
import Textures.Image;

/**
 * Creates Bank Object
 *
 * @author Reece Landry
 */

public class Bank extends GameObject {

    /**
     * Creates object with Bank image as described by constructor param
     *
     * @param x String variable to understand which part of the picture it is dealing with
     */
    public Bank(String x) {

        if (x.toLowerCase().contains("l"))
            super.setTexture(new Image("Bank-Left.png"));
        else if (x.toLowerCase().contains("r"))
            super.setTexture(new Image("Bank-Right.png"));
        else
            System.out.println("Error: Bank Image not available");
    }
}
