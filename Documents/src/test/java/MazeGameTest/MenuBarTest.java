package MazeGameTest;

import MazeGame.GamePanel;
import MazeGame.MenuBar;
import MazeGame.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuBarTest {
    MenuBar menubar;

    @BeforeEach
    void setUp() {
        //create new menu bar
        menubar=new MenuBar();

    }

    @Test
    void testCreateMenuBar() {
        //test create menu bar
        assertNotNull(menubar, "Failed to create the Menu Bar");
    }

    @Test
    void UpdateTimeInMenuBar()
    {
        menubar.update(100,"9:20");
        assertEquals("9:20",menubar.getTimer().getText(),"Fail to update the time in menu bar");
    }
@Test
    void UpdateScoreInMenuBar()
    {
        menubar.update(100,"9:20");
        assertEquals("100",menubar.getGasMeter().getText(),"Fail to update the score in menu bar");
    }
}
