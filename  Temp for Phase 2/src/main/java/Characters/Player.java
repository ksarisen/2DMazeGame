package main.java.Characters;

import main.java.MazeGame.keyhandler;
import main.java.Rewards.Barrier;
import main.java.Rewards.Reward;
import java.awt.Point;
import java.util.ArrayList;

import main.java.MazeGame.GamePanel;
import main.java.Textures.Image;

public class Player extends Character {
    private int score;
    private String name;
    private  int health;

    public Player (int score,String name,int speedx,int speedy,Point location, GamePanel map, Image texture)
    {
        super(location, texture, speedx,speedy, map);
        this.score = score;
        this.name = name;
        this.health=100;
        return;
    }

    public int getHealth() {
        return health;
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


    private Reward pickReward(ArrayList<Reward> rl)
    {
        for(int i=0;i<rl.size();i++)
        {
            if(super.getLocation()==rl.get(i).getLocation())
            {
                return rl.get(i);
            }
        }
        return null;
    }
    public Boolean collectReward(Reward r)
    {
        if(super.getLocation()==r.getLocation())
        {
            return true;
        }
        return false;
    }

    private void punishment(ArrayList<Barrier> bl, ArrayList<Enemy> el)
    {
        for(int i=0;i<bl.size();i++)
        {
            if(super.getLocation()==bl.get(i).getLocation())
            {
                this.health=this.health-20;
                return;
            }
        }
        for(int i=0;i<el.size();i++)
        {
            if(super.getLocation()==el.get(i).getLocation())
            {
                this.health=this.health-20;
                return;
            }
        }
    }

    private void scoreIncrease ( Reward r)
    {
        if(r == null)
        {
            return;
        }
        this.score=this.score + r.getScore();
        return;
    }


    public void moveUp_player()
    {
        if(keyhandler.isUppressed()==true & super.moveUp());

    }
    public void moveDown_player()
    {
        if(keyhandler.isDownpressed()==true & super.moveDown());
    }
    public void moveRight_player()
    {
        if(keyhandler.isRightpressed()==true & super.moveRight());
    }
    public void moveLeft_player()
    {
        if(keyhandler.isLeftpressed()==true & super.moveLeft());
    }
}

