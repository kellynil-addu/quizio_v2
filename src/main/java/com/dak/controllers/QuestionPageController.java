package com.dak.controllers;

import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.states.QuizNavigationState;
import com.dak.views.QuestionPageView;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class QuestionPageController extends QuizNavigationSubscriber {
    private final QuestionPageView view;

    public QuestionPageController(QuestionPageView view) {
        this.view = view;
    }

    public QuestionPageView getView() {
        return view;
    }

    private void showCurrentPage(int currentPage) {
        ((CardLayout) view.getCardPanel().getLayout()).show(view.getCardPanel(), String.valueOf(currentPage));
    }

    @Override
    public void onNext(@NotNull QuizNavigationState state) {
        showCurrentPage(state.currentPage);
    }

    @Override
    public void onPrevious(@NotNull QuizNavigationState state) {
        showCurrentPage(state.currentPage);
    }
}
