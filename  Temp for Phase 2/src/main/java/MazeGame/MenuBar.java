package MazeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.*;


/**
 * 
 * @author Reece Landry
 *
 */

public class MenuBar extends JPanel {

	private JLabel label = new JLabel();
	
	JLabel timer = new JLabel("Timer");
	
	JLabel gasMeter = new JLabel("Gas: 2/10");
	
 	public MenuBar() {
 		
		this.setLayout(new BorderLayout());
		
		JPanel window = new JPanel();
		
		gasMeter.setForeground(Color.WHITE);
		gasMeter.setFont(new Font("Calibri", Font.BOLD, 30));
		gasMeter.setSize(200, 50);
		gasMeter.setPreferredSize(new Dimension(200,50));
		
		timer.setForeground(Color.WHITE);
		timer.setFont(new Font("Calibri", Font.BOLD, 30));
		timer.setSize(200, 50);
		timer.setPreferredSize(new Dimension(200,50));
		
		
		label = new JLabel("Cops And Robbers");
		label.setFont(new Font("Calibri", Font.BOLD, 30));
		label.setForeground(Color.WHITE);
		label.setPreferredSize(new Dimension(400,50));
		
		window.setOpaque(true);
		window.setBackground(Color.DARK_GRAY);
		
		window.add(gasMeter, BorderLayout.WEST);
		window.add(label, BorderLayout.EAST);
		window.add(timer, BorderLayout.EAST);
		
		this.add(window, BorderLayout.CENTER);
		
	}
 	
 	public void update(int score, String time) {
 		
 		gasMeter.setText("" + score);
 		timer.setText(time);
 		
 	}
	
	
}
