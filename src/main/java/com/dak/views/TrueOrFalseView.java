package com.dak.views;

import com.dak.bases.BaseQuestionView;
import com.dak.models.OptionModel;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.EmptyIcon;
import com.dak.views.utils.SizeSet;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class TrueOrFalseView extends BaseQuestionView {
    private final ButtonGroup buttonGroup = new ButtonGroup();

    private final JRadioButton trueButton;
    private final JRadioButton falseButton;

    public TrueOrFalseView() {
        setOpaque(false);
        setLayout(new BorderLayout());

        trueButton = createButton("True");
        falseButton = createButton("False");

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, SizeSet._3XS, 0));
        mainPanel.setOpaque(false);
        mainPanel.add(wrapButton(trueButton));
        mainPanel.add(wrapButton(falseButton));

        add(mainPanel, BorderLayout.CENTER);
    }

    public JRadioButton getTrueButton() {
        return trueButton;
    }

    public JRadioButton getFalseButton() {
        return falseButton;
    }

    private @NotNull JRadioButton createButton(String text) {
        JRadioButton option = new JRadioButton(text);
        option.setOpaque(false);
        option.setFocusPainted(false);
        option.setIcon(new EmptyIcon());
        option.setSelectedIcon(new EmptyIcon());
        option.setHorizontalAlignment(SwingConstants.CENTER);
        option.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        option.setBorder(BorderFactory.createEmptyBorder(SizeSet._3XS, SizeSet._3XS, SizeSet._3XS, SizeSet._3XS));

        buttonGroup.add(option);
        return option;
    }

    private @NotNull JPanel wrapButton(JRadioButton option) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(option, BorderLayout.CENTER);

        Border borderWhenDisabled = BorderFactory.createLineBorder(ColorSet.getPrimaryBorder());
        Border borderWhenEnabled = BorderFactory.createLineBorder(ColorSet.getSelectedOptionAccent());

        panel.setBorder(borderWhenDisabled);

        option.addItemListener(_ -> {
            if (option.isSelected()) {
                panel.setOpaque(true);
                panel.setBackground(ColorSet.getSelectedOptionBackground());
                panel.setBorder(borderWhenEnabled);
            } else {
                panel.setOpaque(false);
                panel.setBackground(ColorSet.getSecondaryBackground());
                panel.setBorder(borderWhenDisabled);
            }
        });

        return panel;
    }

    private void displayButtonResult(@NotNull JRadioButton button, boolean correct) {
        button.setOpaque(true);

        button.setBackground(correct
                ? ColorSet.getCorrectOptionBackground()
                : ColorSet.getIncorrectOptionBackground());

        ((JPanel) button.getParent()).setBorder(BorderFactory.createLineBorder(correct
                ? ColorSet.getCorrectOptionAccent()
                : ColorSet.getIncorrectOptionAccent()));
    }

    @Override
    public void disableInput() {
        disableButtonsInput(List.of(trueButton, falseButton));
    }

    @Override
    public void displayAnswerResult(@NotNull List<OptionModel> options, Map<OptionModel, Boolean> resultMap) {
        OptionModel correctOption = options
                .stream()
                .findFirst()
                .orElseThrow();

        JRadioButton target = correctOption.isCorrect() ? trueButton : falseButton;

        if (resultMap == null) {
            displayButtonResult(target, false);
            return;
        }

        Map.Entry<OptionModel, Boolean> entry = resultMap.entrySet().iterator().next();

        if (entry.getValue()) {
            displayButtonResult(target, true);
        } else {
            displayButtonResult(target, false);
            displayButtonResult(correctOption.isCorrect() ? falseButton : trueButton, true);
        }
    }
}