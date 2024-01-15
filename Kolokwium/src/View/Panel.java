package View;

import Model.Direction;
import Model.RectCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import static java.awt.Color.red;

public class Panel extends JPanel{
    int xClick1, yClick1, xClick2, yClick2;
    public ArrayList<RectCoordinate> rectCoordinates = new ArrayList<>();
    int pomocnicza = 0;
    Graphics2D buffer;
    private BufferedImage bufferedImage;
    boolean draw = false;
    Direction direction = Direction.DOWN;
    public Panel () {
    createPanel();
        setLayout(null);
        setSize(1000, 800);
        setBackground(Color.WHITE);
        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        buffer = bufferedImage.createGraphics();
        addListener();
    }

    public void createPanel() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.black);
        draw(g2d);

    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.black);

        for (RectCoordinate rectCoordinate : rectCoordinates) {
            g2d.drawRect(rectCoordinate.x1, rectCoordinate.y1, rectCoordinate.x2 - rectCoordinate.x1, rectCoordinate.y2 - rectCoordinate.y1);
        }
    }

    public void addListener() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(pomocnicza);
                if (pomocnicza == 0) {
                    xClick1 = e.getX();
                    yClick1 = e.getY();
                    pomocnicza++;
                    draw = false;
                } else {
                    xClick2 = e.getX();
                    yClick2 = e.getY();
                    pomocnicza = 0;
                    draw = true;
                    if (xClick1 > xClick2) {
                        int swap = xClick1;
                        xClick1 = xClick2;
                        xClick2 = swap;
                    }
                    if (yClick1 > yClick2) {
                        int swap = yClick1;
                        yClick1 = yClick2;
                        yClick2 = swap;
                    }
                    RectCoordinate newRect = new RectCoordinate(xClick1, yClick1, xClick2, yClick2, Direction.DOWN);
                    newRect.start();
                    rectCoordinates.add(newRect);


                    //rectCoordinates.add(new RectCoordinate(xClick1,yClick1,xClick2,yClick2));
                }
            }
        });
    }

}
