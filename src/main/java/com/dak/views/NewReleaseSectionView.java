package com.dak.views;

import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.NewReleaseSectionViewModel;
import com.dak.views.viewModels.SectionHeaderViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class NewReleaseSectionView extends JPanel {
    private final SectionHeaderViewModel sectionHeaderViewModel;
    private final NewReleaseSectionViewModel newReleaseSectionViewModel;

    public NewReleaseSectionView(SectionHeaderViewModel sectionHeaderViewModel, NewReleaseSectionViewModel newReleaseSectionViewModel) {
        this.sectionHeaderViewModel = sectionHeaderViewModel;
        this.newReleaseSectionViewModel = newReleaseSectionViewModel;

        setOpaque(false);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createGrid(), BorderLayout.CENTER);
    }

    private @NotNull SectionHeaderView createHeader() {
        return new SectionHeaderView(sectionHeaderViewModel);
    }

    private @NotNull JPanel createGrid() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < newReleaseSectionViewModel.newReleaseCardViews().length; i++) {
            int top = (i == 0 || i == 1) ? 0 : SizeSet._5XS;
            int left = (i % 2 == 0) ? 0 : SizeSet._5XS;
            gbc.insets = new Insets(top, left, SizeSet._5XS, SizeSet._5XS);

            gbc.gridx = i % 2;
            gbc.gridy = i / 2;

            panel.add(newReleaseSectionViewModel.newReleaseCardViews()[i], gbc);
        }

        return panel;
    }
}
