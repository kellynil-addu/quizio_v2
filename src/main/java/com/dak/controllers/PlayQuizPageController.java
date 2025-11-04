package com.dak.controllers;

import com.dak.enums.QuestionType;
import com.dak.events.subscribers.QuestionSubscriber;
import com.dak.events.subscribers.QuizNavigationSubscriber;
import com.dak.models.OptionModel;
import com.dak.models.QuestionModel;
import com.dak.states.QuizNavigationState;
import com.dak.states.QuizSessionState;
import com.dak.views.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class PlayQuizPageController implements QuizNavigationSubscriber, QuestionSubscriber {
    private final PlayQuizPageView view;
    private final QuizSessionState state;
    private final Map<QuestionModel, List<OptionModel>> options;

    public PlayQuizPageController(PlayQuizPageView view, QuizSessionState state, Map<QuestionModel, List<OptionModel>> options) {
        this.view = view;
        this.state = state;
        this.options = options;
    }

    public PlayQuizPageView getView() {
        return view;
    }

    public QuizSessionState getState() {
        return state;
    }

    public Map<QuestionModel, List<OptionModel>> getOptions() {
        return options;
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
    public void onInput(String answer, QuestionType type) {
        System.out.println(answer);
    }
}
