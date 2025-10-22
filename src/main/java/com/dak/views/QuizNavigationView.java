package com.dak.views;

import com.dak.views.components.UnderlineButton;

import javax.swing.*;
import java.awt.*;

public class QuizNavigationView extends JPanel {
    private final JButton previousButton;
    private final JButton nextButton;

    public QuizNavigationView() {
        setOpaque(false);
        setLayout(new BorderLayout());

        previousButton = new UnderlineButton("Previous Question");
        nextButton = new JButton("Next Question");

        add(previousButton, BorderLayout.WEST);
        add(nextButton, BorderLayout.EAST);
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }
}
