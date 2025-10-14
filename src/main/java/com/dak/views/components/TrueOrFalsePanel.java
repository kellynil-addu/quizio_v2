package com.dak.views.components;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.EmptyIcon;
import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class TrueOrFalsePanel extends JPanel {
    private static final ButtonGroup buttonGroup = new ButtonGroup();

    public TrueOrFalsePanel() {
        setOpaque(false);

        JPanel trueOption = createOption("True");
        JPanel falseOption = createOption("False");

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, SizeSet._3XS, 0));
        mainPanel.setOpaque(false);
        mainPanel.add(trueOption);
        mainPanel.add(falseOption);

        add(new QuestionPage(mainPanel));
    }

    private @NotNull JPanel createOption(String text) {
        JRadioButton option = new JRadioButton(text);
        option.setOpaque(false);
        option.setIcon(new EmptyIcon());
        option.setSelectedIcon(new EmptyIcon());
        option.setHorizontalAlignment(SwingConstants.CENTER);
        option.setBorder(BorderFactory.createEmptyBorder(SizeSet._3XS, SizeSet._3XS, SizeSet._3XS, SizeSet._3XS));

        buttonGroup.add(option);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(option);

        option.addChangeListener(e -> {
            if (option.isSelected()) {
                panel.setBorder(BorderFactory.createLineBorder(ColorSet.getSelectedOptionAccent()));
                panel.setBackground(ColorSet.getSelectedOptionBackground());
            } else {
                panel.setBorder(null);
                panel.setBackground(ColorSet.getSecondaryBackground());
            }
        });

        return panel;
    }
}
