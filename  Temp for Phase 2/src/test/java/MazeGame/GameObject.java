package test.java.MazeGame;

import test.java.Textures.Image;

import java.awt.Graphics;
import java.awt.Point;


public abstract class GameObject {

	public static final int SIZE = 50;
	private String texturePath;
	public Point position;
	protected int index = 0;
	protected Image texture;
	protected String path;
	
	
	public void draw(Graphics g) {
		
		
	}
	
	public void setTexture(Image t) {
		this.texture = t;
	}
	public Image getTexture() {
		return this.texture;
	}
	public Point getPosition() {
		return this.position;
	}
	public void setPosition(Point p) {
		this.position = p;
	}
	
	//TODO: allow for removing the item
	public void remove() {
		
	}
	
}
