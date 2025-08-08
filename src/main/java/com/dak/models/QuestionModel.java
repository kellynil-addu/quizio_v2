package com.dak.models;

import java.util.UUID;

public class QuestionModel {
    private final UUID id;
    private final UUID quizId;
    private final UUID answerId;

    private TYPE type;
    private String text;

    public static enum TYPE {
        FILL_IN_THE_BLANK,
        MULTI_SELECT,
        MULTIPLE_CHOICE,
        ORDERING,
        TRUE_OR_FALSE
    }

    public QuestionModel(UUID id, UUID quizId, UUID answerId, TYPE type, String text) {
        this.id = id;
        this.quizId = quizId;
        this.answerId = answerId;
        this.type = type;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuizId() {
        return quizId;
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public TYPE getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
