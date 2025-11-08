package com.dak.dtos;

public class QuizNavigationDTO {
    public int currentPage;
    public int maxPage;

    public QuizNavigationDTO(int currentPage, int maxPage) {
        this.currentPage = currentPage;
        this.maxPage = maxPage;
    }
}
