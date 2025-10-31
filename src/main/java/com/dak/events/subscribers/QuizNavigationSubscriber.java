package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;
import com.dak.states.QuizNavigationState;

public interface QuizNavigationSubscriber extends EventSubscriber {
    default void onNext(QuizNavigationState state) {};
    default void onPrevious(QuizNavigationState state) {};
}
