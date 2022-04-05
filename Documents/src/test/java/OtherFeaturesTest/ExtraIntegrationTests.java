package OtherFeaturesTest;

import MazeGame.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExtraIntegrationTests {
    GamePanel panel;

    @BeforeEach
    void setup() {
        if (panel != null) {
            panel.getRewardsList().clear();
            panel.getPunishmentsList().clear();
            panel.getEnemiesList().clear();
        }
        JFrame win = new JFrame();
        panel = new GamePanel(win);
    }

    @Test
    void WinTheGameAfterCollectedAllAndArrived() {
        panel.getPlayer().setCollection(10);
        panel.getPlayer().setLocation(new Point(21, 1));
        panel.update();
        assertNotNull(panel.success, "Show the success");
    }

    @Test
    void MoveThePlayerWithKeyBoard() throws AWTException {
        Point old_location = panel.getPlayer().getLocation();

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_D);
        for(int i=0;i<=80;i++)
            panel.update();
        r.keyRelease(KeyEvent.VK_D);
        Point new_location = panel.getPlayer().getLocation();
        assertNotEquals(old_location,new_location, "Fail to move the player by key broad");
    }
}
