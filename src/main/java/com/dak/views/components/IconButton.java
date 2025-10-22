package com.dak.views.components;

import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class IconButton extends JButton {
    public IconButton(@NotNull ImageIcon icon) {
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(SizeSet._4XS, SizeSet._4XS, SizeSet._4XS, SizeSet._4XS));

        Image scaledImage = icon.getImage().getScaledInstance(SizeSet._4XL, SizeSet._4XL, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        setIcon(scaledIcon);
    }
}
