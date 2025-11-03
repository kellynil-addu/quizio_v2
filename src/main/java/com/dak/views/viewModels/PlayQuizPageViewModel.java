package com.dak.views.viewModels;

import com.dak.states.QuizNavigationState;
import com.dak.views.QuizNavigationView;

public record PlayQuizPageViewModel(QuizNavigationView quizNavigationView, QuizNavigationState quizNavigationState) {}
