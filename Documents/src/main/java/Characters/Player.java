package Characters;

import RewardsAndPunishments.PunishmentRoadBlock;
import RewardsAndPunishments.RegularReward;
import RewardsAndPunishments.Reward;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Objects;

import MazeGame.GamePanel;
import Textures.Image;

/**
 * Class for the Player
 *
 * @author Yuwen Jia
 */
public class Player extends Character {
    private int score;
    private String name;
    private int collection;

    public Player (int score,String name,int speedX,int speedY, Point location, GamePanel map, Image texture)
    {
        super(location, texture, speedX,speedY, map);
        this.score = score;
        this.name = name;
        this.collection = 0;
        super.type="Player";
    }

    /**
     * It checks if the player has collected all 10 regular rewards and
     * the location of the rescue helicopter same as the player's location
     *
     * @return true if this Player collected all the regular rewards, otherwise returns false
     */
    public boolean check()
    {
        return this.collection==10&Objects.equals(super.getLocation(), new Point(21, 1));
    }

    /**
     * Accessors methods
     */
    public int getCollection() {
        return collection;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    /**
     * Mutators methods
     */
    public void setScore(int score) {
        this.score = score;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * If the player's locations is same as reward's location then
     * it makes the player collect the reward.
     * Increases the score of the player by the worth of the reward's value
     * If the reward is regular reward then it increases the collection by 1 to keep the count of regulars.
     *
     * @param rl the list where all the rewards that have been created are kept
     * @return the new modified list for the rewards
     */
    public ArrayList<Reward> pickReward(ArrayList<Reward> rl)
    {
        for (Reward reward : rl) {
            if (reward.getLocation().equals(super.getLocation())) {
                System.out.println("Reward is picked");
                if (reward instanceof RegularReward)
                    this.collection = this.collection + 1;
                this.score = this.score + reward.getValue();
                rl.remove(reward);
                return rl;
            }
        }
        return rl;
    }

    /**
     * If the location of the player same as the location of the punishment then
     * it makes the players loose score by the worth of punishment's value
     *
     * @param pl the list where all the road blocks for punishment that have been created are kept
     * @return the new modified list for the road blocks
     */
    public ArrayList<PunishmentRoadBlock> punishment(ArrayList<PunishmentRoadBlock> pl)
    {
        for (PunishmentRoadBlock punishment : pl) {
            if (super.getLocation().equals( punishment.getLocation())) {
                this.score -= punishment.getValue();
                pl.remove(punishment);
                return pl;
            }
        }
        return pl;
    }

    /**
     * It checks if this Player caught by the enemy or not
     *
     * @param el the list of enemies in the game
     * @return true if this Player is in the same cell with the Enemy, otherwise false
     */
    public boolean caught(ArrayList<Enemy>el)
    {
        for (Enemy e : el) {
            if (super.getLocation().equals( e.getLocation())) {
                return true;
            }
        }
        return false;
    }
}

