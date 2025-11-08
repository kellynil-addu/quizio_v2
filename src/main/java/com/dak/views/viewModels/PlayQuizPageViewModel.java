package com.dak.views.viewModels;

import com.dak.dtos.QuizNavigationDTO;
import com.dak.views.QuizNavigationView;

public record PlayQuizPageViewModel(QuizNavigationView quizNavigationView, QuizNavigationDTO quizNavigationDTO) {}
