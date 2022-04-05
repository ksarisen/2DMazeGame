package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BonusRewardTest {
    int maxCordX = 25;
    int maxCordY = 15;

    Random r = new Random();

    int xCord = r.nextInt(maxCordX - 1);
    int yCord = r.nextInt(maxCordY - 1);

    private final JFrame frame = new JFrame();
    private final GamePanel panel = new GamePanel(frame);
    private final Point point = new Point(xCord, yCord);

    private final Image bonusRewardImage = new Image("money.png");

    @Test
    public void bonusRewardConstructorTest() {
        Reward bonusReward = new RegularReward(25, bonusRewardImage, point, panel);
        assertNotNull(bonusReward, "Failed to create the bonus reward object");
        assertEquals(bonusReward.getTexture(), bonusRewardImage, "Failed to connect the object with the right texture");
        assertEquals(bonusReward.getValue(), 25, "Failed to create an object with the correct value");
        assertEquals(bonusReward.getMap(), panel, "Failed to create an object on the correct panel");
        assertEquals(bonusReward.getLocation(), point, "Failed to create an object in the correct cell location");
    }
}