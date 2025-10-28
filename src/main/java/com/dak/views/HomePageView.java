package com.dak.views;

import com.dak.views.viewModels.HomePageViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class HomePageView extends JPanel {
    public HomePageView(@NotNull HomePageViewModel viewModel) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        CategorySectionView categorySectionView = viewModel.categorySectionView();
        categorySectionView.setMaximumSize(new Dimension(Integer.MAX_VALUE, categorySectionView.getPreferredSize().height));

        NewReleaseSectionView newReleaseSectionView = viewModel.newReleaseSectionView();
        newReleaseSectionView.setMaximumSize(new Dimension(Integer.MAX_VALUE, newReleaseSectionView.getPreferredSize().height));

        add(categorySectionView);
        add(newReleaseSectionView);
    }
}
