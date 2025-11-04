package com.dak.mappers;

import com.dak.db.tables.QuestionTable;
import com.dak.enums.QuestionType;
import com.dak.models.QuestionModel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class QuestionMapper {
    @Contract("_ -> new")
    public static @NotNull QuestionModel toModel(@NotNull ResultSet resultSet) throws SQLException {
        return new QuestionModel(
            UUID.fromString(resultSet.getString(QuestionTable.ID)),
            UUID.fromString(resultSet.getString(QuestionTable.QUIZ_ID)),
            QuestionType.valueOf(resultSet.getString(QuestionTable.TYPE)),
            resultSet.getString(QuestionTable.TEXT)
        );
    }

}
