package Objects;
import Textures.Image;
import MazeGame.GameObject;

/**
 * Creates Police Station
 *
 * @author Reece Landry
 */

public class PoliceStation extends GameObject {

	/**
	 * Creates object with Police Station image as described by constructor param
	 *
	 * @param x PoliceStation's name
	 */
	public PoliceStation(String x) {
		if (x.toLowerCase().contains("l"))
			super.texture = new Image("Police-Left.png");
		else if (x.toLowerCase().contains("r"))
			super.texture = new Image("Police-Right.png");
		else
			System.out.println("Error: Police Station Image not available");
	}
}

