package com.dak.controllers;

import com.dak.models.CategoryModel;
import com.dak.views.CategoryItemView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public class CategoryItemController {
    private final CategoryModel model;
    private final CategoryItemView view;

    public CategoryItemController(CategoryModel model, @NotNull CategoryItemView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(createButtonActionListener());
    }

    public CategoryModel getModel() {
        return model;
    }

    public CategoryItemView getView() {
        return view;
    }

    private @NotNull ActionListener createButtonActionListener() {
        return (e) -> System.out.println(model.getId());
    }
}