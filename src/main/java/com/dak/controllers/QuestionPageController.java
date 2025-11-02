package com.dak.controllers;

import com.dak.events.subscribers.NewReleaseItemSubscriber;
import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.states.QuizNavigationState;
import com.dak.views.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class QuestionPageController implements QuizNavigationSubscriber, NewReleaseItemSubscriber {
    private final QuestionPageView view;

    public QuestionPageController(QuestionPageView view) {
        this.view = view;
    }

    public QuestionPageView getView() {
        return view;
    }

    @Override
    public void onNext(@NotNull QuizNavigationState state) {
        view.showPage(state.currentPage);
    }

    @Override
    public void onPrevious(@NotNull QuizNavigationState state) {
        view.showPage(state.currentPage);
    }

    @Override
    public void onPlay(String quizId) {
        System.out.println(quizId);
    }
}
