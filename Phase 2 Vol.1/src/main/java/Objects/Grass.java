package main.java.Objects;
import main.java.MazeGame.GameObject;
import main.java.Textures.Image;

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
