package com.dak.controllers;

import com.dak.models.QuestionModel;
import com.dak.views.MultipleChoiceView;

public class MultipleChoiceController {
    private final QuestionModel model;
    private final MultipleChoiceView view;

    public MultipleChoiceController(QuestionModel model, MultipleChoiceView view) {
        this.model = model;
        this.view = view;
    }

    public QuestionModel getModel() {
        return model;
    }

    public MultipleChoiceView getView() {
        return view;
    }
}