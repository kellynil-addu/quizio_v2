package com.dak.controllers;

import com.dak.events.EventPublisher;
import com.dak.events.enums.NewReleaseItemEvent;
import com.dak.events.subscribers.NewReleaseItemSubscriber;
import com.dak.models.QuizModel;
import com.dak.views.NewReleaseItemView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public class NewReleaseItemController extends EventPublisher<NewReleaseItemSubscriber, NewReleaseItemEvent> {
    private final QuizModel model;
    private final NewReleaseItemView view;

    public NewReleaseItemController(QuizModel model, @NotNull NewReleaseItemView view) {
        this.model = model;
        this.view = view;

        view.getButton().addActionListener(createPlayButtonActionListener());
    }

    public QuizModel getModel() {
        return model;
    }

    public NewReleaseItemView getView() {
        return view;
    }

    private @NotNull ActionListener createPlayButtonActionListener() {
        return (e) -> {
            notifySubscribers(NewReleaseItemEvent.PLAY);
        };
    }

    @Override
    protected void notifyHandler(NewReleaseItemSubscriber subscriber, @NotNull NewReleaseItemEvent event) {
        if (event == NewReleaseItemEvent.PLAY) {
            subscriber.onPlay(model.getId().toString());
        } else {
            throw new IllegalArgumentException("Unhandled event case: " + event);
        }
    }
}