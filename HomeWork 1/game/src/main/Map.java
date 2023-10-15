package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight = 100;
    private int cellWidth = 100;


    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }

        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        repaint();
    }

//    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {

        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / SettingsWindow.fieldSizeX;
        cellWidth = panelWidth / SettingsWindow.fieldSizeY;

        g.setColor(Color.BLACK);
        for (int h = 0; h < SettingsWindow.fieldSizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int w = 0; w < SettingsWindow.fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        repaint();

    }


    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);
        repaint();
    }
}

