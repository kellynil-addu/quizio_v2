package com.dak.views.components;

import com.dak.views.utils.EmptyIcon;

import javax.swing.*;
import java.awt.*;

public class MultipleChoicePanel extends JPanel {
    public MultipleChoicePanel() {
        ButtonGroup optionGroup = new ButtonGroup();

        JPanel optionOne = createOption("Option 1", optionGroup);
        JPanel optionTwo = createOption("Option 2", optionGroup);
        JPanel optionThree = createOption("Option 3", optionGroup);
        JPanel optionFour = createOption("Option 4", optionGroup);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(optionOne);
        mainPanel.add(optionTwo);
        mainPanel.add(optionThree);
        mainPanel.add(optionFour);

        add(new QuestionLayout(mainPanel));
    }

    private JPanel createOption(String text, ButtonGroup buttonGroup) {
        JRadioButton option = new JRadioButton(text);
        option.setIcon(new EmptyIcon());

        buttonGroup.add(option);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(option, BorderLayout.CENTER);

        return panel;
    }
}
