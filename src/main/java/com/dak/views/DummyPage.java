package com.dak.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.dak.Main;
import com.dak.views.components.SectionHeader;

public class DummyPage extends AppPage {
    private String message;

    public DummyPage(String message) {
        this.message = message;
        this.setLayout(new FlowLayout());

        this.add(new SectionHeader(message));

        JButton button = new JButton("Back to home");
        button.addActionListener(e -> {
            Main.switchPage(new HomePage());
        });

        this.add(button);
    }

    @Override
    public AppPage cloneState() {
        return new DummyPage(message);
    }
}
