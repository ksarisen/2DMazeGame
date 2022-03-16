package test.java.Characters;

import java.awt.Point;
import test.java.Textures.Image;
import test.java.MazeGame.GamePanel;


public abstract class Character {
    private GamePanel map;
    private Point location;
    private int speedx;
    private int speedy;
    private Image texture;
    
    /**
     * Creates a character given the parameters
     * @param location
     * @param texture
     * @param speedx
     * @param speedy
     * @param map
     * @author Reece Landry
     */
    public Character(Point location, Image texture, int speedx, int speedy, GamePanel map) {
    	this.location = location;
    	this.texture = texture;
    	this.speedx = speedx;
        this.speedy = speedy;
    	this.map = map;
    	
    }


    public Point getLocation() {
        return location;
    }

    public Image getTexture() {
        return texture;
    }

    public int getSpeedx() {
        return speedx;
    }

    public int getSpeedy() {
        return speedy;
    }

    public GamePanel getMap() {
        return map;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    public void setLocation(int x, int y) {
        this.location = new Point(x,y);
    }

    public void setMap(GamePanel map) {
        this.map = map;
    }

    public void setSpeedx(int speedx) {
        this.speedx = speedx;
    }
    public void setSpeedy(int speedy) {
        this.speedy = speedy;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    public boolean moveUp (){
        if(map(this.location.x,this.location.y+1) != wall)
        {
            this.location.y=this.location.y+1;
            return true;
        }
        return false;
    }
    public boolean moveDown (){
        if(Cell(this.location.x,this.location.y-1) != wall)
        {
            this.location.y=this.location.y-1;
            return true;
        }
        return false;
    }

    public boolean moveLeft (){
        if(Cell(this.location.x-1,this.location.y) != wall)
        {
            this.location.x=this.location.x-1;
            return true;
        }
        return false;
    }
    public boolean moveRight (){
        if(Cell(this.location.x+1,this.location.y) != wall)
        {
            this.location.x=this.location.x+1;
            return true;
        }
        return false;
    }

}
