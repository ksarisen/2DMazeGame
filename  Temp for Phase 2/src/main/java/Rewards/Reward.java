package main.java.Rewards;
import main.java.Characters.Player;
import main.java.Textures.Image;

import java.awt.*;

public abstract class Reward {
    public String name;
    private int value;
    private String description;
    private Image texture;
    private Point location;
    private int score;


    public Reward(String name, int value, String description, Image texture, Point location, int score) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.texture = texture;
        this.location = location;
        this.score=score;
    }

    //Accessors

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

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

    // If collectReward = true then player's score will increase but Idk if it should increase here or in the player class
    public void applyReward(Player player) {
        if(player.collectReward(this) == true);
    }

    // It should remove the reward that is located at the player's cell
    public void removeReward() {

    }

}
