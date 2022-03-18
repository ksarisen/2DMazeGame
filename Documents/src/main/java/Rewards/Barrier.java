package Rewards;
import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;

public class Barrier extends Reward {
    public Barrier(int value, Image texture, Point location, GamePanel map) {
        super(value, texture, location, map);
    }

    @Override
    public Point getLocation() {
        return super.getLocation();
    }
}
