package test.java.MazeGame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.HashMap;
import test.java.Characters.Player;

import javax.swing.JFrame;

public class GamePanel extends JPanel implements Runnable{
    // screen setting
    final int originaltilesize = 50;// 16 by 16 tiles
    final int scale = 2;
    final int tilesize = originaltilesize *scale;
    final int maxscreencol = 6;
    final int maxscreenrow = 3;
    final int screenwidth = tilesize * maxscreencol;
    final int screenheight = tilesize * maxscreenrow;

    // we set the frame rate here

    int fps = 30;

    keyhandler keyh = new keyhandler();
    Thread gameThread;
    
    public static LevelGenerator level;
    private int currentLevel = 0;

    
    //Store object mapping codes.
    private HashMap <String, GameObject> codes = new HashMap<>();
    
    //create base url for level loading
    private String basePath = "src/";
    
	//create level options
	public String[] levels = new String[] {
								"Level1.json",
								"Level2.json",
								"Level3.json"
							};

    //get player start position
    Point start = level.getPlayerStart();
		
	player = new Player(0, "Player 1", 5, start, this, new Image("Textures/Car.png"));

    JFrame frame;
    

    public GamePanel(JFrame f){
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
       // this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
        this.startGame();
        //this.load(0);
        this.frame = f;
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

            //  System.out.println("The game loop is running");
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
		System.out.println("Create Gane");
		//create level and build the game for the level #l
		this.level = new LevelGenerator();
		this.level.buildGame(this.basePath + this.levels[l]);
		
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
	 * Switching the the next level or displays end of game message.
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
        level.clearQueue();
        g2.dispose();
    }

}
