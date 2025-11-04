package com.dak.controllers;

import com.dak.events.subscribers.QuestionSubscriber;
import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.states.QuizNavigationState;
import com.dak.states.QuizSessionState;
import com.dak.views.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class PlayQuizPageController implements QuizNavigationSubscriber, QuestionSubscriber {
    private final PlayQuizPageView view;
    private final QuizSessionState state;

    public PlayQuizPageController(PlayQuizPageView view, QuizSessionState state) {
        this.view = view;
        this.state = state;
    }

    public PlayQuizPageView getView() {
        return view;
    }

    public QuizSessionState getState() {
        return state;
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
    public void onInput() {
        System.out.println("Input!");
    }
}
