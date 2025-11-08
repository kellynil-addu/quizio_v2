package com.dak.controllers;

import com.dak.events.EventPublisher;
import com.dak.events.enums.QuizNavigationEvent;
import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.dtos.QuizNavigationDTO;
import com.dak.views.QuizNavigationView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public class QuizNavigationController extends EventPublisher<QuizNavigationSubscriber, QuizNavigationEvent> {
    private final QuizNavigationView view;
    private final QuizNavigationDTO dto;

    public QuizNavigationController(@NotNull QuizNavigationView view, QuizNavigationDTO dto) {
        this.view = view;
        this.dto = dto;

        view.getPreviousButton().addActionListener(createPreviousButtonActionListener());
        view.getNextButton().addActionListener(createNextButtonActionListener());
        view.getFinishButton().addActionListener(createFinishButtonActionListener());
    }

    private void showSecondButton() {
        if (dto.currentPage == dto.maxPage) {
            view.displaySecondButton(view.getFinishButton());
        } else {
            view.displaySecondButton(view.getNextButton());
        }
    }

    private @NotNull ActionListener createPreviousButtonActionListener() {
        return (_) -> {
            if (dto.currentPage == 1) {
                return;
            }

            dto.currentPage -= 1;
            notifySubscribers(QuizNavigationEvent.PREVIOUS);
        };
    }

    private @NotNull ActionListener createNextButtonActionListener() {
        return (_) -> {
            if (dto.currentPage == dto.maxPage) {
                return;
            }

            dto.currentPage += 1;
            notifySubscribers(QuizNavigationEvent.NEXT);
        };
    }

    private @NotNull ActionListener createFinishButtonActionListener() {
        return (_) -> notifySubscribers(QuizNavigationEvent.FINISH);
    }

    @Override
    protected void notifyHandler(QuizNavigationSubscriber subscriber, @NotNull QuizNavigationEvent event) {
        showSecondButton();

        switch (event) {
            case NEXT -> subscriber.onNext(dto);
            case PREVIOUS -> subscriber.onPrevious(dto);
            case FINISH -> subscriber.onFinish();
            default -> throw new IllegalArgumentException("Unhandled event case: " + event);
        }
    }
}