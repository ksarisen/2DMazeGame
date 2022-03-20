package main.java.Objects;

import main.java.MazeGame.GameObject;
import main.java.Textures.Image;

/**
 * Creates object with Bank image as described by constructor param
 
 * @author Reece Landry
 *	
 */

public class Bank extends GameObject{
	
	public Bank(String x) {
		if (x.toLowerCase().contains("l")) {
			super.texture = new Image("Textures/Bank-Left.png");
		} else if (x.toLowerCase().contains("r")) {
			super.texture = new Image("Textures/Bank-Right.png");
		}else {
			System.out.println("Error: Bank Image not available");
		}
	}
	public Bank() {
		super.texture = new Image("Textures/Bank-Right.png");
	}

}
