package com.dak.views.components;

import javax.swing.*;

public class TrueOrFalsePanel extends JPanel {
    public TrueOrFalsePanel() {
        JRadioButton trueOption = new JRadioButton("True");
        JRadioButton falseOption = new JRadioButton("False");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(trueOption);
        buttonGroup.add(falseOption);

        JPanel mainPanel = new JPanel();
        mainPanel.add(trueOption);
        mainPanel.add(falseOption);

        add(new QuestionLayout(mainPanel));
    }
}
