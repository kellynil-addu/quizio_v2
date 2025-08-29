package com.dak.views;

import java.awt.*;

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
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, SizeSet._3XS,0 ));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, SizeSet.XL, 0));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportView(buttonPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("angular.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("cpp.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("csharp.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("css.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("docker.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("git.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("github.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("golang.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("html.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("java.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("js.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("nodejs.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("php.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("python.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("react.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("ruby.svg")));
        buttonPanel.add(addCategoryButton(ImageSet.getIconFromSVG("vue.svg")));
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
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
}
