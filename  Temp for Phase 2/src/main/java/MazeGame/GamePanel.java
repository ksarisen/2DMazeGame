package main.java.MazeGame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import main.java.Characters.Enemy;
import main.java.Characters.EnemyGenerator;
import main.java.Textures.Image;
import main.java.Characters.Player;
import javax.swing.JFrame;

public class GamePanel extends JPanel implements Runnable{
    // screen setting
    final int originaltilesize = 50;// 16 by 16 tiles
    final int scale = 1;
    final int tilesize = originaltilesize *scale;
    final int maxscreencol = 24;
    final int maxscreenrow = 17;
    final int screenwidth = tilesize * maxscreencol;
    final int screenheight = (tilesize * maxscreenrow);
    
    // we set the frame rate here
    int fps = 30;
    
    keyhandler keyh = new keyhandler();
    Thread gameThread;
    
    public static LevelGenerator level;
    private int currentLevel = 0;
    
    Timer timer = new Timer();
    
    //Store object mapping codes.
    private HashMap <String, GameObject> codes = new HashMap<>();
    
    //create base url for level loading
    private String basePath = "src/levels/";
    
	//create level options
	public String[] levels = new String[] {
								"Level1.json"
							};
	
	Player player = new Player(0, "Player 1", 0,0, new Point(0,0), this, new Image("Textures/Car.png"));
    EnemyGenerator enemyGenerator=new EnemyGenerator(this);
    ArrayList<Enemy> enemies= EnemyGenerator.getEnemyList();

	
    JFrame frame;
    public MenuBar menu = new MenuBar();
    
    public GamePanel(JFrame f){
        
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
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

        double drawinterval = 1000000000/fps; // this is around 0.01666 seconds
        double nextdrawtime = System.nanoTime() + drawinterval;
        // this is the core of the game
        //the game loop
        while(gameThread != null){
            
            update();
            repaint();
            
            // this is to call the paint componant method.

            try{
                double remainingtime = nextdrawtime - System.nanoTime();
                remainingtime = remainingtime/1000000; // convering nano seconds to mili seconds;

                if(remainingtime < 0){
                    remainingtime = 0;
                }
                Thread.sleep((long) remainingtime);
                nextdrawtime += drawinterval;

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
		//create level and build the game for the level #l
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
		//check if it is not the last level
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
        if(keyh.uppressed){
            player.setLocation(player.getLocation().x,player.getLocation().y-player.getSpeedy());
        }
        else if(keyh.downpressed){
            player.setLocation(player.getLocation().x,player.getLocation().y+player.getSpeedy());
        }
        else if(keyh.rightpressed){
            player.setLocation(player.getLocation().x+player.getSpeedx(),player.getLocation().y);
        }
        else if(keyh.leftpressed){
            player.setLocation(player.getLocation().x-player.getSpeedx(),player.getLocation().y);
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
        	g.drawImage(obj.texture.getTexture(), (int) obj.position.getX() * tilesize, (int) obj.position.getY() * tilesize, tilesize, tilesize, null);
        }
        g.drawImage(player.getTexture().getTexture(), (int) player.getLocation().getX() * tilesize , (int) player.getLocation().getY() * tilesize, tilesize, tilesize, null);
        for(Enemy e : enemies)
        {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tilesize , (int) e.getLocation().getY() * tilesize, tilesize, tilesize, null);
        }
        level.clearQueue();
        g2.dispose();
    }

}
