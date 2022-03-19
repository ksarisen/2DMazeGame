package MazeGame;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import Characters.Enemy;
import Characters.EnemyGenerator;
import Objects.Road;
import RewardsAndPunishments.PunishmentGenerator;
import RewardsAndPunishments.PunishmentRoadBlock;
import RewardsAndPunishments.Reward;
import RewardsAndPunishments.RewardGenerator;
import Textures.Image;
import Characters.Player;
import javax.swing.JFrame;

public class GamePanel extends JPanel implements Runnable{
    // Screen setting
    final int originalTileSize = 50;// 16 by 16 tiles
    final int scale = 1;
    final int tileSize = originalTileSize *scale;
    final int maxScreenCol = 24;
    final int maxScreenRow = 17;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = (tileSize * maxScreenRow);

    // Set the frame rate here
    int fps = 30;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    public static LevelGenerator level;
    private int currentLevel = 0;
    private  int check=0;

    Timer timer = new Timer();

    //create base URL for level loading
    private String basePath = "src/main/java/Levels/";

	//create level options
	public String[] levels = new String[] {
								"Level1.json"
							};

	Player player = new Player(0, "Player 1", 0,0, new Point(0,0), this, new Image("Car.png"));

    EnemyGenerator enemyGenerator;
    ArrayList<Enemy> enemies;

    PunishmentGenerator punishmentGenerator;
    ArrayList<PunishmentRoadBlock> punishments;

    RewardGenerator rewardGenerator;
    ArrayList<Reward> rewards;

    JFrame frame;
    public MenuBar menu = new MenuBar();

    public GamePanel(JFrame f){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.frame = f;
        this.startGame();
        this.setVisible(true);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/fps; // this is around 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        // This is the core of the game
        // Game loop
        while(gameThread != null){

            update();
            repaint();

            // This is to call the paint component method.

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;      // Converting nano seconds to milliseconds;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
	 * @author Reece Landry
	 * @param l
	 * Loads level #l
	 */
	public void load(int l) {
		if(this.level != null) {
			this.remove(this.level);
			this.revalidate();
		}
		System.out.println("Create Game");
		// Create level and build the game for the level #l
		GamePanel.level = new LevelGenerator();
		System.out.println(this.basePath + this.levels[l]);
		GamePanel.level.buildGame(this.basePath + this.levels[l]);
		
		Point start = level.getPlayerStart();
		player.setLocation(start);

		this.frame.add(menu, BorderLayout.NORTH);
		this.add(this.level, BorderLayout.CENTER);
        enemyGenerator = new EnemyGenerator(this);
        enemies = enemyGenerator.getEnemyList();

        punishmentGenerator = new PunishmentGenerator(this);
        punishments = punishmentGenerator.getPunishmentsList();

        rewardGenerator = new RewardGenerator(this);
        rewards = rewardGenerator.getRewardsList();

	}

	/**
	 * @author Reece Landry
	 * Starts the game using the current Level
	 */
	public void startGame() {
		this.load(this.currentLevel);
	}

	/**
	 * @author Reece Landry
	 * Switching the next level or displays end of game message.
	 */
	public void nextLevel() {
		// Check if it is not the last level
		if(this.currentLevel < this.levels.length - 1) {
			this.currentLevel++;
			this.load(this.currentLevel);
		}else {
			//TODO: show end game menu
		}
	}

	public void restartLevel() {
		this.load(this.currentLevel);
	}

    //Accessors
    public ArrayList<Enemy> getEnemiesList () {
        return enemies;
    }
    public ArrayList<PunishmentRoadBlock> getPunishmentsList () {
        return punishments;
    }
    public ArrayList<Reward> getRewardsList () {
        return rewards;
    }
	public LevelGenerator getCurrentLevel() {
		return this.level;
	}

    public void update(){
    	menu.update(player.getScore(), timer.getTimeRemaining());
        check++;
        while(check==30){
            check=0;
        System.out.println(player.getLocation().x);
        System.out.println(player.getLocation().y);
        Road r = (Road) level.gameObjects[player.getLocation().y][player.getLocation().x];
        System.out.println(r.isWest());
        System.out.println(r.isEast());
        System.out.println(r.isSouth());
        System.out.println(r.isNorth());
        if(keyH.upPressed){
            player.moveUp();
        }
        else if(keyH.downPressed){
            player.moveDown();
        }
        else if(keyH.rightPressed){
            player.moveRight();
        }
        else if(keyH.leftPressed){
            player.moveLeft();
        }
            punishments=player.punishment(punishments);
        }
        //for(Enemy e:enemies)
        //{
        //    e.chase(player);
        //}
        player.check();
        rewards=player.pickReward(rewards);
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        level.clearQueue();

        for(GameObject[] y : level.gameObjects) {
           for(GameObject x : y) {
               level.queue(x);
            }
        }
        for(GameObject obj : level.queue) {
        	g.drawImage(obj.getTexture().getTexture(), (int) obj.position.getX() * tileSize, (int) obj.position.getY() * tileSize, tileSize, tileSize, null);
        }
        g.drawImage(player.getTexture().getTexture(), (int) player.getLocation().getX() * tileSize, (int) player.getLocation().getY() * tileSize, tileSize, tileSize, null);
        for(Enemy e : enemies) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        for(Reward e : rewards) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        for(PunishmentRoadBlock e : punishments) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }
       
        level.clearQueue();
        g2.dispose();
    }

}
