package com.dak.models;

import com.dak.db.Database;
import com.dak.db.tables.QuizTable;
import com.dak.exceptions.DatabaseReadException;
import com.dak.exceptions.DatabaseWriteException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.time.Instant;
import java.util.UUID;

public class QuizModel {
    private final UUID id;
    private final Instant createdAt;
    private final Instant updatedAt;

    private String title;
    private String creator;

    public QuizModel(UUID id, Instant createdAt, Instant updatedAt, String title, String creator) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

        this.title = title;
        this.creator = creator;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newValue) {
        this.title = newValue;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String newValue) {
        this.creator = newValue;
    }

    public void save() {
        String query = String.format(
            "INSERT INTO quiz (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
            QuizTable.ID_COLUMN,
            QuizTable.CREATED_AT_COLUMN,
            QuizTable.UPDATED_AT_COLUMN,
            QuizTable.TITLE_COLUMN,
            QuizTable.CREATOR_COLUMN
        );

        try (
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, this.id.toString());
            preparedStatement.setTimestamp(2, Timestamp.from(this.createdAt));
            preparedStatement.setTimestamp(3, Timestamp.from(this.updatedAt));
            preparedStatement.setString(4, this.title);
            preparedStatement.setString(5, this.creator);
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            throw new DatabaseWriteException(error.getMessage());
        }
    }
    @Contract("_, _ -> new")
    public static @NotNull QuizModel create(String title, String creator) {
        return new QuizModel(UUID.randomUUID(), Instant.now(), Instant.now(), title, creator);
    }

    public static @Nullable QuizModel findById(String id) {
        String query = String.format("SELECT * FROM %s WHERE id = ?", QuizTable.NAME);

        try (
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UUID rsId = UUID.fromString(resultSet.getString(QuizTable.ID_COLUMN));
                Instant createdAt = resultSet.getTimestamp(QuizTable.CREATED_AT_COLUMN).toInstant();
                Instant updatedAt = resultSet.getTimestamp(QuizTable.UPDATED_AT_COLUMN).toInstant();
                String title = resultSet.getString(QuizTable.TITLE_COLUMN);
                String creator = resultSet.getString(QuizTable.CREATOR_COLUMN);

                return new QuizModel(rsId, createdAt, updatedAt, title, creator);
            } else {
                return null;
            }
        } catch (SQLException error) {
            throw new DatabaseReadException(error.getMessage());
        }
    }
}
