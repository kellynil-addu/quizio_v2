package com.dak.states;

import com.dak.models.OptionModel;
import com.dak.models.QuestionModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizSessionState {
    public final Map<QuestionModel, List<OptionModel>> optionsMap;
    public final Map<QuestionModel, Map<OptionModel, Boolean>> answersMap = new HashMap<>();

    public QuizSessionState(Map<QuestionModel, List<OptionModel>> optionsMap) {
       this.optionsMap = optionsMap;
    }
}
