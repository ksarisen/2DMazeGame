package MazeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SuccessMenu {
    static JFrame jf = new JFrame("Success Menu");

    public static void firtPage(int score) {

        jf.setPreferredSize(new Dimension(700, 700));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLayout(null);


        JLabel jb = new JLabel("Congratulations! ! ! Escape successfully", JLabel.CENTER);
        jb.setPreferredSize(new Dimension(680, 30));
        jf.add(jb);
        jb.setBounds(0, 200, 690, 30);
        jb.setFont(new Font("", Font.BOLD, 24));
        jb.setForeground(Color.decode("#375a7f"));
        JLabel jb1 = new JLabel("Your Score is: " + score, JLabel.CENTER);
        jb1.setPreferredSize(new Dimension(680, 30));
        jf.add(jb1);
        jb1.setBounds(0, 300, 690, 30);
        jb1.setFont(new Font("", Font.BOLD, 24));
        jb1.setForeground(Color.decode("#375a7f"));

        JButton jl1 = new JButton("EXIT");
        jl1.setPreferredSize(new Dimension(680, 30));
        jf.add(jl1);
        jl1.setBounds(0, 400, 690, 30);
        jl1.setFont(new Font("", Font.BOLD, 24));
        jl1.setForeground(Color.decode("#375a7f"));


        jl1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        jf.pack();
        jf.setVisible(true);
    }

    public static void closeThis() {
        jf.dispose();

    }
}