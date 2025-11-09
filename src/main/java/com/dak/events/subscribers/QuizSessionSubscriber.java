package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;
import com.dak.models.OptionModel;
import com.dak.models.QuestionModel;

import java.util.Map;

public interface QuizSessionSubscriber extends EventSubscriber {
    default void onEnd(Map<QuestionModel, Map<OptionModel, Boolean>> answersMap) {}
}
