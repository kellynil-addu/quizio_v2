package com.dak.controllers;

import com.dak.models.QuestionModel;
import com.dak.views.TrueOrFalseView;

public class TrueOrFalseController {
    private final QuestionModel model;
    private final TrueOrFalseView view;

    public TrueOrFalseController(QuestionModel model, TrueOrFalseView view) {
        this.model = model;
        this.view = view;
    }

    public QuestionModel getModel() {
        return model;
    }

    public TrueOrFalseView getView() {
        return view;
    }
}