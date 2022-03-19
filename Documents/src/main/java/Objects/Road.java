package Objects;
import MazeGame.GameObject;
import Textures.Image;

/**
 * 
 * 
 *	Creates Road object based on encoded string of directions
 *	n = north
 *	s = south
 *	e = east
 *	w = west
 *	Strings must be in order of North, East, South, West
 *  @author Reece Landry
 */

public class Road extends GameObject {
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	
	public Road(String directionCode) {

		this.east = false;
		this.north = false;
		this.south = false;
		this.west = false;

		for(int i = 0; i < directionCode.length(); i++)
		{
			char c = directionCode.charAt(i);
			switch (c) {
				case 'n':
					this.north = true;
					break;
				case 'e':
					this.east = true;
					break;
				case 's':
					this.south = true;
					break;
				case 'w':
					this.west = true;
					break;
				case 'o':
					this.west = true;
					this.north = true;
					this.south = true;
					this.east = true;
			}
		}
		Image i = new Image("" + this.parseTextureName(directionCode));
		super.setTexture(i);
	}

	public boolean isEast() {
		return east;
	}

	public boolean isNorth() {
		return north;
	}

	public boolean isSouth() {
		return south;
	}

	public boolean isWest() {
		return west;
	}

	private String parseTextureName(String s) {
		String textureName = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'n':
				textureName += "North";
				break;
			case 'e': 
				textureName += "East";
				break;
			case 's':
				textureName += "South";
				break;
			case 'w':
				textureName += "West";
				break;
			case 'o':
				textureName += "Open";
				break;
			}
			if (i != s.length() - 1) {
				textureName += "-";
			}else {
				textureName += ".png";
			}	
		}
		return textureName;
	}
	
}
