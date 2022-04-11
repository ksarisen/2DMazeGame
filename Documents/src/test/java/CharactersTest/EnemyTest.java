package CharactersTest;
import Characters.Enemy;
import Characters.Player;
import MazeGame.GamePanel;
import Textures.Image;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    private Enemy enemy;
    private JFrame frame=new JFrame();

    @BeforeEach
    void setUp() {
        //create new enemy
        frame=new JFrame();
        enemy = new Enemy(8,new Image("Police-East.png"),new Point(16,3),new GamePanel(frame));
    }

    @Test
    void generateEnemy(){
        assertNotNull(enemy, "fail to create the enemy");
    }

    @Test
    void calculateDistance()
    {
        //test getDistance
        Player player = new Player(0,"null",new Point(18,5),new GamePanel(frame),new Image("Car-East.png"));
        assertEquals(4, enemy.getDistance(player), "fail to calculate the distance from player");
    }

    @Test
    void playerInAbove_withoutBlocked()
    {
        //test tightChase
        Player player = new Player(0,"null",new Point(16,2),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        enemy.getMap().getRewardsList().clear();
        assertEquals(new Point(16,2), enemy.getLocation(), "fail to chase the player in above");
    }

    @Test
    void playerInTheLeft_withoutBlocked()
    {
        //test tightChase
        enemy.setLocation(new Point(6,8));
        Player player = new Player(0,"null",new Point(3,8),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        enemy.getMap().getRewardsList().clear();
        assertEquals(new Point(5,8), enemy.getLocation(), "fail to chase the player in the left");
    }

    @Test
    void playerInTheRight_Blocked()
    {
        //test tightChase
        enemy.setLocation(new Point(10,6));
        Player player = new Player(0,"null",new Point(12,6),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        enemy.getMap().getRewardsList().clear();
        assertNotEquals(new Point(11,6), enemy.getLocation(), "fail to chase the player in the right when a grass blocked in the right");
    }

    @Test
    void playerInBottom_Blocked()
    {
        //test tightChase
        enemy.setLocation(new Point(10,3));
        Player player = new Player(0,"null",new Point(10,5),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        assertNotEquals(new Point(10,4), enemy.getLocation(), "fail to chase the player in bottom when a grass blocked in bottom");
    }

    @Test
    void playerOutOfRange_withoutBlocked()
    {
        //test randomChase
        enemy.setLocation(new Point(13,4));
        Player player = new Player(0,"null",new Point(2,21),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        enemy.getMap().getRewardsList().clear();
        assertNotEquals(new Point(13,4),enemy.getLocation() , "fail to move when the player out of the view range");
    }

    @Test
    void playerOutOfRange_BlockedOneWay()
    {
        //test randomChase
        enemy.setLocation(new Point(10,3));
        Player player = new Player(0,"null",new Point(2,21),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        assertNotEquals(new Point(10,3) ,enemy.getLocation(), "fail to move when the player out of the view range and 1 way of the enemy is blocked by grass");
    }

    @Test
    void playerOutOfRange_BlockedTwoWays()
    {
        //test randomChase
        enemy.setLocation(new Point(2,5));
        Player player = new Player(0,"null",new Point(2,21),new GamePanel(frame),new Image("Car-East.png"));
        enemy.chase(player);
        assertNotEquals(new Point(2,5) ,enemy.getLocation(), "fail to move when the player out of the view range and 2 ways of the enemy is blocked by grass");
    }

}
