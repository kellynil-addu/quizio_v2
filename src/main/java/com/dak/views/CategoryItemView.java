package com.dak.views;

import com.dak.views.components.IconButton;
import com.dak.views.utils.ColorSet;
import com.dak.views.viewModels.CategoryItemViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class CategoryItemView extends JPanel {
    private final IconButton button;

    public CategoryItemView(@NotNull CategoryItemViewModel viewModel) {
        setBackground(ColorSet.getSecondaryBackground());
        setLayout(new BorderLayout());

        button = new IconButton(viewModel.icon());

        add(button, BorderLayout.CENTER);
    }

    public IconButton getButton() {
        return button;
    }
}
