package com.dak.views.components;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrimaryButton extends JButton {
    public PrimaryButton(String text) {
        super(text);
        setBorder(BorderFactory.createEmptyBorder(SizeSet._2XS, SizeSet.L, SizeSet._2XS, SizeSet.L));
        setOpaque(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(ColorSet.getPrimaryButton());
        setForeground(ColorSet.getSecondaryForeground());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Color.decode("#42A8FC"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(ColorSet.getPrimaryButton());
            }
        });
    }
}
