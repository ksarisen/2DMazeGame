package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class RewardGeneratorTest {

    RewardGenerator rewardGenerator;

    JFrame frame = new JFrame();
    Image regRewardImg = new Image("gas.png");
    Image bonusRewardImg = new Image("money.png");

    @BeforeEach
    void setUp() {
        rewardGenerator = new RewardGenerator(new GamePanel(frame));
    }

    @Test
    void isRegularRewardGenerated() {

        assertEquals(rewardGenerator.getRewardsList().size(), 10, "The amount of the rewards that are generated in the list is not what it should be which is 10.");
        assertEquals(rewardGenerator.getRewardsList().get(0).getValue(), 10, "The value of the regular reward is not 10!" );
        assertEquals(rewardGenerator.getRewardsList().get(0).getTexture(), regRewardImg, "The assigned image of the generated regular reward is wrong.");
    }

    @Test
    void isBonusRewardGenerated() {

        assertEquals(rewardGenerator.getRewardsList().size(), 10, "The amount of the rewards that are generated in the list is not what it should be which is 10.");
        assertEquals(rewardGenerator.getRewardsList().get(rewardGenerator.getRewardsList().size()-1).getValue(), 25, "The value of the bonus reward is not 10!" );
        assertEquals(rewardGenerator.getRewardsList().get(rewardGenerator.getRewardsList().size()-1).getTexture(), bonusRewardImg, "The assigned image of the generated bonus reward is wrong.");
    }
}