package com.dak.controllers;

import com.dak.models.QuestionModel;
import com.dak.views.FillInTheBlankView;

public class FillInTheBlankController {
    private final QuestionModel model;
    private final FillInTheBlankView view;

    public FillInTheBlankController(QuestionModel model, FillInTheBlankView view) {
        this.model = model;
        this.view = view;
    }

    public QuestionModel getModel() {
        return model;
    }

    public FillInTheBlankView getView() {
        return view;
    }
}