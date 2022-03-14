package test.java.Rewards;

public abstract class Reward {
    public String name;
    import test.java.Textures.Image;
    private int value;
    private String description;
    private Image texture;
    private Cell location;
    private int score;


    public Reward(String name, int value, String description, Image texture, Cell location, int score) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.texture = texture;
        this.location = location;
        this.score=score;
    }

    //Accessors

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Cell getLocation() {
        return location;
    }

    public Image getTexture() {
        return texture;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setLocation(Cell location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    // If collectReward = true then player's score will increase but Idk if it should increase here or in the player class
    public void applyReward(Player player) {
        player.collectReward(this) = true;
    }

    // It should remove the reward that is located at the player's cell
    public void removeReward(Player player) {

    }

}
