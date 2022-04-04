package CharactersTest;

import Characters.Enemy;
import Characters.EnemyGenerator;
import MazeGame.GamePanel;
import org.junit.jupiter.api.*;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyGeneratorTest {
    private JFrame frame= new JFrame();
    GamePanel map=new GamePanel(frame);
    @Test
    void generateAllEnemies()
    {
        //test EnemyGenerator
        map.getEnemiesList().clear();
        EnemyGenerator enemyGenerator=new EnemyGenerator(map);
        assertEquals(3,enemyGenerator.getEnemyList().size(), "fail to create all enemies by the generator");
    }
    @Test
    void generateEnemy()
    {
        //test generateEnemy
        map.getEnemiesList().clear();
        EnemyGenerator enemyGenerator=new EnemyGenerator(map);
        map.getEnemiesList().clear();
        enemyGenerator.generateEnemy(map);
        assertNotNull(enemyGenerator.generateEnemy(map), "fail to create an enemy by the generator");
    }
    @Test
    void enemyInRoad()
    {
        //test generateEnemy
        map.getEnemiesList().clear();
        EnemyGenerator enemyGenerator=new EnemyGenerator(map);
        ArrayList<Enemy>el=enemyGenerator.getEnemyList();
        boolean check=true;
        for(Enemy e:el)
        {
            if(!map.level.gameObjects[(int) e.getLocation().getY()][(int) e.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            {
                check=false;
            }
        }
        assertTrue(check, "Some enemies does not been generated in road");
    }

    @Test
    void enemyInTheSamePosition()
    {
        //test generateEnemy
        map.getEnemiesList().clear();
        EnemyGenerator enemyGenerator=new EnemyGenerator(map);
        ArrayList<Enemy>el=enemyGenerator.getEnemyList();
        boolean check=true;
        for(Enemy e1:el)
        {
            for(Enemy e2:el)
            if(e1!=e2&e1.getLocation().equals(e2.getLocation()))
            {
                check=false;
            }
        }
        assertTrue(check, "Some enemies does not been generated in road");
    }
}
