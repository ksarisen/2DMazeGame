package RewardsAndPunishments;

import MazeGame.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PunishmentGeneratorTest {

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
    void generateAllPunishments()
    {
        // Test PunishmentGenerator
        map.getPunishmentsList().clear();
        PunishmentGenerator punishmentGenerator = new PunishmentGenerator(map);
        assertEquals(5 ,punishmentGenerator.getPunishmentsList().size(), "Failed to create all punishments by the generator");
    }
    @Test
    void generatePunishment()
    {
        // Test generatePunishment
        map.getPunishmentsList().clear();
        PunishmentGenerator punishmentGenerator = new PunishmentGenerator(map);
        assertNotNull(punishmentGenerator.generatePunishment(map), "Failed to create a punishment by the generator");
    }
    @Test
    void punishmentOnRoad()
    {
        map.getPunishmentsList().clear();
        PunishmentGenerator punishmentGenerator = new PunishmentGenerator(map);
        ArrayList<PunishmentRoadBlock> punishmentList = punishmentGenerator.map.getPunishmentsList();
        boolean check = true;
        for(PunishmentRoadBlock e:punishmentList)
        {
            if(!map.level.gameObjects[(int) e.getLocation().getY()][(int) e.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            {
                check = false;
            }
        }
        assertTrue(check, "Some punishments have not been generated on the road");
    }

    @Test
    void punishmentsInTheSamePosition()
    {
        map.getPunishmentsList().clear();
        PunishmentGenerator punishmentGenerator = new PunishmentGenerator(map);
        ArrayList<PunishmentRoadBlock> punishmentList = punishmentGenerator.map.getPunishmentsList();

        boolean check = true;
        for(PunishmentRoadBlock e:punishmentList)
        {
            for(Reward e2:punishmentList)
                if (e != e2 & e.getLocation().equals(e2.getLocation())) {
                    check = false;
                    break;
                }
        }
        assertTrue(check, "Some punishments have been generated in the same location");
    }
}