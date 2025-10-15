package com.dak.views.components;

import com.dak.Main;
import com.dak.models.QuestionModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class QuizPage extends JPanel {
    public final JPanel cardPanel = new JPanel(new CardLayout());
    private final CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

    public JLabel pageLabel = new JLabel();
    public int currentPage = -1;
    public int maxPage = -1;

    public QuizPage() {
        setOpaque(false);
        setLayout(new BorderLayout());

        pageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        cardPanel.setOpaque(false);

        add(pageLabel, BorderLayout.NORTH);
        add(cardPanel);
    }

    public void addQuestions(QuestionModel @NotNull [] questions) {
        currentPage = 1;
        maxPage = questions.length;

        for (int i = 0; i < questions.length; i++) {
            QuestionModel.TYPE type = questions[i].getType();

            // Create a base interface for all question panels.
            JPanel questionPanel = null;

            switch (type) {
                case QuestionModel.TYPE.FILL_IN_THE_BLANK -> {
                    questionPanel = new FillInTheBlankPanel();
                }

                case QuestionModel.TYPE.MULTI_SELECT -> {
                    questionPanel = new MultiSelectPanel();
                }

                case QuestionModel.TYPE.MULTIPLE_CHOICE -> {
                    questionPanel = new MultipleChoicePanel();
                }

                case QuestionModel.TYPE.TRUE_OR_FALSE -> {
                    questionPanel = new TrueOrFalsePanel();
                }

                default -> {
                    throw new IllegalArgumentException("Unknown question model type: " + type);
                }
            }

            cardPanel.add(questionPanel, String.valueOf(i));
        }
    }

    public void updatePageLabel() {
        Main.quizPage.pageLabel.setText(String.format("%d/%d", currentPage, maxPage));
    }

    public void clearQuestions() {
        currentPage = -1;
        maxPage = 0;

        cardPanel.removeAll();
        cardPanel.revalidate();
        cardPanel.repaint();
    }

    public void nextPage() {
        if (currentPage < maxPage) {
            currentPage++;
            cardLayout.next(cardPanel);
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            cardLayout.previous(cardPanel);
        }
    }
}
