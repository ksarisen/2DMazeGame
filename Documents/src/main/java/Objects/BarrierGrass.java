package Objects;
import MazeGame.GameObject;
import Textures.Image;

/**
 * Creates object with grass image
 * @author Reece Landry
 */

public class BarrierGrass extends GameObject {

	public BarrierGrass(String s) {
		super.texture = new Image("Grass.png");
	}
}
