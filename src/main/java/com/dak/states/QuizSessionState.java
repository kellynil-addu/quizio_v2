package com.dak.states;

public class QuizSessionState {
    public Boolean[] correctAnswers;

    public QuizSessionState(int numberOfQuestions) {
        this.correctAnswers = new Boolean[numberOfQuestions];
    }
}
