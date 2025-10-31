package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;

public interface NewReleaseItemSubscriber extends EventSubscriber {
    default void onPlay(String quizId) {}
}
