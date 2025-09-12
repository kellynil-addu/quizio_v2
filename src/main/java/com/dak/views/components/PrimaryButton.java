package com.dak.views.components;

import com.dak.views.utils.AppTheme;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrimaryButton extends JButton {
    public PrimaryButton(String text) {
        super(text);
        // setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XL, SizeSet.XS, SizeSet.XL));
        setOpaque(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(AppTheme.getPrimaryButton());
        setForeground(AppTheme.getSecondaryForeground());
        setMargin(new Insets(SizeSet.XS, SizeSet.XL, SizeSet.XS, SizeSet.XL));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Color.decode("#42A8FC"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(AppTheme.getPrimaryButton());
            }
        });
    }
}
