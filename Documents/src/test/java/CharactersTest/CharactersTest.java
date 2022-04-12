package CharactersTest;

import Characters.Enemy;
import Characters.Player;
import MazeGame.GamePanel;
import Textures.Image;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CharactersTest {
    JFrame frame=new JFrame();
    @Test
    void playerMoveUp_withoutBlocked() {
        Player player = new Player(0,new Point(16,3),new GamePanel(frame),new Image("Car-East.png"));
        player.moveUp();
        assertEquals(new Point(16,2),player.getLocation(), "fail to move up when there is no grass blocked");
    }
    @Test
    void enemyMoveUp_withBlocked_ByHelicopter() {
        Enemy enemy = new Enemy(8,new Image("Car-East.png"),new Point(21,2),new GamePanel(frame));
        assertFalse(enemy.moveUp(), "Wrong movement when there is helicopter blocked above the enemy");
    }

    @Test
    void playerMoveDown_withBlocked_ByGrass() {
        Player player = new Player(0,new Point(3,2),new GamePanel(frame),new Image("Car-East.png"));
        assertFalse(player.moveDown(), "Wrong movement when there is grass blocked down the player");
    }
    @Test
    void enemyMoveDown_withoutBlocked() {
        Enemy enemy = new Enemy(8,new Image("Car-East.png"),new Point(8,2),new GamePanel(frame));
        enemy.moveDown();
        assertEquals(new Point(8,3),enemy.getLocation(), "fail to move down when there is no grass blocked");
    }
    @Test
    void playerMoveLeft_withoutBlocked() {
        Player player = new Player(0,new Point(7,8),new GamePanel(frame),new Image("Car-East.png"));
        player.moveLeft();
        assertEquals(new Point(6,8),player.getLocation(), "fail to move left when there is no grass blocked");
    }
    @Test
    void enemyMoveLeft_withBlocked_ByGrass() {
        Enemy enemy = new Enemy(8,new Image("Car-East.png"),new Point(16,9),new GamePanel(frame));
        assertFalse(enemy.moveLeft(), "Wrong movement when there is helicopter blocked left to the enemy");
    }

    @Test
    void playerMoveRight_withBlocked_ByGrass() {
        Player player = new Player(0,new Point(16,9),new GamePanel(frame),new Image("Car-East.png"));
        assertFalse(player.moveRight(), "Wrong movement when there is grass blocked right to the player");
    }
    @Test
    void enemyMoveRight_withoutBlocked() {
        Enemy enemy = new Enemy(8,new Image("Car-East.png"),new Point(18,11),new GamePanel(frame));
        enemy.moveRight();
        assertEquals(new Point(19,11),enemy.getLocation(), "fail to move right when there is no grass blocked");
    }
}
