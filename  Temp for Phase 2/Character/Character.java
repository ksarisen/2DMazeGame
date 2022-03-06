public class Character {
    private Maze map;
    private Cell location;
    private int speed;
    private img texture;

    public Cell getLocation() {
        return location;
    }

    public img getTexture() {
        return texture;
    }

    public int getSpeed() {
        return speed;
    }

    public Maze getMap() {
        return map;
    }

    public void setLocation(Cell location) {
        this.location = location;
    }

    public void setMap(Maze map) {
        this.map = map;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTexture(img texture) {
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
