package Objects;
import Textures.Image;
import MazeGame.GameObject;


/**
 * Creates object with Police Station image as described by constructor param
 * @author Reece Landry
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

