package Objects;
import MazeGame.GameObject;
import Textures.Image;

/**
 * Creates object with grass image
 * @author Reece Landry
 *	
 */

public class Helicopter extends GameObject {

	public Helicopter(String x) {
		super.texture = new Image("Textures/Helicopter.png");
	}
	public Helicopter() {
		super.texture = new Image("Textures/Helicopter.png");
	}
	
}
