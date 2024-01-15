package View;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Panel panel = new Panel();
    JButton up = new JButton("UP"), down = new JButton("DOWN"), left = new JButton("LEFT"), right = new JButton("RIGHT");


    public Frame() {
        super("Kolokwium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        add(panel);

        Timer timer = new Timer(10, e -> {
            repaint();
        });
        timer.start();
        addButtons();
    }

    public void addButtons(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(up);
        buttonPanel.add(down);
        buttonPanel.add(left);
        buttonPanel.add(right);
        add(buttonPanel,BorderLayout.SOUTH);
    }

public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }});
    }
}
