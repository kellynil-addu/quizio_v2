package com.dak.views.components;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MultiSelectPanel extends JPanel {
    public MultiSelectPanel() {
        setOpaque(false);

        JPanel optionOne = createOption("Option 1");
        JPanel optionTwo = createOption("Option 2");
        JPanel optionThree = createOption("Option 3");
        JPanel optionFour = createOption("Option 4");

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(optionOne);
        mainPanel.add(Box.createVerticalStrut(SizeSet.M));
        mainPanel.add(optionTwo);
        mainPanel.add(Box.createVerticalStrut(SizeSet.M));
        mainPanel.add(optionThree);
        mainPanel.add(Box.createVerticalStrut(SizeSet.M));
        mainPanel.add(optionFour);

        add(new QuestionPage(mainPanel));
    }

    private @NotNull JPanel createOption(String text) {
        JCheckBox option = new JCheckBox(text);
        option.setOpaque(false);
        option.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        option.setBorder(BorderFactory.createEmptyBorder(SizeSet._3XS, SizeSet._3XS, SizeSet._3XS, SizeSet._3XS));

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createLineBorder(ColorSet.getPrimaryBorder()));
        panel.add(option);

        option.addChangeListener(e -> {
            if (option.isSelected()) {
                panel.setOpaque(true);
                panel.setBackground(ColorSet.getSelectedOptionBackground());
                panel.setBorder(BorderFactory.createLineBorder(ColorSet.getSelectedOptionAccent()));
            } else {
                panel.setOpaque(false);
                panel.setBorder(BorderFactory.createLineBorder(ColorSet.getPrimaryBorder()));
            }
        });

        return panel;
    }
}
