package com.dak.controllers;

import com.dak.events.EventPublisher;
import com.dak.events.enums.QuizNavigationEvent;
import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.states.QuizNavigationState;
import com.dak.views.QuizNavigationView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public class QuizNavigationController extends EventPublisher<QuizNavigationSubscriber, QuizNavigationEvent> {
    private final QuizNavigationView view;
    private final QuizNavigationState state;

    public QuizNavigationController(@NotNull QuizNavigationView view, QuizNavigationState state) {
        this.view = view;
        this.state = state;

        view.getPreviousButton().addActionListener(createPreviousButtonActionListener());
        view.getNextButton().addActionListener(createNextButtonActionListener());
        view.getFinishButton().addActionListener(createFinishButtonActionListener());
    }

    public QuizNavigationView getView() {
        return view;
    }

    public QuizNavigationState getState() {
        return state;
    }

    private void showSecondButton() {
        if (state.currentPage == state.maxPage) {
            view.displaySecondButton(view.getFinishButton());
        } else {
            view.displaySecondButton(view.getNextButton());
        }
    }

    private @NotNull ActionListener createPreviousButtonActionListener() {
        return (e) -> {
            if (state.currentPage == 1) {
                return;
            }

            state.currentPage -= 1;
            notifySubscribers(QuizNavigationEvent.PREVIOUS);
        };
    }

    private @NotNull ActionListener createNextButtonActionListener() {
        return (e) -> {
            if (state.currentPage == state.maxPage) {
                return;
            }

            state.currentPage += 1;
            notifySubscribers(QuizNavigationEvent.NEXT);
        };
    }

    private @NotNull ActionListener createFinishButtonActionListener() {
        return (e) -> {
            notifySubscribers(QuizNavigationEvent.FINISH);
        };
    }

    @Override
    protected void notifyHandler(QuizNavigationSubscriber subscriber, @NotNull QuizNavigationEvent event) {
        showSecondButton();

        switch (event) {
            case NEXT -> subscriber.onNext(state);
            case PREVIOUS -> subscriber.onPrevious(state);
            case FINISH -> subscriber.onFinish();
            default -> throw new IllegalArgumentException("Unhandled event case: " + event);
        }
    }
}