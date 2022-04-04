package MazeGameTest;

import MazeGame.FailMenu;
import MazeGame.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailMenuTest {
    GamePanel panel;

    @BeforeEach
    void setUp() {
        //create new Maze Game
        JFrame fail = new JFrame();
        panel = new GamePanel(fail);

    }

    @Test
    void testCreateFailMenu() {
        //test create Fail menu
        assertEquals("Fail Menu", FailMenu.jf.getTitle(), "Failed to create the Fail Menu");
    }
}
