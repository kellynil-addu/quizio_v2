package com.dak.views.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderingOptionPanel extends JPanel {
    private Point initialClick;

    public OrderingOptionPanel(String text) {
        setLayout(new FlowLayout());
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(new JLabel(text));

        // Make it draggable
        MouseAdapter dragListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Get current location of the panel
                int x = getLocation().x;
                int y = getLocation().y;

                // Determine how much the mouse moved
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Move panel to new location
                int newX = x + xMoved;
                int newY = y + yMoved;

                setLocation(newX, newY);
            }
        };

        addMouseListener(dragListener);
        addMouseMotionListener(dragListener);
    }
}