package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View {
    Controller controller;
    JFrame frame = new JFrame("TicTacToe");

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void create() {
        frame.setSize(317, 380);
        frame.setIconImage(new ImageIcon("C:\\Users\\serge\\IdeaProjects\\TicTacToe\\src\\Images\\icon.jpg").getImage());
        frame.setUndecorated(false);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        drawGameField();
        frame.repaint();
    }

    public void drawGameField() {
        JComponent gamefield = new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.setColor(Color.BLACK);
                int h = 300;
                int w = 300;
                int dw = w / 3;
                int dh = h / 3;
                for (int i = 0; i < 4; i++) {
                    g.drawLine(0, dh * i, w, dh * i);
                    g.drawLine(dw * i, 0, dw * i, h);
                }
            }
        };
        gamefield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.handleKeyDown(e.getX(), e.getY());
            }
        });
        frame.add(gamefield);
        frame.revalidate();
        frame.repaint();
    }

    public void drawZero(int x, int y) {
        JComponent zero = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawOval(x, y, 100, 100);
            }
        };
        frame.add(zero);
        frame.revalidate();
        frame.repaint();
    }

    public void drawCross(int x, int y) {
        JComponent cross = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x + 100, y + 100);
                g.drawLine(x + 100, y, x, y + 100);
            }
        };
        frame.add(cross);
        frame.revalidate();
        frame.repaint();
    }

    public void drawWinText(String s) {
        JLabel winText = new JLabel(s);
        winText.setVerticalAlignment(3);
        frame.add(winText);
        frame.revalidate();
        frame.repaint();
    }

    public void drawWinLine(int x1, int y1, int x2, int y2) {
        JComponent winLine = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                ((Graphics2D)g).setStroke(new BasicStroke(5));
                g.drawLine(x1, y1, x2, y2);
            }
        };
        frame.add(winLine);
        frame.revalidate();
        frame.repaint();
    }
}
