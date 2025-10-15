package com.dak.views.components;

import com.dak.Main;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class QuestionLayout extends JPanel {
    public QuestionLayout(@NotNull JComponent inputPanel) {
        setOpaque(false);
        setLayout(new BorderLayout());

        inputPanel.setBorder(BorderFactory.createEmptyBorder(SizeSet.M, 0, SizeSet.M, 0));

        Main.quizPage.updatePageLabel();

        JLabel textLabel = new JLabel("Lorem ipsum dolor sit amet consectetur adipiscing elit?");
        textLabel.setForeground(ColorSet.getPrimaryForeground());
        textLabel.setFont(textLabel.getFont().deriveFont(Font.BOLD, SizeSet.M));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(textLabel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        GhostButton ghostButton = new GhostButton("Previous Question");
        ghostButton.addActionListener(e -> {
            Main.quizPage.previousPage();
            Main.quizPage.updatePageLabel();
        });

        PrimaryButton primaryButton = new PrimaryButton("Next Question");
        primaryButton.addActionListener(e -> {
            Main.quizPage.nextPage();
            Main.quizPage.updatePageLabel();
        });

        bottomPanel.add(ghostButton, BorderLayout.WEST);
        bottomPanel.add(primaryButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
