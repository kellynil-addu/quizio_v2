package com.dak.events.subscribers;

import com.dak.events.EventSubscriber;

public interface PlayQuizPageSubscriber extends EventSubscriber {
    default void onFinish() {}
}
