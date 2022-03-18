package Objects;
import MazeGame.GameObject;
import Textures.Image;

/**
 * Creates object with grass image
 * @author Reece Landry
 *	
 */

public class Grass extends GameObject {

	public Grass(String x) {
		super.texture = new Image("Textures/Grass.png");
	}
	public Grass() {
		super.texture = new Image("Textures/Grass.png");
	}
	
}
