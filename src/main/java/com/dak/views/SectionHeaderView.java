package com.dak.views;

import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.SectionHeaderViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class SectionHeaderView extends JPanel {
    private final SectionHeaderViewModel viewModel;

    public SectionHeaderView(@NotNull SectionHeaderViewModel viewModel) {
        this.viewModel = viewModel;

        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(createTitle());
    }

    private @NotNull JLabel createTitle() {
        JLabel label = new JLabel(viewModel.title());
        label.setForeground(ColorSet.getPrimaryForeground());
        label.setFont(label.getFont().deriveFont(Font.BOLD, SizeSet.M));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, SizeSet._2XS, 0));

        return label;
    }
}
