package MazeGameTest;

import MazeGame.KeyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;


public class KeyHandlerTest {
    KeyHandler k;
    @BeforeEach
    void setup()
    {
        k=new KeyHandler();
    }
    @Test
    void HandlerTheKeyPressRight()
    {
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 68, 'a');
        k.keyPressed(e);//"D" in key broad;
        assertTrue(k.rightPressed,"fail to read the press D command from key board");
    }
    @Test
    void HandlerTheKeyPressUp()
    {
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 87, 'a');
        k.keyPressed(e);//"W" in key broad;
        assertTrue(k.upPressed,"fail to read the press W command from key board");
    }
    @Test
    void HandlerTheKeyPressLeft()
    {
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 65, 'a');
        k.keyPressed(e);//"A" in key broad;
        assertTrue(k.leftPressed,"fail to read the press A command from key board");
    }
    @Test
    void HandlerTheKeyPressDown()
    {
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 83, 'a');
        k.keyPressed(e);//"S" in key broad;
        assertTrue(k.downPressed,"fail to read the press S command from key board");
    }

    @Test
    void HandlerTheKeyReleaseRight()
    {
        k.rightPressed=true;
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 68, 'a');
        k.keyReleased(e);//"D" in key broad;
        assertFalse(k.rightPressed,"fail to read the release D command from key board");
    }
    @Test
    void HandlerTheKeyReleaseUp()
    {
        k.upPressed=true;
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 87, 'a');
        k.keyReleased(e);//"W" in key broad;
        assertFalse(k.upPressed,"fail to read the release W command from key board");
    }
    @Test
    void HandlerTheKeyReleaseLeft()
    {
        k.leftPressed=true;
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 65, 'a');
        k.keyReleased(e);//"A" in key broad;
        assertFalse(k.leftPressed,"fail to read the release A command from key board");
    }
    @Test
    void HandlerTheKeyReleaseDown()
    {
        k.downPressed=true;
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 83, 'a');
        k.keyReleased(e);//"S" in key broad;
        assertFalse(k.downPressed,"fail to read the release S command from key board");
    }
}
