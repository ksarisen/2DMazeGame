public class Player extends Character{
    private int score;
    private String name;

    public Player (int score,String name,int speed,Cell location,Maze map)
    {
        this.score=score;
        this.name=name;
        this.setSpeed(speed);
        this.setLocation(location);
        this.setMap(map);
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

    private Reward pickReward(RewardList rl, Player p)
    {
        for()
        {
            if(p.getLocation()==r.getLocation)
            {
                return r;
            }
        }
        return empty_r;
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
