package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class PunishmentGeneratorTest {

    PunishmentGenerator punishmentGenerator;

    JFrame frame = new JFrame();
    Image punishmentImg = new Image("Construction.png");

    @BeforeEach
    void setUp() {
        punishmentGenerator = new PunishmentGenerator(new GamePanel(frame));
    }

    @Test
    void isPunishmentGenerated() {

        assertEquals(punishmentGenerator.getPunishmentsList().size(), 4, "The amount of the punishments that are generated in the list is not what it should be which is 4.");
        assertEquals(punishmentGenerator.getPunishmentsList().get(0).getValue(), 15, "The value of the punishment is not 15!" );
        assertEquals(punishmentGenerator.getPunishmentsList().get(0).getTexture(), punishmentImg, "The assigned image of the punishment is wrong.");
    }
}