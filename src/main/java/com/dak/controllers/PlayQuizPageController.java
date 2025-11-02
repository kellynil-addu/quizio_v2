package com.dak.controllers;

import com.dak.events.subscribers.NewReleaseItemSubscriber;
import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.states.QuizNavigationState;
import com.dak.views.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class PlayQuizPageController implements QuizNavigationSubscriber, NewReleaseItemSubscriber {
    private final QuestionPageView view;

    public PlayQuizPageController(QuestionPageView view) {
        this.view = view;
    }

    public QuestionPageView getView() {
        return view;
    }

    private void showCurrentPage(int currentPage) {
        CardLayout cardLayout = (CardLayout) view.getCardPanel().getLayout();
        cardLayout.show(view.getCardPanel(), String.valueOf(currentPage));
    }

    @Override
    public void onNext(@NotNull QuizNavigationState state) {
        showCurrentPage(state.currentPage);
    }

    @Override
    public void onPrevious(@NotNull QuizNavigationState state) {
        showCurrentPage(state.currentPage);
    }

    @Override
    public void onPlay(String quizId) {
        System.out.println(quizId);
    }
}
