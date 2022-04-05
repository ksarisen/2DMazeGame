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
    void HandlerTheKeyPressDown()

    {
        Button a = new Button("click");
        KeyEvent e=new KeyEvent(a, 1, 20, 1, 68, 'a');
        k.keyPressed(e);//"D" in key broad;
        assertTrue(k.rightPressed);
    }
}
