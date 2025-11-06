package com.dak.views;

import com.dak.views.components.UnderlineButton;

import javax.swing.*;
import java.awt.*;

public class QuizNavigationView extends JPanel {
    private final JButton previousButton;
    private final JButton nextButton;
    private final JButton finishButton;

    public QuizNavigationView() {
        setOpaque(false);
        setLayout(new BorderLayout());

        previousButton = new UnderlineButton("Previous Question");
        nextButton = new JButton("Next Question");
        finishButton = new JButton("Finish Quiz");

        add(previousButton, BorderLayout.WEST);
        add(nextButton, BorderLayout.EAST);
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public void displaySecondButton(JButton button) {
        remove(nextButton);
        remove(finishButton);
        add(button, BorderLayout.EAST);
    }
}
