package test.java.Rewards;

import java.awt.*;

public class Barrier extends Reward{

    public Barrier(String name, int value, String description, Image texture, Point location, int score) {
        super(name, value, description, texture, location, -score);
    }
}
