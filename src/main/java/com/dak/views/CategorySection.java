package com.dak.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import com.dak.views.components.SectionHeader;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.ImageSet;
import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

public class CategorySection extends JPanel {
    private static final int BUTTON_WIDTH = 64;
    private static final int BUTTON_HEIGHT = 64;

    public CategorySection() {
        this.setLayout(new BorderLayout());

        SectionHeader header = new SectionHeader("Categories");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, SizeSet.XL, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportView(buttonPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        
        // Load some example buttons.
        for (int i = 0; i < 10; i++) {
            buttonPanel.add(addCategoryButton(ImageSet.getCssLogo()));
        }
    }

    private @NotNull JButton addCategoryButton(ImageIcon icon) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setOpaque(true);
        button.setBackground(ColorSet.SECONDARY_BACKGROUND);
        button.setIcon(icon);
        button.setBorder(null);
        button.setFocusPainted(false);
        return button;
    }
}
