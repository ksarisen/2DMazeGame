package main.java.Objects;
import main.java.MazeGame.GameObject;
import main.java.Textures.Image;


public class RoadBlock extends GameObject {

    public RoadBlock(String x) {
        super.texture = new Image("Textures/Grass.png");
    }
    public RoadBlock() {
        super.texture = new Image("Textures/Grass.png");
    }

}
