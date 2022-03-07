public abstract class Reward {
    public String name;

    private int value;
    private String description;
    private img texture;
    private Cell location;


    public Reward(String name, int value, String description, img texture, Cell location) {
        this.name = name;
        this.value = value;
        this.description = description;
        this.texture = texture;
        this.location = location;
    }

    //Accessors
    public Cell getLocation() {
        return location;
    }

    public img getTexture() {
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

    public void setTexture(img texture) {
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
