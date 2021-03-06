package CharactersTest;

import static org.junit.jupiter.api.Assertions.*;

import Characters.Enemy;
import Characters.Player;
import MazeGame.GamePanel;
import RewardsAndPunishments.BonusReward;
import RewardsAndPunishments.PunishmentRoadBlock;
import RewardsAndPunishments.RegularReward;
import RewardsAndPunishments.Reward;
import Textures.Image;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerTest {

	private JFrame frame=new JFrame();
	GamePanel gamePanel=new GamePanel(frame);
	private Player player;
	@BeforeEach
	void setup(){
		gamePanel.getEnemiesList().clear();
		gamePanel.getPunishmentsList().clear();
		gamePanel.getRewardsList().clear();
	player = new Player(0,new Point(0,0),gamePanel,new Image("Car-East.png"));}

	
	@Test
	void generatePlayer() {
		//test player functions
		assertNotNull(player, "fail to create the player");
		player.getMap().getEnemiesList().clear();
		player.getMap().getRewardsList().clear();
		player.getMap().getPunishmentsList().clear();
	}

	@Test
	void winGame() {
		//test check
		player.setCollection(10);
		player.setLocation(new Point(21,1));
		assertTrue( player.checkWinTheGame(), "fail to win the game when the requirement are satisfied");
	}

	@Test
	void collectAll_NotArrive() {
		//test check
		player.setCollection(10);
		player.setLocation(new Point(20,1));
		assertFalse( player.checkWinTheGame(), "win this game when player not arrive the helicopter");
	}

	@Test
	void notCollectAll_NotArrive() {
		//test check
		player.setCollection(9);
		player.setLocation(new Point(21,1));
		assertFalse( player.checkWinTheGame(), "win this game when player not arrive the helicopter and not collect all rewards");
	}

	@Test
	void pickRegularReward() {
		//test pickReward
		ArrayList<Reward> rl=new ArrayList<>();
		Reward r1=new RegularReward(10,new Image("gas.png"),new Point(0,0),player.getMap());
		rl.add(r1);
		player.pickReward(rl);
		assertEquals( 0,player.pickReward(rl).size(), "fail to pick regular reward");
	}

	@Test
	void pickBonusReward() {
		//test pickReward
		ArrayList<Reward> rl=new ArrayList<>();
		Reward r1=new BonusReward(25,new Image("money.png"),new Point(0,0),player.getMap());
		rl.add(r1);
		player.pickReward(rl);
		assertEquals( 0,player.pickReward(rl).size(), "fail to pick bonus reward");
	}

	@Test
	void farFromReward() {
		//test pickReward
		ArrayList<Reward> rl=new ArrayList<>();
		Reward r1=new BonusReward(25,new Image("money.png"),new Point(20,10),player.getMap());
		rl.add(r1);
		player.pickReward(rl);
		assertEquals( 1,player.pickReward(rl).size(), "pick wrong reward");
	}

	@Test
	void getPunishment() {
		//test punishment
		ArrayList<PunishmentRoadBlock> pl=new ArrayList<>();
		PunishmentRoadBlock r1=new PunishmentRoadBlock(10,new Image("money.png"),new Point(0,0),player.getMap());
		pl.add(r1);
		player.getPunishments(pl);
		assertEquals( 0,player.getPunishments(pl).size(), "fail to get punishment");
	}

	@Test
	void farFromPunishment() {
		//test punishment
		ArrayList<PunishmentRoadBlock> pl=new ArrayList<>();
		PunishmentRoadBlock r1=new PunishmentRoadBlock(10,new Image("money.png"),new Point(20,10),player.getMap());
		pl.add(r1);
		player.getPunishments(pl);
		assertEquals( 1,player.getPunishments(pl).size(), "get wrong punishment");
	}

	@Test
	void beCaught() {
		//test caught
		ArrayList<Enemy> el=new ArrayList<>();
		Enemy e1=new Enemy(10,new Image("Police-West.png"),new Point(0,0),player.getMap());
		el.add(e1);
		assertTrue( player.caught(el), "Fail to be caught");
	}

	@Test
	void farFromEnemies() {
		//test caught
		ArrayList<Enemy> el=new ArrayList<>();
		Enemy e1=new Enemy(10,new Image("Police-West.png"),new Point(10,10),player.getMap());
		el.add(e1);
		assertFalse( player.caught(el), "Be caught by mistake");
	}

}
