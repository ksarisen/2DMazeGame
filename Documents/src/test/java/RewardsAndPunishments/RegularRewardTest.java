package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RegularRewardTest {

    int maxCordX = 25;
    int maxCordY = 15;

    Random r = new Random();

    int xCord = r.nextInt(maxCordX - 1);
    int yCord = r.nextInt(maxCordY - 1);

    private final JFrame frame = new JFrame();
    private final GamePanel panel = new GamePanel(frame);
    private final Point point = new Point(xCord, yCord);

    private final Image regRewardImg = new Image("gas.png");
    @BeforeEach
    void setup()
    {
        if(panel!=null) {
            panel.getEnemiesList().clear();
            panel.getPunishmentsList().clear();
            panel.getRewardsList().clear();
        }
    }

    @Test
    public void regRewardConstructorTest() {
        Reward regularReward = new RegularReward(10, regRewardImg, point, panel);
        assertNotNull(regularReward, "Failed to create the regular reward");
        assertEquals(regularReward.getTexture(), regRewardImg, "Failed to connect the object with the right texture");
        assertEquals(regularReward.getValue(), 10, "Failed to create an object with the correct value");
        assertEquals(regularReward.getMap(), panel, "Failed to create an object on the correct panel");
        assertEquals(regularReward.getLocation(), point, "Failed to create an object in the correct cell location");
    }
}