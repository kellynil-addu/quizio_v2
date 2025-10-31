package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;

import java.util.UUID;

public interface NewReleaseItemSubscriber extends EventSubscriber {
    default void onPlay(UUID quizId) {}
}
