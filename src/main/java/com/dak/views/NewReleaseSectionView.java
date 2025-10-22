package com.dak.views;

import com.dak.views.utils.SizeSet;
import com.dak.views.vms.NewReleaseSectionViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class NewReleaseSectionView extends JPanel {
    private final NewReleaseSectionViewModel viewModel;

    public NewReleaseSectionView(NewReleaseSectionViewModel viewModel) {
        this.viewModel = viewModel;

        setOpaque(false);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createGrid(), BorderLayout.CENTER);
    }

    private @NotNull SectionHeaderView createHeader() {
        return new SectionHeaderView(viewModel.sectionHeaderViewModel());
    }

    private @NotNull JPanel createGrid() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < viewModel.newReleaseCardViews().length; i++) {
            int top = (i == 0 || i == 1) ? 0 : SizeSet._5XS;
            int left = (i % 2 == 0) ? 0 : SizeSet._5XS;
            gbc.insets = new Insets(top, left, SizeSet._5XS, SizeSet._5XS);

            gbc.gridx = i % 2;
            gbc.gridy = i / 2;

            panel.add(viewModel.newReleaseCardViews()[i], gbc);
        }

        return panel;
    }
}
