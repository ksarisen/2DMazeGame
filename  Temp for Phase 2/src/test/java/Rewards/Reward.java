package test.java.Rewards;
import test.java.Characters.Player;
import test.java.Textures.Image;
import java.awt.Point;

public abstract class Reward {
    public String name;

    private int value;
    private String description;
    private Image texture;
    private Point location;

    /**
     * Creates a reward given the parameters
     * @param name
     * @param value
     * @param description
     * @param texture
     * @param location
     * @author Kerem Sarisen
     */

    public Reward(String name, int value, String description, Image texture, Point location) {
        this.name = name;
        this.value = value;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    // If collectReward = true then player's score will increase.
    public void applyReward(Player player) {
        if (player.collectReward(this) == true) {
            player.scoreIncrease(this);
        }
    }

    // It decreases the player's score by the value of this reward's value.
    public void cancelReward(Player player) {
        player.scoreDecrease(this.value);
    }
}
