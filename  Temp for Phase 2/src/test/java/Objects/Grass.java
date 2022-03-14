package test.java.Objects;
import test.java.MazeGame.GameObject;
import test.java.Textures.Image;

/**
 * 
 * @author Reece Landry
 *	Creates object with grass image
 */

public class Grass extends GameObject {

	public Grass(String x) {
		super.texture = new Image("Textures/Grass.png");
	}
	public Grass() {
		super.texture = new Image("Textures/Grass.png");
	}
	
}
