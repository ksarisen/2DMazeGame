package main;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // screen setting
    final int originaltilesize = 16;// 16 by 16 tiles
    final int scale = 3;
    final int tilesize = originaltilesize *scale;
    final int maxscreencol = 16;
    final int maxscreenrow = 12;
    final int screenwidth = tilesize * maxscreencol;
    final int screenheight = tilesize * maxscreenrow;

    // we set the frame rate hear

    int fps = 30;

    keyhandler keyh = new keyhandler();
    Thread gameThread;

    // the default positions of the players.
    int playerx = 100;
    int playery = 100;
    int playerspeed = 10;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenwidth,screenheight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyh);
    this.setFocusable(true);
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
    public void update(){
        if(keyh.uppressed){
            playery -= playerspeed;
        }
        else if(keyh.downpressed){
            playery += playerspeed;
        }
        else if(keyh.rightpressed){
            playerx += playerspeed;
        }
        else if(keyh.leftpressed){
            playerx -= playerspeed;
        }
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerx,playery,tilesize,tilesize);
        g2.dispose();

    }

}
