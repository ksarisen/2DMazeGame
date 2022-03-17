package test.java.Characters;

import test.java.MazeGame.keyhandler;
import test.java.MazeGame.Barrier;
import test.java.Rewards.Reward;
import java.awt.Point;
import java.util.ArrayList;

import test.java.MazeGame.GamePanel;
import test.java.Textures.Image;

public class Player extends Character {
    private int score;
    private String name;

    public Player (int score,String name,int speedx,int speedy,Point location, GamePanel map, Image texture)
    {
        super(location, texture, speedx,speedy, map);
        this.score = score;
        this.name = name;
        return;
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

    private int punishment(ArrayList<Barrier> bl, ArrayList<Enemy> el)
    {
        for(int i=0;i<bl.size();i++)
        {
            if(super.getLocation()==bl.get(i).getLocation())
            {
                return bl.get(i).getScore();
            }
        }
        for(int i=0;i<el.size();i++)
        {
            if(super.getLocation()==el.get(i).getLocation())
            {
                return 10;//the punishment score if player touch the enemy
            }
        }
        return 0;
    }

    public void scoreIncrease(Reward r)
    {
        if(r == null)
        {
            return;
        }
        this.score=this.score + r.getValue();
        return;
    }

    public void scoreDecrease ( int punishment_score)
    {
        this.score=this.score - punishment_score;
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

