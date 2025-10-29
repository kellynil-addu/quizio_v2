package com.dak.views.viewModels;

import com.dak.contracts.QuestionInput;

public record QuestionViewModel(
    String text,
    QuestionInput questionInputView
) {}
