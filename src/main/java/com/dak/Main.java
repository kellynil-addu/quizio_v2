package com.dak;

import java.awt.*;
import java.util.UUID;

import javax.swing.*;

import com.dak.models.QuestionModel;
import com.dak.views.components.*;
import org.flywaydb.core.Flyway;

import com.dak.configs.EnvironmentVariable;
import com.dak.views.utils.ColorSet;
import com.dak.views.utils.SizeSet;

public class Main {
    public static final JFrame frame = new JFrame();
    public static final JPanel appPanel = new JPanel(new CardLayout());

    public static final HomePage homePage = new HomePage();
    public static final QuizPage quizPage = new QuizPage();

    public static void main(String[] args) {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBackground(ColorSet.getPrimaryBackground());
        contentPane.setBorder(BorderFactory.createEmptyBorder(SizeSet.XS, SizeSet.XS, SizeSet.XS, SizeSet.XS));

        // Sample Questions
        UUID quizId = UUID.randomUUID();
        String placeholderText = "Lorem ipsum dolor sit amet consectetur adipiscing elit.";

        QuestionModel multipleChoice = new QuestionModel(
            UUID.randomUUID(),
            quizId,
            QuestionModel.TYPE.MULTIPLE_CHOICE,
            placeholderText
        );

        QuestionModel fillInTheBlank = new QuestionModel(
            UUID.randomUUID(),
            quizId,
            QuestionModel.TYPE.FILL_IN_THE_BLANK,
            placeholderText
        );

        QuestionModel multiSelect = new QuestionModel(
            UUID.randomUUID(),
            quizId,
            QuestionModel.TYPE.MULTI_SELECT,
            placeholderText
        );

        QuestionModel trueOrFalse = new QuestionModel(
            UUID.randomUUID(),
            quizId,
            QuestionModel.TYPE.TRUE_OR_FALSE,
            placeholderText
        );

        QuestionModel[] questions = { fillInTheBlank, multipleChoice, multiSelect, trueOrFalse };

        quizPage.addQuestions(questions);

        appPanel.setOpaque(false);
        appPanel.add(homePage, "home");
        appPanel.add(quizPage, "quiz");

        contentPane.add(appPanel);

        frame.setTitle("Quizio");
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Runs all pending migrations on the database.
     *
     * <p>Note: For best practice, consider integrating this functionality as a separate
     * console command instead of invoking it directly within the application code.</p>
     */
    private static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        EnvironmentVariable.DATABASE_URL,
                        EnvironmentVariable.DATABASE_USER,
                        EnvironmentVariable.DATABASE_PASSWORD
                )
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}
