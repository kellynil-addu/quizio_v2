package com.dak.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dak.views.components.SectionHeader;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class CategorySection extends JPanel {
    public CategorySection() {
        this.setLayout(new BorderLayout());

        // Initialize components
        SectionHeader header = new SectionHeader("Categories");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // This puts enough space at the bottom where the scrollbar will be
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, SizeSet.XL, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setViewportView(buttonPanel);
        scrollPane.getVerticalScrollBar();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        
        // Load some example buttons
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(addCategoryButton());
        }
    }

    private JButton addCategoryButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(64, 64));
        button.setMaximumSize(new Dimension(64, 64));
        button.setBackground(ColorSet.SECONDARY_BACKGROUND);
        return button;
    }
}
