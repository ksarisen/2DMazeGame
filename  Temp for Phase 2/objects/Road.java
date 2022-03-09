package objects;
import MazeGame.GameObject;
import Textures.Image;

public class Road extends GameObject {
	
	public enum RoadDirections {
		NORTH,
		SOUTH,
		EAST,
		WEST
	}
	
	//TODO: Make road work
	public Road(RoadDirections[] directions) {
		System.out.println("This one happened");
		super.texture = new Image("North-South.png");
	}
	
	public Road(String directionCode) {
		//convert code to name
	
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
