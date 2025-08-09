package com.dak.models;

import java.util.UUID;

public class QuestionModel {
    private final UUID id;
    private final UUID quizId;

    private TYPE type;
    private String text;

    public static enum TYPE {
        FILL_IN_THE_BLANK,
        MULTI_SELECT,
        MULTIPLE_CHOICE,
        ORDERING,
        TRUE_OR_FALSE
    }

    public QuestionModel(UUID id, UUID quizId, TYPE type, String text) {
        this.id = id;
        this.quizId = quizId;
        this.type = type;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuizId() {
        return quizId;
    }

    public TYPE getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
