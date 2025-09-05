package com.dak.views.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class OrderingOptionPanel extends JPanel {
    private Boolean showComponent = true;
    JFrame ghostFrame;

    public OrderingOptionPanel(String text) {
        setLayout(new FlowLayout());
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(new JLabel(text));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showComponent = false;
                setOpaque(false);
                repaint();

                ghostFrame = new JFrame();

                try {
                    ghostFrame.add((JPanel) clone());
                } catch (CloneNotSupportedException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showComponent = true;
                setOpaque(true);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!showComponent) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
    }
}