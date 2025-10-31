package com.dak.views.viewModels;

import com.dak.contracts.QuestionInputContract;

public record QuestionViewModel(
    String text,
    QuestionInputContract questionInputView
) {}
