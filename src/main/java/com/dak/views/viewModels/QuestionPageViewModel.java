package com.dak.views.viewModels;

import com.dak.states.QuizNavigationState;
import com.dak.views.QuizNavigationView;

public record QuestionPageViewModel(QuizNavigationView quizNavigationView, QuizNavigationState state) {}
