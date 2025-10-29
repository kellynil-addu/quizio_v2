package com.dak.views;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.QuestionPageViewModel;
import com.dak.views.viewModels.QuestionViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class QuestionPageView extends JPanel {
    private final QuestionPageViewModel questionPageViewModel;
    private final QuestionViewModel[] questionViewModels;

    private final float textFontSize = (float) SizeSet.M;

    public QuestionPageView(@NotNull QuestionPageViewModel questionPageViewModel, @NotNull QuestionViewModel @NotNull [] questionViewModels) {
        this.questionViewModels = questionViewModels;
        this.questionPageViewModel = questionPageViewModel;

        setOpaque(false);
        setLayout(new GridBagLayout());

        JPanel cardPanel = new JPanel();
        cardPanel.setOpaque(false);
        cardPanel.setLayout(new CardLayout());

        for (int i = 0; i < questionViewModels.length; i++) {
            cardPanel.add(createQuestion(questionViewModels[i]), String.valueOf(i + 1));
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        mainPanel.add(questionPageViewModel.quizNavigationView(), BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(mainPanel, gbc);
    }

    private @NotNull JPanel createQuestion(@NotNull QuestionViewModel questionViewModel) {
        // App currently uses system font only.
        Font systemFont = UIManager.getFont("Label.font");
        FontMetrics metrics = getFontMetrics(systemFont.deriveFont(textFontSize));

        int minTextLength = 40;
        int maxTextLength = 80;
        int minWidth = 300;
        int maxWidth = 500;
        int width;

        int textLength = questionViewModel.text().length();

        if (textLength < minTextLength) {
            width = minWidth;
        } else if (textLength < maxTextLength) {
            width = metrics.stringWidth(questionViewModel.text());
        } else {
            width = maxWidth;
        }

        questionViewModel.questionInputView().setBorder(BorderFactory.createEmptyBorder(SizeSet.M, 0, SizeSet.M, 0));

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(createPage());
        topPanel.add(Box.createVerticalStrut(SizeSet._3XS));
        topPanel.add(createQuestion(questionViewModel.text()));

        JPanel questionPanel = new JPanel();
        questionPanel.setOpaque(false);
        questionPanel.setLayout(new BorderLayout());
        questionPanel.add(topPanel, BorderLayout.NORTH);
        questionPanel.add(questionViewModel.questionInputView(), BorderLayout.CENTER);
        questionPanel.setMaximumSize(new Dimension(width, questionPanel.getPreferredSize().height));

        return questionPanel;
    }

    private @NotNull JLabel createPage() {
        JLabel label = new JLabel("1/10", JLabel.CENTER);
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));

        return label;
    }

    private @NotNull JLabel createQuestion(String text) {
        String wrappedText = String.format(
            "<html><body style='width: 100%%; text-align: center'>%s</body></html>",
            text
        );

        JLabel label = new JLabel(wrappedText, JLabel.CENTER);
        label.setForeground(ColorSet.getPrimaryForeground());
        label.setFont(label.getFont().deriveFont(Font.BOLD, textFontSize));

        return label;
    }
}
