package MazeGame;

import javax.swing.*;
import java.awt.*;

/**
 * Sets the bars that is being showed on during the gameplay
 *
 * @author Reece Landry
 */

public class MenuBar extends JPanel {

    private JLabel timer = new JLabel("Timer");

    private JLabel gasMeter = new JLabel("Gas: 2/10");

    public JLabel getGasMeter() {
        return gasMeter;
    }

    public JLabel getTimer() {
        return timer;
    }

    /**
     * Settings to arrange how the screen looks.
     */
    public MenuBar() {

        this.setLayout(new BorderLayout());

        JPanel window = new JPanel();

        gasMeter.setForeground(Color.WHITE);
        gasMeter.setFont(new Font("Calibri", Font.BOLD, 30));
        gasMeter.setSize(200, 50);
        gasMeter.setPreferredSize(new Dimension(200, 50));

        timer.setForeground(Color.WHITE);
        timer.setFont(new Font("Calibri", Font.BOLD, 30));
        timer.setSize(200, 50);
        timer.setPreferredSize(new Dimension(200, 50));


        JLabel label = new JLabel("Cops And Robbers");
        label.setFont(new Font("Calibri", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(400, 50));

        window.setOpaque(true);
        window.setBackground(Color.DARK_GRAY);

        window.add(gasMeter, BorderLayout.WEST);
        window.add(label, BorderLayout.EAST);
        window.add(timer, BorderLayout.EAST);

        this.add(window, BorderLayout.CENTER);
    }

    /**
     * Updates the time for the user
     *
     * @param score user's score
     * @param time  the remaining time to finish the game
     */
    public void update(int score, String time) {

        gasMeter.setText("" + score);
        timer.setText(time);
    }
}
