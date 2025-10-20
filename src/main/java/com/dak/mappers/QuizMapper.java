package com.dak.mappers;

import com.dak.db.tables.QuizTable;
import com.dak.models.QuizModel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class QuizMapper {
    @Contract("_ -> new")
    public static @NotNull QuizModel toModel(@NotNull ResultSet resultSet) throws SQLException {
        return new QuizModel(
            UUID.fromString(resultSet.getString(QuizTable.ID)),
            resultSet.getString(QuizTable.TITLE),
            resultSet.getString(QuizTable.CREATOR),
            resultSet.getTimestamp(QuizTable.CREATED_AT).toInstant(),
            resultSet.getTimestamp(QuizTable.UPDATED_AT).toInstant()
        );
    }
}
