package MazeGameTest;

import MazeGame.GamePanel;
import MazeGame.SuccessMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessMenuTest {
    GamePanel panel;

    @BeforeEach
    void setUp() {
        //create new Maze Game
        JFrame win = new JFrame();
        panel = new GamePanel(win);

    }

    @Test
    void testCreateFailMenu() {
        //test create Success menu
        assertEquals("Success Menu", SuccessMenu.jf.getTitle(), "Failed to create the Success Menu");
    }
}
