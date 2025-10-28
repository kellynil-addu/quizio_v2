package com.dak;

import com.dak.controllers.*;
import com.dak.models.CategoryModel;
import com.dak.models.QuestionModel;
import com.dak.models.QuizModel;
import com.dak.views.*;
import com.dak.views.viewModels.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DummyUIFactory {
    private static final String IMAGE_PATH = "src/main/resources/assets/images/";

    @Contract("_, _, _, _ -> new")
    private static @NotNull QuestionPageView createQuestionPage(
        QuestionModel.TYPE type,
        String questionText,
        JPanel questionInputView,
        Object controller
    ) {

        UUID dummyQuestionId = UUID.randomUUID();
        UUID dummyQuizId = UUID.randomUUID();

        QuestionModel questionModel = new QuestionModel(dummyQuestionId, dummyQuizId, type, questionText);

        QuizNavigationView navigationView = new QuizNavigationView();
        new QuizNavigationController(navigationView);

        QuestionPageViewModel viewModel = new QuestionPageViewModel(
                questionText,
                questionInputView,
                navigationView
        );

        return new QuestionPageView(viewModel);
    }

    public static @NotNull QuestionPageView trueOrFalsePage() {
        String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit.";
        TrueOrFalseView view = new TrueOrFalseView();
        TrueOrFalseController controller = new TrueOrFalseController(
                new QuestionModel(UUID.randomUUID(), UUID.randomUUID(), QuestionModel.TYPE.TRUE_OR_FALSE, text), view);
        return createQuestionPage(QuestionModel.TYPE.TRUE_OR_FALSE, text, view, controller);
    }

    public static @NotNull QuestionPageView multiSelectPage() {
        String text = "Which of the following programming languages have you used? Select all that apply.";

        MultiSelectViewModel vm = new MultiSelectViewModel("Java", "Python", "JavaScript", "C#");
        MultiSelectView view = new MultiSelectView(vm);
        MultiSelectController controller = new MultiSelectController(
                new QuestionModel(UUID.randomUUID(), UUID.randomUUID(), QuestionModel.TYPE.MULTI_SELECT, text), view);

        return createQuestionPage(QuestionModel.TYPE.MULTI_SELECT, text, view, controller);
    }

    public static @NotNull QuestionPageView multipleChoicePage() {
        String text = "If you could travel anywhere in the world right now, where would you want to go?";

        MultipleChoiceViewModel vm = new MultipleChoiceViewModel("Japan", "Iceland", "New Zealand", "Italy");
        MultipleChoiceView view = new MultipleChoiceView(vm);
        MultipleChoiceController controller = new MultipleChoiceController(
                new QuestionModel(UUID.randomUUID(), UUID.randomUUID(), QuestionModel.TYPE.MULTIPLE_CHOICE, text), view);

        return createQuestionPage(QuestionModel.TYPE.MULTIPLE_CHOICE, text, view, controller);
    }

    public static @NotNull QuestionPageView fillInBlankPage() {
        String text = "If you could travel anywhere in the world right now, where would you go and why?";
        FillInTheBlankView view = new FillInTheBlankView();
        FillInTheBlankController controller = new FillInTheBlankController(
                new QuestionModel(UUID.randomUUID(), UUID.randomUUID(), QuestionModel.TYPE.FILL_IN_THE_BLANK, text), view);

        return createQuestionPage(QuestionModel.TYPE.FILL_IN_THE_BLANK, text, view, controller);
    }

    public static @NotNull HomePageView homePage() {
        // Create Category Section
        List<CategoryModel> models = List.of(
                new CategoryModel(UUID.randomUUID(), "Angular", "angular.png"),
                new CategoryModel(UUID.randomUUID(), "C++", "cpp.png"),
                new CategoryModel(UUID.randomUUID(), "C#", "csharp.png"),
                new CategoryModel(UUID.randomUUID(), "CSS", "css.png"),
                new CategoryModel(UUID.randomUUID(), "Docker", "docker.png"),
                new CategoryModel(UUID.randomUUID(), "Git", "git.png"),
                new CategoryModel(UUID.randomUUID(), "Github", "github.png"),
                new CategoryModel(UUID.randomUUID(), "Go", "golang.png"),
                new CategoryModel(UUID.randomUUID(), "HTML", "html.png"),
                new CategoryModel(UUID.randomUUID(), "Java", "java.png"),
                new CategoryModel(UUID.randomUUID(), "JavaScript", "js.png"),
                new CategoryModel(UUID.randomUUID(), "NodeJS", "nodejs.png"),
                new CategoryModel(UUID.randomUUID(), "PHP", "php.png"),
                new CategoryModel(UUID.randomUUID(), "Python", "python.png"),
                new CategoryModel(UUID.randomUUID(), "React", "react.png"),
                new CategoryModel(UUID.randomUUID(), "Ruby", "ruby.png"),
                new CategoryModel(UUID.randomUUID(), "Vue", "vue.png")
        );

        List<CategoryItemView> categoryViews = new ArrayList<>();
        for (CategoryModel model : models) {
            ImageIcon icon = new ImageIcon(IMAGE_PATH + model.getImage());
            CategoryItemViewModel vm = new CategoryItemViewModel(icon);
            CategoryItemView view = new CategoryItemView(vm);
            new CategoryItemController(model, view);
            categoryViews.add(view);
        }

        SectionHeaderViewModel categoryHeaderVM = new SectionHeaderViewModel("Categories");
        CategorySectionViewModel categorySectionVM = new CategorySectionViewModel(
                categoryHeaderVM,
                categoryViews.toArray(new CategoryItemView[0])
        );
        CategorySectionView categorySection = new CategorySectionView(categorySectionVM);

        // Create New Release Section
        int count = 4;
        NewReleaseItemView[] newReleaseViews = new NewReleaseItemView[count];
        for (int i = 0; i < count; i++) {
            QuizModel quiz = new QuizModel(UUID.randomUUID(), "Backend Design and Architecture", "Quizio", Instant.now(), Instant.now());
            NewReleaseItemViewModel vm = new NewReleaseItemViewModel(quiz.getTitle(), quiz.getCreator(), new String[]{"js.png", "cpp.png", "java.png"});
            NewReleaseItemView view = new NewReleaseItemView(vm);
            new NewReleaseItemController(quiz, view);
            newReleaseViews[i] = view;
        }

        SectionHeaderViewModel newReleaseHeaderVM = new SectionHeaderViewModel("New Release");
        NewReleaseSectionViewModel newReleaseSectionVM = new NewReleaseSectionViewModel(newReleaseHeaderVM, newReleaseViews);
        NewReleaseSectionView newReleaseSection = new NewReleaseSectionView(newReleaseSectionVM);

        // Create HomePageViewModel and HomePageView
        HomePageViewModel homePageViewModel = new HomePageViewModel(categorySection, newReleaseSection);
        return new HomePageView(homePageViewModel);
    }
}

