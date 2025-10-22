package com.dak.controllers;

import com.dak.models.QuizModel;
import com.dak.views.NewReleaseItemView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public record NewReleaseItemController(QuizModel model, NewReleaseItemView view) {
    public NewReleaseItemController(QuizModel model, @NotNull NewReleaseItemView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(createPlayButtonActionListener());
    }

    private @NotNull ActionListener createPlayButtonActionListener() {
        return (e) -> System.out.println(model.getId());
    }
}
