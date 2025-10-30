package com.dak.states;

public class QuizNavigationState {
    public int currentPage;
    public int maxPage;

    public QuizNavigationState(int currentPage, int maxPage) {
        this.currentPage = currentPage;
        this.maxPage = maxPage;
    }
}
