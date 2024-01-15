package View;

import Model.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void addButtons() {
        JPanel buttonPanel = new JPanel();
        JButton lewo = new JButton("LEFT");
        JButton prawo = new JButton("RIGTH");
        JButton gora = new JButton("UP");
        JButton dol = new JButton("DOWN");
        buttonPanel.add(lewo);
        buttonPanel.add(prawo);
        buttonPanel.add(gora);
        buttonPanel.add(dol);
        lewo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.direction=Direction.LEFT;
                for(int i=0;i<panel.rectCoordinates.size();i++){
                    panel.rectCoordinates.get(i).setDirection(Direction.LEFT);
                }
            }
        });
        prawo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.direction = Direction.RIGHT;
                for(int i=0;i<panel.rectCoordinates.size();i++){
                    panel.rectCoordinates.get(i).setDirection(Direction.RIGHT);
                }
            }
        });
        gora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.direction=Direction.UP;
                for(int i=0;i<panel.rectCoordinates.size();i++){
                    panel.rectCoordinates.get(i).setDirection(Direction.UP);
                }
            }
        });
        dol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.direction=Direction.DOWN;
                for(int i=0;i<panel.rectCoordinates.size();i++){
                    panel.rectCoordinates.get(i).setDirection(Direction.DOWN);
                }
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
    }

public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }});
    }
}
