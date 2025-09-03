package com.dak.views.components;

import javax.swing.*;

public class MultiSelectPanel extends JPanel {
    public MultiSelectPanel() {
        JCheckBox optionOne = new JCheckBox("Option 1");
        JCheckBox optionTwo = new JCheckBox("Option 2");
        JCheckBox optionThree = new JCheckBox("Option 3");
        JCheckBox optionFour = new JCheckBox("Option 4");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(optionOne);
        mainPanel.add(optionTwo);
        mainPanel.add(optionThree);
        mainPanel.add(optionFour);

        add(new QuestionLayout(mainPanel));
    }
}
