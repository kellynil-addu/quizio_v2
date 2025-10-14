package com.dak.views.components;

import com.dak.Main;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class QuestionPage extends JPanel {
    public QuestionPage(@NotNull JComponent questionPanel) {
        setOpaque(false);
        setLayout(new BorderLayout());

        questionPanel.setBorder(BorderFactory.createEmptyBorder(SizeSet.M, 0, SizeSet.M, 0));

        JLabel pageLabel = new JLabel("1/10");
        pageLabel.setFont(pageLabel.getFont().deriveFont(Font.BOLD));
        pageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLabel = new JLabel("Lorem ipsum dolor sit amet consectetur adipiscing elit?");
        textLabel.setForeground(ColorSet.getPrimaryForeground());
        textLabel.setFont(textLabel.getFont().deriveFont(Font.BOLD, SizeSet.M));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(pageLabel);
        topPanel.add(textLabel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        CardLayout cardLayout = (CardLayout) Main.cardPanel.getLayout();

        GhostButton ghostButton = new GhostButton("Previous Question");
        ghostButton.addActionListener(e -> cardLayout.previous(Main.cardPanel));

        PrimaryButton primaryButton = new PrimaryButton("Next Question");
        primaryButton.addActionListener(e -> cardLayout.next(Main.cardPanel));

        bottomPanel.add(ghostButton, BorderLayout.WEST);
        bottomPanel.add(primaryButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(questionPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
