package Characters;

import MazeGame.KeyHandler;
import RewardsAndPunishments.PunishmentRoadBlock;
import RewardsAndPunishments.RegularReward;
import RewardsAndPunishments.Reward;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Objects;

import MazeGame.GamePanel;
import Textures.Image;

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
    }
    public boolean check()
    {
        return collection == 10 & Objects.equals(super.getLocation(), new Point(1, 21));
    }
    public int getCollection() {
        return collection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void pickReward(ArrayList<Reward> rl)
    {
        for (Reward reward : rl) {
            if (super.getLocation() == reward.getLocation()) {
                if (reward instanceof RegularReward)
                    this.collection = this.collection + 1;
                this.score = this.score + reward.getValue();
                rl.remove(reward);
            }
        }
    }

    public void punishment(ArrayList<PunishmentRoadBlock> pl)
    {
        for (PunishmentRoadBlock punishment : pl) {
            if (super.getLocation() == punishment.getLocation()) {
                this.score -= punishment.getValue();
                pl.remove(punishment);
                return;
            }
        }
    }
    public void moveUp_player() {
        if(KeyHandler.isUpPressed() & super.moveUp());

    }
    public void moveDown_player() {
        if(KeyHandler.isDownPressed() & super.moveDown());
    }
    public void moveRight_player()
    {
        if(KeyHandler.isRightPressed() & super.moveRight());
    }
    public void moveLeft_player()
    {
        if(KeyHandler.isLeftPressed() & super.moveLeft());
    }
}

