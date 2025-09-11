package com.dak.views.components;

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
        setOpaque(false);
        setLayout(new BorderLayout());

        SectionHeader header = new SectionHeader("New Release");

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();

        Insets withoutTop = new Insets(0, SizeSet._5XS, SizeSet._5XS, SizeSet._5XS);
        Insets withTop = new Insets(SizeSet._5XS, SizeSet._5XS, SizeSet._5XS, SizeSet._5XS);

        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                gbc.insets = withoutTop;
            } else {
                gbc.insets = withTop;
            }

            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            mainPanel.add(new NewReleaseCard(titles[i], "Quizio"), gbc);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(mainPanel, BorderLayout.NORTH);

        add(header, BorderLayout.NORTH);
        add(centerPanel);
    }
}
