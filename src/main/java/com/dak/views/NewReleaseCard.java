package com.dak.views;

import com.dak.views.components.PrimaryButton;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;

public class NewReleaseCard extends JPanel {
    public NewReleaseCard(String title, String creator) {
        this.setBackground(ColorSet.SECONDARY_BACKGROUND);
        this.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));

        JLabel creatorLabel = new JLabel("By " + creator);
        creatorLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        creatorLabel.setFont(titleLabel.getFont().deriveFont(Font.PLAIN, SizeSet.S));

        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(titleLabel);
        leftPanel.add(creatorLabel);

        JButton button = new PrimaryButton("Play");

        add(leftPanel);
        add(button);
    }
}
