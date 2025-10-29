package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;
import com.dak.states.QuizNavigationState;

public abstract class QuizNavigationSubscriber implements EventSubscriber {
    public void onNext(QuizNavigationState state) {};
    public void onPrevious(QuizNavigationState state) {};
}
