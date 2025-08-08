package com.dak.models;

import java.util.UUID;

public class OptionModel {
    private final UUID id;
    private final UUID questionId;

    private PLACE place;
    private String text;
    private boolean isCorrect;

    public static enum PLACE {
        A,
        B,
        C,
        D
    }

    public OptionModel(UUID id, UUID questionId, PLACE place, String text, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.place = place;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public PLACE getPlace() {
        return place;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
