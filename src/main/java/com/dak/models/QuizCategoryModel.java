package com.dak.models;

import com.dak.db.Database;
import com.dak.db.tables.QuizCategoryTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuizCategoryModel {
    public final UUID id;
    public final UUID quiz_id;
    public final UUID category_id;

    public QuizCategoryModel(UUID id, UUID quiz_id, UUID category_id) {
        this.id = id;
        this.quiz_id = quiz_id;
        this.category_id = category_id;
    }

    public UUID getId() {
        return id;
    }

    public UUID getQuizId() {
        return quiz_id;
    }

    public UUID getCategoryId() {
        return category_id;
    }

    public static @NotNull List<QuizCategoryModel> findAll() {
        String query = String.format("SELECT * FROM %s", QuizCategoryTable.TABLE_NAME);

        try (
                Connection connection = Database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            ArrayList<QuizCategoryModel> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                arrayList.add(new QuizCategoryModel(
                        UUID.fromString(resultSet.getString(QuizCategoryTable.ID)),
                        UUID.fromString(resultSet.getString(QuizCategoryTable.QUIZ_ID)),
                        UUID.fromString(resultSet.getString(QuizCategoryTable.CATEGORY_ID))
                ));
            }

            return arrayList;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public static @Nullable QuizCategoryModel findById(String id) {
        String query = String.format("SELECT * FROM %s WHERE id = ?", QuizCategoryTable.TABLE_NAME);

        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    UUID rsId = UUID.fromString(resultSet.getString(QuizCategoryTable.ID));
                    UUID quizId = UUID.fromString(resultSet.getString(QuizCategoryTable.QUIZ_ID));
                    UUID categoryId = UUID.fromString(resultSet.getString(QuizCategoryTable.CATEGORY_ID));

                    return new QuizCategoryModel(rsId, quizId, categoryId);
                } else {
                    return null;
                }
            }
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
