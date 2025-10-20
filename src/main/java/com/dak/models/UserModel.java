package com.dak.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.dak.db.Database;
import com.dak.db.tables.UserTable;
import com.dak.mappers.UserMapper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.time.Instant;
import java.util.UUID;

public class UserModel {
    private final UUID id;
    private final Instant createdAt;
    private final Instant updatedAt;

    private String username;
    private String password;

    public UserModel(UUID id, String username, @NotNull String password, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

        this.username = username;
        this.password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public boolean comparePassword(@NotNull String plainString) {
        BCrypt.Result result = BCrypt.verifyer().verify(plainString.toCharArray(), this.password.toCharArray());
        return result.verified;
    }

    public UUID getId() {
        return this.id;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newValue) {
        this.username = newValue;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newValue) {
        this.password = newValue;
    }

    @Contract("_, _ -> new")
    public static @NotNull UserModel create(String username, String password) {
        return new UserModel(UUID.randomUUID(), username, password, Instant.now(), Instant.now());
    }

    public static @Nullable UserModel findById(String id) {
        String query = String.format("SELECT * FROM %s WHERE id = ?", UserTable.TABLE_NAME);

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return UserMapper.toModel(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void save() {
        String query = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
            UserTable.TABLE_NAME,
            UserTable.ID,
            UserTable.USERNAME,
            UserTable.PASSWORD,
            UserTable.CREATED_AT,
            UserTable.UPDATED_AT
        );

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, this.id.toString());
            preparedStatement.setString(2, this.username);
            preparedStatement.setString(3, this.password);
            preparedStatement.setTimestamp(4, Timestamp.from(this.createdAt));
            preparedStatement.setTimestamp(5, Timestamp.from(this.updatedAt));

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
