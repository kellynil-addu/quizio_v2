package com.dak.composers;

import com.dak.constants.AppConstants;
import com.dak.contracts.QuestionInputContract;
import com.dak.controllers.*;
import com.dak.models.OptionModel;
import com.dak.models.QuestionModel;
import com.dak.states.QuizNavigationState;
import com.dak.views.*;
import com.dak.views.viewModels.MultiSelectViewModel;
import com.dak.views.viewModels.MultipleChoiceViewModel;
import com.dak.views.viewModels.QuestionPageViewModel;
import com.dak.views.viewModels.QuestionViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class QuestionPageComposer {
    public static @NotNull QuestionPageView createQuestionPage(String quizId) {
        List<QuestionModel> questionModels = QuestionModel.findManyByQuizId(quizId);

        QuizNavigationState quizNavigationState = new QuizNavigationState(1, questionModels.size());

        QuizNavigationView quizNavigationView = new QuizNavigationView();
        QuizNavigationController quizNavigationController = new QuizNavigationController(quizNavigationView, quizNavigationState);

        QuestionPageViewModel questionPageViewModel = new QuestionPageViewModel(quizNavigationView, quizNavigationState);

        List<QuestionViewModel> questionViewModels = new ArrayList<>();

        for (QuestionModel questionModel : questionModels) {
            QuestionInputContract questionInputView;

            switch (questionModel.getType()) {
                case QuestionModel.TYPE.FILL_IN_THE_BLANK -> {
                    FillInTheBlankView fillInTheBlankView = new FillInTheBlankView();
                    new FillInTheBlankController(questionModel, fillInTheBlankView);

                    questionInputView = fillInTheBlankView;
                }
                case QuestionModel.TYPE.MULTIPLE_CHOICE -> {
                    List<OptionModel> optionModels = OptionModel.findManyByQuestionId(questionModel.getId());

                    String[] optionTexts = optionModels
                            .stream()
                            .map(OptionModel::getText)
                            .toArray(String[]::new);

                    MultipleChoiceViewModel multipleChoiceViewModel = new MultipleChoiceViewModel(optionTexts[0], optionTexts[1], optionTexts[2], optionTexts[3]);
                    MultipleChoiceView multipleChoiceView = new MultipleChoiceView(multipleChoiceViewModel);
                    new MultipleChoiceController(questionModel, multipleChoiceView);

                    questionInputView = multipleChoiceView;
                }
                case QuestionModel.TYPE.MULTI_SELECT -> {
                    List<OptionModel> optionModels = OptionModel.findManyByQuestionId(questionModel.getId());

                    String[] optionTexts = optionModels
                            .stream()
                            .map(OptionModel::getText)
                            .toArray(String[]::new);

                    MultiSelectViewModel multiSelectViewModel = new MultiSelectViewModel(optionTexts[0], optionTexts[1], optionTexts[2], optionTexts[3]);
                    MultiSelectView multiSelectView = new MultiSelectView(multiSelectViewModel);
                    new MultiSelectController(questionModel, multiSelectView);

                    questionInputView = multiSelectView;
                }
                case QuestionModel.TYPE.TRUE_OR_FALSE -> {
                    TrueOrFalseView trueOrFalseView = new TrueOrFalseView();
                    new TrueOrFalseController(questionModel, trueOrFalseView);

                    questionInputView = trueOrFalseView;
                }
                default -> throw new IllegalArgumentException("Unhandled question model type: " + questionModel.getType());
            }

            // TODO: Change underline length to answer length.
            String text = questionModel.getText().replace(AppConstants.QUESTION_BLANK_DELIMITER, "__________");

            QuestionViewModel questionViewModel = new QuestionViewModel(text, questionInputView);
            questionViewModels.add(questionViewModel);
        }

        QuestionPageView questionPageView = new QuestionPageView(questionPageViewModel, questionViewModels.toArray(QuestionViewModel[]::new));
        QuestionPageController questionPageController = new QuestionPageController(questionPageView);

        quizNavigationController.addSubscriber(questionPageController);

        return questionPageView;
    }
}
