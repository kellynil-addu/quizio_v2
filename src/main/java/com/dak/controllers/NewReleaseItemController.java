package com.dak.controllers;

import com.dak.models.QuizModel;
import com.dak.views.NewReleaseItemView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public class NewReleaseItemController {
    private final QuizModel model;
    private final NewReleaseItemView view;

    public NewReleaseItemController(QuizModel model, @NotNull NewReleaseItemView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(createPlayButtonActionListener());
    }

    public QuizModel getModel() {
        return model;
    }

    public NewReleaseItemView getView() {
        return view;
    }

    private @NotNull ActionListener createPlayButtonActionListener() {
        return (e) -> System.out.println(model.getId());
    }
}