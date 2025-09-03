package com.dak.views.components;

import javax.swing.*;

public class OrderingPanel extends JPanel {
    public OrderingPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.add(new OrderingOptionPanel("Option 1"));

        add(new QuestionLayout(mainPanel));
    }
}