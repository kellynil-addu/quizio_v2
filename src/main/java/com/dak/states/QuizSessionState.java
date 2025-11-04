package com.dak.states;

import com.dak.models.OptionModel;
import com.dak.models.QuestionModel;

import java.util.List;
import java.util.Map;

public class QuizSessionState {
    public Map<QuestionModel, List<OptionModel>> options;

    public QuizSessionState(Map<QuestionModel, List<OptionModel>> options) {
       this.options = options;
    }
}
