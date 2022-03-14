package test.java.Characters;

import test.java.Rewards.Reward;
import java.awt.Point;
import java.util.ArrayList;

import test.java.MazeGame.GamePanel;
import test.java.Textures.Image;

public class Player extends Character{
    private int score;
    private String name;

    public Player (int score,String name,int speed,Point location, GamePanel map, Image texture)
    {
        super(location, texture, speed, map);
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
        return empty_r;
    }
    public Boolean collectReward(Reward r)
    {
        if(super.getLocation()==r.getLocation())
        {
            return true;
        }
        return false;
    }

    private int punishment( BarrierList bl, EnemyList el)
    {
        for()
        {
            if(this.getLocation()==b.getLocation)
            {
                return b.getScore;
            }
        }
        for()
        {
            if(this.getLocation()==e.getLocation)
            {
                return 10;//the punishment score if player touch the enemy
            }
        }
        return 0;
    }

    private void scoreIncrease ( Reward r)
    {
        if(r == empty_r)
        {
            return;
        }
        this.getScore()=this.getScore() + r.getScore();
        return;
    }

    private void scoreDecrease ( int punishment_score)
    {
        this.getScore()=this.getScore() - punishment_score;
        return;
    }
}

