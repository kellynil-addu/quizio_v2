package com.dak.events.mediators;

import com.dak.Main;
import com.dak.composers.PlayQuizPageComposer;
import com.dak.constants.AppConstants;
import com.dak.events.subscribers.NewReleaseItemSubscriber;
import com.dak.views.*;

import java.awt.*;

public class PlayQuizPageControllerMediator implements NewReleaseItemSubscriber {
    @Override
    public void onPlay(String quizId) {
        PlayQuizPageView questionPageView = PlayQuizPageComposer.createPlayQuizPage(quizId);

        Main.cardPanel.add(questionPageView, AppConstants.QUESTION_PAGE);
        ((CardLayout) Main.cardPanel.getLayout()).show(Main.cardPanel, AppConstants.QUESTION_PAGE);
    }
}
