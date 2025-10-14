package com.dak.views.components;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GhostButton extends JButton {
    public GhostButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(SizeSet._2XS, SizeSet.L, SizeSet._2XS, SizeSet.L));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setOpaque(true);
                setBackground(ColorSet.getGhostButtonHover());
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(false);
                super.mouseExited(e);
            }
        });
    }
}
