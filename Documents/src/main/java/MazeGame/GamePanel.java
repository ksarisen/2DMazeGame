package MazeGame;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

import Characters.Enemy;
import Characters.EnemyGenerator;

import Objects.GameObject;
import RewardsAndPunishments.PunishmentGenerator;
import RewardsAndPunishments.PunishmentRoadBlock;
import RewardsAndPunishments.Reward;
import RewardsAndPunishments.RewardGenerator;
import Textures.Image;
import Characters.Player;

import javax.swing.JFrame;

/**
 * It creates the panel where the game is being shown to the user
 *
 * @author Hoomehr Mangoli
 */
public class GamePanel extends JPanel implements Runnable {
    // Screen setting
    final int originalTileSize = 50; // 16 by 16 tiles
    final int scale = 1;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 24;
    final int maxScreenRow = 17;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = (tileSize * maxScreenRow);

    // Sets the frame rate here
    int fps = 30;
    double remainingTime;

    public FailMenu fail;
    public SuccessMenu success;

    KeyHandler keyH = new KeyHandler();
    private Thread gameThread;

    public static LevelGenerator level;
    private int currentLevel = 0;
    private int check = 0;

    Timer timer = new Timer();

    // Creates base URL for level loading
    private String basePath = "src/main/java/Levels/";

    // Creates level options
    public String[] levels = new String[]{
            "Level1.json"
    };

    Player player = new Player(0, "Player 1", 0, 0, new Point(0, 0), this, new Image("Car-East.png"));

    EnemyGenerator enemyGenerator;
    ArrayList<Enemy> enemies = null;

    PunishmentGenerator punishmentGenerator;
    ArrayList<PunishmentRoadBlock> punishments = null;

    RewardGenerator rewardGenerator;
    ArrayList<Reward> rewards = null;

    JFrame frame;
    public MenuBar menu = new MenuBar();

    /**
     * Constructor that creates the panel where the game will be screened
     *
     * @param f JFrame
     */
    public GamePanel(JFrame f) {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.frame = f;
        this.startGame();
        this.setVisible(true);

    }

    /**
     * getter of the Thread
     */
    public Thread getGameThread() {
        return gameThread;
    }

    /**
     * Starts the Thread
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Runs the panel
     */
    @Override
    public void run() {

        double drawInterval = 1000000000 / fps; // this is around 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        // This is the core of the game
        // Game loop
        while (gameThread != null) {

            update();
            repaint();

            // This is to call the paint component method.

            try {
                remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;      // Converting nano seconds to milliseconds;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * Loads level #1
     *
     * @param l new level
     * @author Reece Landry
     */
    public void load(int l) {
        if (this.level != null) {
            this.remove(this.level);
            this.revalidate();
        }
        System.out.println("Create Game");

        // Creates level and builds the game for the level #l
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
     * Starts the game using the current Level
     *
     * @author Reece Landry
     */
    public void startGame() {
        this.load(this.currentLevel);
    }

    /**
     * Switching the next level or displays end of game message
     *
     * @author Reece Landry
     */
    public void nextLevel() {

        // Check if it is not the last level
        if (this.currentLevel < this.levels.length - 1) {
            this.currentLevel++;
            this.load(this.currentLevel);
        } else {
            //TODO: show end game menu
        }
    }

    public void restartLevel() {
        this.load(this.currentLevel);
    }

    /**
     * Accessors
     */
    public ArrayList<Enemy> getEnemiesList() {
        return enemies;
    }

    public ArrayList<PunishmentRoadBlock> getPunishmentsList() {
        return punishments;
    }

    public ArrayList<Reward> getRewardsList() {
        return rewards;
    }

    public LevelGenerator getCurrentLevel() {
        return this.level;
    }

    public Player getPlayer(){return player;}

    /**
     * It updates the game after each cell the player moves.
     * If 'W' is pressed, it moves towards north, else if 'S' is pressed, it moves towards south
     * If 'D' is pressed, it moves towards east, else if 'A' is pressed, it moves towards west
     * If there is nay reward or punishment in the cell that Player arrived, then it makes the player collects them.
     * Collectibles disappear after being collected, and chase method for enemies being checked
     */
    public void update() {
        menu.update(player.getScore(), timer.getTimeRemaining());
        check++;
        if (check == 10 || check == 20) {
            if (keyH.upPressed) {
                player.moveUp();
            } else if (keyH.downPressed) {
                player.moveDown();
            } else if (keyH.rightPressed) {
                player.moveRight();
            } else if (keyH.leftPressed) {
                player.moveLeft();
            }
            punishments = player.punishment(punishments);
        }
        if (check == 20) {
            check = 0;
            for (Enemy e : enemies) {
                e.chase(player);
            }
        }
        if (player.check()) {
            int total_score = player.getScore() + timer.getScore();
            frame.dispose();
            gameThread = null;
            success.firstPage(total_score);
        }
        ;
        if (player.caught(enemies) || player.getScore() < 0) {
            frame.dispose();
            gameThread = null;
            fail.firstPage();
        }
        rewards = player.pickReward(rewards);
    }

    /**
     * It paints all the collectibles and the game objects of the game to be seen on the map.
     *
     * @param g built-in Graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        level.clearQueue();

        for (GameObject[] y : level.gameObjects) {
            for (GameObject x : y) {
                level.queue(x);
            }
        }
        for (GameObject obj : level.queue) {
            g.drawImage(obj.getTexture().getTexture(), (int) obj.position.getX() * tileSize, (int) obj.position.getY() * tileSize, tileSize, tileSize, null);
        }
        g.drawImage(player.getTexture().getTexture(), (int) player.getLocation().getX() * tileSize, (int) player.getLocation().getY() * tileSize, tileSize, tileSize, null);
        for (Enemy e : enemies) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        for (Reward e : rewards) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        for (PunishmentRoadBlock e : punishments) {
            g.drawImage(e.getTexture().getTexture(), (int) e.getLocation().getX() * tileSize, (int) e.getLocation().getY() * tileSize, tileSize, tileSize, null);
        }

        level.clearQueue();
        g2.dispose();
    }

}
