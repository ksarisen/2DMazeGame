package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PunishmentRoadBlockTest {

    int maxCordX = 25;
    int maxCordY = 15;

    Random r = new Random();

    int xCord = r.nextInt(maxCordX - 1);
    int yCord = r.nextInt(maxCordY - 1);

    private final JFrame frame = new JFrame();
    private final GamePanel panel = new GamePanel(frame);
    private final Point point = new Point(xCord, yCord);

    private final Image punishmentImg = new Image("Construction.png");

    @Test
    public void punishmentConstructorTest() {
        PunishmentRoadBlock roadBlock = new PunishmentRoadBlock(15, punishmentImg, point, panel);
        assertNotNull(roadBlock, "Failed to create the road block object");
        assertEquals(roadBlock.getTexture(), punishmentImg, "Failed to connect the object with the right texture");
        assertEquals(roadBlock.getValue(), 15, "Failed to create an object with the correct value");
        assertEquals(roadBlock.getMap(), panel, "Failed to create an object on the correct panel");
        assertEquals(roadBlock.getLocation(), point, "Failed to create an object in the correct cell location");
    }
}