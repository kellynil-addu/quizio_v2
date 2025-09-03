package com.dak.views.components;

import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;

public class QuestionLayout extends JPanel {
    public QuestionLayout(JComponent centerComponent) {
        setLayout(new BorderLayout());

        JLabel pageLabel = new JLabel("1/10");
        pageLabel.setFont(pageLabel.getFont().deriveFont(Font.BOLD));
        pageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel("Lorem ipsum dolor sit amet consectetur adipiscing elit?");
        textLabel.setFont(textLabel.getFont().deriveFont(Font.BOLD, SizeSet.M));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(pageLabel);
        topPanel.add(textLabel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new GhostButton("Previous Question"), BorderLayout.WEST);
        bottomPanel.add(new JButton("Next Question"), BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(centerComponent, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
