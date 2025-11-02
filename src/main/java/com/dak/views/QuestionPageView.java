package com.dak.views;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.QuestionPageViewModel;
import com.dak.views.viewModels.QuestionViewModel;

import net.miginfocom.swing.MigLayout;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.util.ArrayList;

public class QuestionPageView extends JPanel {
    private final QuestionPageViewModel questionPageViewModel;
    private final QuestionViewModel[] questionViewModels;

    private final JPanel cardPanel;
    
    private final ArrayList<JPanel> questionPages;

    private final float textFontSize = (float) SizeSet.M;

    public QuestionPageView(@NotNull QuestionPageViewModel questionPageViewModel, @NotNull QuestionViewModel @NotNull [] questionViewModels) {
        this.questionViewModels = questionViewModels;
        this.questionPageViewModel = questionPageViewModel;
        this.questionPages = new ArrayList<>();

        cardPanel = createCard();

        setOpaque(false);
        setLayout(new GridBagLayout());

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

        showPage(0);
    }

    public void showPage(int page) {
        cardPanel.removeAll();
        cardPanel.add(questionPages.get(page));

        this.revalidate();
        this.repaint();
    }

    private @NotNull JPanel createCard() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        for (int i = 0; i < questionViewModels.length; i++) {
            String page = String.valueOf(i + 1);

            JLabel pageLabel = createPageLabel();
            pageLabel.setText(page + "/" + questionPageViewModel.state().maxPage);

            questionPages.add(createQuestion(questionViewModels[i], pageLabel));
        }

        return panel;
    }

    private @NotNull JPanel createQuestion(@NotNull QuestionViewModel questionViewModel, JLabel pageLabel) {
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
        topPanel.add(pageLabel);
        topPanel.add(Box.createVerticalStrut(SizeSet._3XS));
        topPanel.add(createQuestion(questionViewModel.text()));

        JPanel questionPanel = new JPanel();
        questionPanel.setOpaque(false);
        questionPanel.setLayout(new BorderLayout());
        questionPanel.add(topPanel, BorderLayout.NORTH);
        questionPanel.add(questionViewModel.questionInputView(), BorderLayout.CENTER);

        return questionPanel;
    }

    private @NotNull JLabel createPageLabel() {
        JLabel label = new JLabel("1/10", JLabel.CENTER);
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));

        return label;
    }

    private @NotNull JPanel createQuestion(String text) {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new MigLayout("insets 0, gap 0", "[shrink]", "[shrink]"));

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setText(text);
        textPane.setForeground(ColorSet.getPrimaryForeground());
        textPane.setFont(textPane.getFont().deriveFont(Font.BOLD, textFontSize));

        StyledDocument document = textPane.getStyledDocument();
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributes, StyleConstants.ALIGN_CENTER);
        document.setParagraphAttributes(0, document.getLength(), attributes, false);

        textPane.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        textPane.setMinimumSize(new Dimension(300, 0));

        // Force a recalculation of the dimensions of textPane
        textPane.setSize(new Dimension(500, Short.MAX_VALUE));

        wrapper.add(textPane);

        return wrapper;
    }
}
