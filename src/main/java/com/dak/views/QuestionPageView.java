package com.dak.views;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.QuestionPageViewModel;
import com.dak.views.viewModels.QuestionViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class QuestionPageView extends JPanel {
    private final QuestionViewModel questionViewModel;
    private final QuestionPageViewModel questionPageViewModel;

    private final float textFontSize = (float) SizeSet.M;

    public QuestionPageView(@NotNull QuestionViewModel questionViewModel, @NotNull QuestionPageViewModel questionPageViewModel) {
        this.questionViewModel = questionViewModel;
        this.questionPageViewModel = questionPageViewModel;

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        questionViewModel.questionInputView().setBorder(BorderFactory.createEmptyBorder(SizeSet.M, 0, SizeSet.M, 0));

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

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(createPage());
        topPanel.add(Box.createVerticalStrut(SizeSet._3XS));
        topPanel.add(createQuestion());

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(questionViewModel.questionInputView(), BorderLayout.CENTER);
        mainPanel.add(questionPageViewModel.quizNavigationView(), BorderLayout.SOUTH);
        mainPanel.setMaximumSize(new Dimension(width, mainPanel.getPreferredSize().height));

        add(Box.createVerticalGlue());
        add(mainPanel);
        add(Box.createVerticalGlue());
    }

    private @NotNull JLabel createPage() {
        JLabel label = new JLabel("1/10", JLabel.CENTER);
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));

        return label;
    }

    private @NotNull JLabel createQuestion() {
        String wrappedText = String.format(
            "<html><body style='width: 100%%; text-align: center'>%s</body></html>",
            questionViewModel.text()
        );

        JLabel label = new JLabel(wrappedText, JLabel.CENTER);
        label.setForeground(ColorSet.getPrimaryForeground());
        label.setFont(label.getFont().deriveFont(Font.BOLD, textFontSize));

        return label;
    }
}
