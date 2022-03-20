package MazeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu {
    static JFrame jf = new JFrame("Start Menu");
    public static void firtPage() {

        jf.setPreferredSize(new Dimension(700, 700));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.DARK_GRAY);

        jf.setLayout(null);
        JButton jl = new JButton("START");
        jl.setPreferredSize(new Dimension(400, 100));
        jf.add(jl);
        jl.setBounds(150, 200, 400, 100);
        jl.setFont(new Font("", Font.BOLD, 24));
        jl.setForeground(Color.decode("#375a7f"));
        

        JButton jl1 = new JButton("EXIT");
        jl1.setPreferredSize(new Dimension(400, 100));
        jf.add(jl1);
        jl1.setBounds(150, 400, 400, 100);
        jl1.setFont(new Font("", Font.BOLD, 24));
        jl1.setForeground(Color.decode("#375a7f"));
        
        

        jl.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame win = new JFrame();
                win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                win.setResizable(false);
                win.setTitle("name_to_be_decidedd");
                closeThis();

                GamePanel gamepanel = new GamePanel(win);
                win.add(gamepanel);
                win.pack();

                win.setLocationRelativeTo(null);
                win.setVisible(true);

                gamepanel.startGameThread();
            }
        });

        jl1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                closeThis();
            }
        });

        jf.pack();
        jf.setVisible(true);
    }
    public static void closeThis() {
        jf.dispose();

    }}
