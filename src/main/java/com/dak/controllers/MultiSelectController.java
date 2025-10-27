package com.dak.controllers;

import com.dak.models.QuestionModel;
import com.dak.views.MultiSelectView;

public record MultiSelectController(
    QuestionModel model,
    MultiSelectView view
) {}
