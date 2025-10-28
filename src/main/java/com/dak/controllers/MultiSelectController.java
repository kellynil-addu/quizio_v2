package com.dak.controllers;

import com.dak.models.QuestionModel;
import com.dak.views.MultiSelectView;

public class MultiSelectController {
    private final QuestionModel model;
    private final MultiSelectView view;

    public MultiSelectController(QuestionModel model, MultiSelectView view) {
        this.model = model;
        this.view = view;
    }

    public QuestionModel getModel() {
        return model;
    }

    public MultiSelectView getView() {
        return view;
    }
}