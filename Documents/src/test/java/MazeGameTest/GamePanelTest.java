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
}
