package Objects;

import MazeGame.GameObject;
import Textures.Image;

/**
 * Creates object with Bank image as described by constructor param
 *
 * @author Reece Landry
 */

public class Bank extends GameObject {

    public Bank(String x) {
        if (x.toLowerCase().contains("l")) {
            super.setTexture(new Image("Bank-Left.png"));
        } else if (x.toLowerCase().contains("r")) {
            super.setTexture(new Image("Bank-Right.png"));
        } else {
            System.out.println("Error: Bank Image not available");
        }
    }

    public Bank() {
        super.setTexture(new Image("Bank-Left.png"));
    }

}
