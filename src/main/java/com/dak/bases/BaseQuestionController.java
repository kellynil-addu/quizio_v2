package com.dak.bases;

import com.dak.events.EventPublisher;
import com.dak.events.enums.QuestionEvent;
import com.dak.events.subscribers.QuestionSubscriber;
import com.dak.models.QuestionModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class BaseQuestionController<TView> extends EventPublisher<QuestionSubscriber, QuestionEvent> {
    private final QuestionModel model;
    private final TView view;

    public BaseQuestionController(QuestionModel model, TView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    protected void notifyHandler(QuestionSubscriber subscriber, QuestionEvent event) {
        if (event == QuestionEvent.INPUT) {
            subscriber.onInput();
        } else {
            throw new IllegalArgumentException("Unhandled event case: " + event);
        }
    }

    protected @NotNull DocumentListener createComponentDocumentListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                notifySubscribers(QuestionEvent.INPUT);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                notifySubscribers(QuestionEvent.INPUT);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Do nothing
            }
        };
    }

    protected ActionListener createComponentActionListener() {
        return e -> notifySubscribers(QuestionEvent.INPUT);
    }
}
