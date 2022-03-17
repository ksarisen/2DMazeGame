package main.java.Rewards;
import main.java.Characters.Player;
import main.java.Textures.Image;
import java.awt.Point;

public abstract class Reward {

    private int value;
    private Image texture;
    private Point location;

    /*
     * Creates a reward given the parameters
     * @param value
     * @param texture
     * @param location
     * @author Kerem Sarisen
     */

    public Reward(int value, Image texture, Point location) {
        this.value = value;
        this.texture = texture;
        this.location = location;
    }

    //Accessors
    public Point getLocation() {
        return location;
    }

    public Image getTexture() {
        return texture;
    }

    public int getValue() {
        return value;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

}
