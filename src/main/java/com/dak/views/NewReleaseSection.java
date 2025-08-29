package com.dak.views;

import com.dak.views.components.SectionHeader;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;

public class NewReleaseSection extends JPanel {
    // Temporary placeholder titles.
    private static final String[] titles = {
            "Backend Design and Architecture",
            "Full-Stack Web Development",
            "Machine Learning",
            "Data Structures and Algorithms"
    };

    public NewReleaseSection() {
        setLayout(new BorderLayout());

        SectionHeader header = new SectionHeader("New Release");

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(SizeSet._5XS, SizeSet._5XS, SizeSet._5XS, SizeSet._5XS);

        for (int i = 0; i < titles.length; i++) {
            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            mainPanel.add(new NewReleaseCard(titles[i], "Quizio"), gbc);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(mainPanel, BorderLayout.NORTH);

        add(header, BorderLayout.NORTH);
        add(centerPanel);
    }
}
