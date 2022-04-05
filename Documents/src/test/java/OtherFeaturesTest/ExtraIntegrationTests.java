package OtherFeaturesTest;

import MazeGame.FailMenu;
import MazeGame.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

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
        panel.getPlayer().setLocation(new Point(21,1));
        panel.update();
        assertNotNull(panel.success,"Show the success");
    }
}
