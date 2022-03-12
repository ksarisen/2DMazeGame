package Character;
import java.awt.Point;
import Textures.Image;
import objects.Road;
import MazeGame.GameObject;
import MazeGame.GamePanel;


public class Character {
    private GamePanel map;
    private Point location;
    private int speed;
    private Image texture;
    
    /**
     * Creates a character given the parameters
     * @param location
     * @param texture
     * @param speed
     * @param map
     * @author Reece Landry
     */
    public Character(Point location, Image texture, int speed, GamePanel map) {
    	this.location = location;
    	this.texture = texture;
    	this.speed = speed;
    	this.map = map;
    	
    }


    public Point getLocation() {
        return location;
    }

    public Image getTexture() {
        return texture;
    }

    public int getSpeed() {
        return speed;
    }

    public GamePanel getMap() {
        return map;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setMap(GamePanel map) {
        this.map = map;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    public boolean moveUp (){
        if(Cell(this.location.X,this.location.Y+1) != wall)
        {
            this.location.Y=this.location.Y+1;
            return true;
        }
        return false;
    }
    public boolean moveDown (){
        if(Cell(this.location.X,this.location.Y-1) != wall)
        {
            this.location.Y=this.location.Y-1;
            return true;
        }
        return false;
    }

    public boolean moveLeft (){
        if(Cell(this.location.X-1,this.location.Y) != wall)
        {
            this.location.X=this.location.X-1;
            return true;
        }
        return false;
    }
    public boolean moveRight (){
        if(Cell(this.location.X+1,this.location.Y) != wall)
        {
            this.location.X=this.location.X+1;
            return true;
        }
        return false;
    }

}
