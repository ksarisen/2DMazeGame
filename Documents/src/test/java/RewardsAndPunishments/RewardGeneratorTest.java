package RewardsAndPunishments;

import MazeGame.GamePanel;
import MazeGame.LevelGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RewardGeneratorTest {

    private final JFrame frame= new JFrame();
    GamePanel map = new GamePanel(frame);
    @BeforeEach
    void setup()
    {
        if(map!=null) {
            map.getEnemiesList().clear();
            map.getPunishmentsList().clear();
            map.getRewardsList().clear();
        }
    }

    @Test
    void generateAllRewards()
    {
        // Test RewardGenerator
        map.getRewardsList().clear();
        RewardGenerator rewardGenerator = new RewardGenerator(map);
        assertEquals(12,rewardGenerator.getRewardsList().size(), "Failed to create all rewards by the generator");
    }
    @Test
    void generateRegularReward()
    {
        // Test generateRegularReward
        map.getRewardsList().clear();
        RewardGenerator rewardGenerator = new RewardGenerator(map);
        assertNotNull(rewardGenerator.generateRegularReward(map), "Failed to create a regular reward by the generator");
    }
    @Test
    void generateBonusReward()
    {
        // Test generateBonusReward
        map.getRewardsList().clear();
        RewardGenerator rewardGenerator = new RewardGenerator(map);
        assertNotNull(rewardGenerator.generateBonusReward(map), "Failed to create a bonus reward by the generator");
    }
    @Test
    void rewardOnRoad()
    {
        map.getRewardsList().clear();
        RewardGenerator rewardGenerator = new RewardGenerator(map);
        ArrayList<Reward> rewardsList = rewardGenerator.getRewardsList();
        boolean check = true;
        for(Reward e:rewardsList)
        {
            if(!LevelGenerator.gameObjects[(int) e.getLocation().getY()][(int) e.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            {
                check = false;
            }
        }
        assertTrue(check, "Some rewards have not been generated on the road");
    }

    @Test
    void rewardInTheSamePosition()
    {
        map.getRewardsList().clear();
        RewardGenerator rewardGenerator = new RewardGenerator(map);
        ArrayList<Reward> rewardsList = rewardGenerator.getRewardsList();
        boolean check = true;
        for(Reward e:rewardsList)
        {
            for(Reward e2:rewardsList)
                if (e != e2 & e.getLocation().equals(e2.getLocation())) {
                    check = false;
                    break;
                }
        }
        assertTrue(check, "Some rewards have been generated in the same location");
    }
}