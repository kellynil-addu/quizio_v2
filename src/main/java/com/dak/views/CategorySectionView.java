package com.dak.views;

import com.dak.views.utils.SizeSet;
import com.dak.views.viewModels.CategorySectionViewModel;
import com.dak.views.viewModels.SectionHeaderViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class CategorySectionView extends JPanel {
    private final SectionHeaderViewModel sectionHeaderViewModel;
    private final CategorySectionViewModel categorySectionViewModel;

    public CategorySectionView(@NotNull SectionHeaderViewModel sectionHeaderViewModel, @NotNull CategorySectionViewModel categorySectionViewModel) {
        this.sectionHeaderViewModel = sectionHeaderViewModel;
        this.categorySectionViewModel = categorySectionViewModel;

        setOpaque(false);
        setLayout(new BorderLayout());

        JPanel itemPanel = createItem();

        for (int i = 0; i < categorySectionViewModel.categoryItemViews().length; i++) {
            CategoryItemView categoryItemView = categorySectionViewModel.categoryItemViews()[i];

            if (i != 0) {
                itemPanel.add(Box.createHorizontalStrut(SizeSet._3XS));
            }

            itemPanel.add(categoryItemView);
        }

        JScrollPane scrollPane = createScrollPane();
        scrollPane.setViewportView(itemPanel);

        add(createHeader(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private @NotNull SectionHeaderView createHeader() {
        return new SectionHeaderView(sectionHeaderViewModel);
    }

    private @NotNull JPanel createItem() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0 ));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, SizeSet.XL, 0));

        return panel;
    }

    private @NotNull JScrollPane createScrollPane() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        return scrollPane;
    }
}
