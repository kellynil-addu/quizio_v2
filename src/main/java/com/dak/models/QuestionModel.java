package com.dak.models;

import com.dak.db.Database;
import com.dak.db.tables.QuestionTable;
import com.dak.enums.QuestionType;
import com.dak.mappers.QuestionMapper;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionModel {
    private final UUID id;
    private final UUID quizId;

    private QuestionType type;
    private String text;

    public QuestionModel(UUID id, UUID quizId, QuestionType type, String text) {
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

    public QuestionType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static @NotNull List<QuestionModel> findManyByQuizId(@NotNull String quizId) {
        String query = String.format("SELECT * FROM %s WHERE %s = ?", QuestionTable.TABLE_NAME, QuestionTable.QUIZ_ID);

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, quizId);

            ArrayList<QuestionModel> arrayList = new ArrayList<>();

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    arrayList.add(QuestionMapper.toModel(resultSet));
                }
            }

            return arrayList;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
