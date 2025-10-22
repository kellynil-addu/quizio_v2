package com.dak.controllers;

import com.dak.views.QuizNavigationView;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionListener;

public record QuizNavigationController(QuizNavigationView view) {
    public QuizNavigationController(@NotNull QuizNavigationView view) {
        this.view = view;

        view.getPreviousButton().addActionListener(createPreviousButtonActionListener());
        view.getNextButton().addActionListener(createNextButtonActionListener());
    }

    private @NotNull ActionListener createPreviousButtonActionListener() {
        return (e) -> System.out.println("Previous!");
    }

    private @NotNull ActionListener createNextButtonActionListener() {
        return (e) -> System.out.println("Next!");
    }
}
