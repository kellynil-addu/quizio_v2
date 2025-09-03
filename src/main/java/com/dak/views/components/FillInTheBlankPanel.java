package com.dak.views.components;

import javax.swing.*;
import java.awt.*;

public class FillInTheBlankPanel extends JPanel {
    public FillInTheBlankPanel() {
        JTextField inputField = new JTextField();
        inputField.setEditable(true);
        inputField.setEnabled(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(inputField, gbc);

        add(new QuestionLayout(mainPanel));
    }
}
