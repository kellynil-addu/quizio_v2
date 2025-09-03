package com.dak.views.components;

import com.dak.views.utils.EmptyIcon;

import javax.swing.*;
import java.awt.*;

public class MultipleChoicePanel extends JPanel {
    public MultipleChoicePanel() {
        JRadioButton optionOne = new JRadioButton("Option 1");
        JRadioButton optionTwo = new JRadioButton("Option 2");
        JRadioButton optionThree = new JRadioButton("Option 3");
        JRadioButton optionFour = new JRadioButton("Option 4");

        ButtonGroup optionGroup = new ButtonGroup();
        optionGroup.add(optionOne);
        optionGroup.add(optionTwo);
        optionGroup.add(optionThree);
        optionGroup.add(optionFour);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(optionOne);
        mainPanel.add(optionTwo);
        mainPanel.add(optionThree);
        mainPanel.add(optionFour);

        add(new QuestionLayout(mainPanel));
    }
}
