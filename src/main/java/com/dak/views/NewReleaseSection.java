package com.dak.views;

import com.dak.views.components.SectionHeader;

import javax.swing.*;
import java.awt.*;

public class NewReleaseSection extends JPanel {
    public NewReleaseSection() {
        setLayout(new BorderLayout());

        SectionHeader header = new SectionHeader("New Release");

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(new NewReleaseCard("Backend Design and Architecture", "Quizio"));
        mainPanel.add(new NewReleaseCard("Full-Stack Web Develoment", "Quizio"));
        mainPanel.add(new NewReleaseCard("Machine Learning", "Quizio"));
        mainPanel.add(new NewReleaseCard("Data Structures and Algorithms", "Quizio"));

        add(header, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }
}
