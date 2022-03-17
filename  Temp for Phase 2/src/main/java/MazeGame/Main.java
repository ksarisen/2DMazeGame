package main.java.MazeGame;
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setTitle("name_to_be_decided");

        GamePanel gamepanel = new GamePanel();
        win.add(gamepanel);
        win.pack();


        win.setLocationRelativeTo(null);
        win.setVisible(true);

        gamepanel.startGameThread();
    }
}
