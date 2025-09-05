package com.dak.views.components;

import javax.swing.*;

public class OrderingPanel extends JPanel {
    public OrderingPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new OrderingOptionPanel("Option 1"));
//        mainPanel.add(new OrderingOptionPanel("Option 2"));
//        mainPanel.add(new OrderingOptionPanel("Option 3"));
//        mainPanel.add(new OrderingOptionPanel("Option 4"));

        add(new QuestionLayout(mainPanel));
    }
}