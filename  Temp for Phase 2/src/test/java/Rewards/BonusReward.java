package test.java.Rewards;
import test.java.Textures.Image;

public class BonusReward extends Reward {
    public BonusReward(String name, int value, String description, Image texture, Cell location, int score) {
        super(name, value, description, texture, location, score);
    }
}
