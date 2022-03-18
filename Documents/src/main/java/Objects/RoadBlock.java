package Objects;
import MazeGame.GameObject;
import Textures.Image;


public class RoadBlock extends GameObject {

    public RoadBlock(String x) {
        super.texture = new Image("Textures/Grass.png");
    }
    public RoadBlock() {
        super.texture = new Image("Textures/Grass.png");
    }

}
