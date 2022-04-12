package Objects;

import Textures.Image;

import java.awt.*;

/**
 * Creates a {@code GameObject} that stores details of cells on the game board
 *
 * @author Reece Landry
 */

public abstract class GameObject {

    public static final int SIZE = 50;
    public Point position;
    protected Image texture;

    /**
     * Mutators
     */
    public void setTexture(Image t) {
        this.texture = t;
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    /**
     * Accessors
     */
    public Image getTexture() {
        return this.texture;
    }

}
