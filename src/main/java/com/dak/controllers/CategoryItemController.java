package com.dak.controllers;

import com.dak.models.CategoryModel;
import com.dak.views.CategoryItemView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public record CategoryItemController(CategoryModel model, CategoryItemView view) {
    public CategoryItemController(CategoryModel model, CategoryItemView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(createButtonActionListener());
    }

    private @NotNull ActionListener createButtonActionListener() {
        return (e) -> System.out.println(model.getId());
    }
}
