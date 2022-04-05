package MazeGameTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.*;

import MazeGame.GamePanel;

public class GamePanelTest {

	GamePanel panel;
	
	@BeforeEach
	void setUp() {
		//create new player
		JFrame win = new JFrame();
		panel = new GamePanel(win);
	}
	
	@Test
	void testBuildGame() {
		//test player functions
		panel.load(0);
		assertNotEquals(panel.level, null, "Failed to create level");
	}
	
	@Test
	void testGameThread() {
		panel.startGameThread();
		assertNotNull(panel.getGameThread());
	}

	@Test
	void testRunAndUpdateAndRepaint() {
		panel.startGameThread();
		panel.run();
		assertEquals(panel.menu.getGasMeter().getText(), "0", "Gas meter text is not equal to player's score" );
		assertEquals(panel.menu.getTimer().getText(), panel.timer.getTimeRemaining(), "Timer doesn't show the correct remaining time");
		assertEquals(panel.getCheck(), 1);

	}
	
	@Test
	void testGameCompletion() {
		panel.getPlayer().setCollection(10);
		panel.getPlayer().setLocation(new Point(21, 1));
		assertEquals(panel.getPlayer().check(), true, "Could not complete game");
	}
}
