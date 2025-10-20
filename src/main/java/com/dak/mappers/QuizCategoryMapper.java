package com.dak.mappers;

import com.dak.db.tables.QuizCategoryTable;
import com.dak.models.QuizCategoryModel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class QuizCategoryMapper {
    @Contract("_ -> new")
    public static @NotNull QuizCategoryModel toModel(@NotNull ResultSet resultSet) throws SQLException {
        return new QuizCategoryModel(
            UUID.fromString(resultSet.getString(QuizCategoryTable.ID)),
            UUID.fromString(resultSet.getString(QuizCategoryTable.QUIZ_ID)),
            UUID.fromString(resultSet.getString(QuizCategoryTable.CATEGORY_ID))
        );
    }
}
