package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;
import com.dak.models.QuestionModel;

public interface QuestionSubscriber extends EventSubscriber {
    default void onInput(String answer, QuestionModel model) {}
}
