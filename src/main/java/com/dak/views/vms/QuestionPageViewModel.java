package com.dak.views.vms;

import com.dak.views.QuizNavigationView;

import javax.swing.*;

public record QuestionPageViewModel(String text, JPanel questionInputView, QuizNavigationView quizNavigationView) {
}
