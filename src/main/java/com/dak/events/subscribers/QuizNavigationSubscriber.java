package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;
import com.dak.dtos.QuizNavigationDTO;

public interface QuizNavigationSubscriber extends EventSubscriber {
    default void onNext(QuizNavigationDTO dto) {}
    default void onPrevious(QuizNavigationDTO dto) {}
    default void onFinish() {}
}
