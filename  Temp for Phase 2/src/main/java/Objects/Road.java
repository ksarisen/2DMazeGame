package main.java.Objects;
import main.java.MazeGame.GameObject;
import main.java.Textures.Image;

/**
 * 
 * @author Reece Landry
 *	Creates Road object based on encoded string of directions
 *	n = north
 *	s = south
 *	e = east
 *	w = west
 *	Strings must be in order of North, East, South, West
 */

public class Road extends GameObject {
	
	public Road(String directionCode) {
	
		System.out.println(this.parseTextureName(directionCode));
		super.texture = new Image("Textures/" + this.parseTextureName(directionCode));
		
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
