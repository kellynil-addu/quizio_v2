package com.dak.models;

import java.util.UUID;

public class OptionModel {
    private final UUID id;
    private final UUID questionId;

    private String text;
    private boolean isCorrect;

    public OptionModel(UUID id, UUID questionId, String text, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
