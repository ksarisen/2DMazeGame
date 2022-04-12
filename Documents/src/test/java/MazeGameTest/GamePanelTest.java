package MazeGameTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import Characters.Enemy;
import org.junit.jupiter.api.*;

import MazeGame.GamePanel;

import java.awt.*;

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
	void testGameCompletion() {
		panel.getPlayer().setCollection(10);
		panel.getPlayer().setLocation(new Point(21, 1));
		assertTrue(panel.getPlayer().checkWinTheGame(), "Could not complete game");
	}

	@Test
	void testUpdate() {
		// When check == 20
		panel.setCheck(19);
		panel.getPlayer().setCollection(10);
		panel.getPlayer().setLocation(new Point(21, 1));
		panel.update();
		for (Enemy e : panel.getEnemiesList()) {
			assertTrue(e.getChase(), "Enemy failed to chase on the panel");
		}
		assertEquals(panel.getGameThread(), null);
		assertEquals(panel.getCheck(), 0);
	}
}
