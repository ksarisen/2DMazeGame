package Objects;

import Textures.Image;

import java.awt.Point;

/**
 * Creates a {@code GameObject} that stores details of cells on the game board
 *
 * @author Reece Landry
 */

public abstract class GameObject {

    public static final int SIZE = 50;
    public Point position;
    protected int index = 0;
    protected Image texture;
    protected String path;

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

    public Point getPosition() {
        return this.position;
    }

}
