package MazeGame;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import Characters.Enemy;
import Characters.EnemyGenerator;
import Rewards.Reward;
import Rewards.RewardGenerator;
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

    Timer timer = new Timer();

    //Store object mapping codes.
    private HashMap <String, GameObject> codes = new HashMap<>();

    //create base URL for level loading
    private String basePath = "src/levels/";

	//create level options
	public String[] levels = new String[] {
								"Level1.json"
							};

	Player player = new Player(0, "Player 1", 0,0, new Point(0,0), this, new Image("Textures/Car.png"));

    EnemyGenerator enemyGenerator = new EnemyGenerator(this);
    ArrayList<Enemy> enemies = enemyGenerator.getEnemyList();

    RewardGenerator rewardGenerator = new RewardGenerator(this);
    ArrayList<Reward> rewards = rewardGenerator.getRewardsList();



    JFrame frame;
    public MenuBar menu = new MenuBar();

    public GamePanel(JFrame f){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.frame = f;
        this.startGame();

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
		this.level = new LevelGenerator();
		System.out.println(this.basePath + this.levels[l]);
		this.level.buildGame(this.basePath + this.levels[l]);

		Point start = level.getPlayerStart();

		player.setLocation(start);

		this.frame.add(menu, BorderLayout.NORTH);

		this.add(this.level, BorderLayout.CENTER);

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

	public LevelGenerator getCurrentLevel() {
		return this.level;
	}

    public void update(){
    	menu.update(player.getScore(), timer.getTimeRemaining());
        if(keyH.upPressed){
            player.setLocation(player.getLocation().x,player.getLocation().y-player.getSpeedY());
        }
        else if(keyH.downPressed){
            player.setLocation(player.getLocation().x,player.getLocation().y+player.getSpeedY());
        }
        else if(keyH.rightPressed){
            player.setLocation(player.getLocation().x+player.getSpeedX(),player.getLocation().y);
        }
        else if(keyH.leftPressed){
            player.setLocation(player.getLocation().x-player.getSpeedX(),player.getLocation().y);
        }
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
        	g.drawImage(obj.texture.getTexture(), (int) obj.position.getX() * tileSize, (int) obj.position.getY() * tileSize, tileSize, tileSize, null);
        }

        g.drawImage(player.getTexture().getTexture(), (int) player.getLocation().getX() * tileSize, (int) player.getLocation().getY() * tileSize, tileSize, tileSize, null);

        for(Enemy e : enemies) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        for(Reward e : rewards) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        level.clearQueue();
        g2.dispose();
    }

}
