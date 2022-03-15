package objects;
import test.java.MazeGame.GameObject;
import test.java.Textures.Image;


/**
 * 
 * @author Reece Landry
 *	Creates object with Police Station image as described by constructor param
 */

public class PoliceStation extends GameObject {

	public PoliceStation(String x) {
		if (x.toLowerCase().contains("l")) {
			super.texture = new Image("Textures/Police-Left.png");
		} else if (x.toLowerCase().contains("r")) {
			super.texture = new Image("Textures/Police-Right.png");
		}else {
			System.out.println("Error: Police Station Image not available");
		}
	}
	public PoliceStation() {
		super.texture = new Image("Textures/Police-Right.png");
	}
	
}

