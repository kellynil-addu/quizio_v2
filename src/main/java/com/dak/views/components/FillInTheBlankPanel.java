package com.dak.views.components;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

import javax.swing.*;
import java.awt.*;

public class FillInTheBlankPanel extends JPanel {
    public FillInTheBlankPanel() {
        setOpaque(false);

        JTextField inputField = new JTextField();
        inputField.setBackground(ColorSet.getSecondaryBackground());
        inputField.setBorder(BorderFactory.createEmptyBorder(SizeSet._3XS, SizeSet._3XS, SizeSet._3XS, SizeSet._3XS));
        inputField.setEditable(true);
        inputField.setEnabled(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(inputField, gbc);

        add(new QuestionPage(mainPanel));
    }
}
