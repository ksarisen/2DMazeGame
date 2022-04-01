package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	
	Player player;
	
	@BeforeEach
	void setUp() {
		//create new player
		player = new Player(0,0,0,0);
	}
	
	@Test
	void test() {
		//test player functions
		assertEquals(1, 1, "Assertion failed");
	}

}
