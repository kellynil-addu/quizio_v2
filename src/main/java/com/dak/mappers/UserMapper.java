package com.dak.mappers;

import com.dak.db.tables.UserTable;
import com.dak.models.UserModel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper {
    @Contract("_ -> new")
    public static @NotNull UserModel toModel(@NotNull ResultSet resultSet) throws SQLException {
        return new UserModel(
            UUID.fromString(resultSet.getString(UserTable.ID)),
            resultSet.getString(UserTable.USERNAME),
            resultSet.getString(UserTable.PASSWORD),
            resultSet.getTimestamp(UserTable.CREATED_AT).toInstant(),
            resultSet.getTimestamp(UserTable.UPDATED_AT).toInstant()
        );
    }
}
