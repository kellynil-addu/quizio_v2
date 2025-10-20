package com.dak.models;

import com.dak.db.Database;
import com.dak.db.tables.QuizTable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuizModel {
    private final UUID id;
    private final Instant createdAt;
    private final Instant updatedAt;

    private String title;
    private String creator;

    public QuizModel(UUID id, String title, String creator, Instant createdAt, Instant updatedAt) {
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
            QuizTable.ID,
            QuizTable.TITLE,
            QuizTable.CREATOR,
            QuizTable.CREATED_AT,
            QuizTable.UPDATED_AT
        );

        try (
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, this.id.toString());
            preparedStatement.setString(2, this.title);
            preparedStatement.setString(3, this.creator);
            preparedStatement.setTimestamp(4, Timestamp.from(this.createdAt));
            preparedStatement.setTimestamp(5, Timestamp.from(this.updatedAt));
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    @Contract("_, _ -> new")
    public static @NotNull QuizModel create(String title, String creator) {
        return new QuizModel(UUID.randomUUID(), title, creator, Instant.now(), Instant.now());
    }

    public static @NotNull List<QuizModel> findAll() {
        String query = String.format("SELECT * FROM %s", QuizTable.TABLE_NAME);

        try (
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ) {
            ArrayList<QuizModel> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                arrayList.add(new QuizModel(
                        UUID.fromString(resultSet.getString(QuizTable.ID)),
                        resultSet.getString(QuizTable.TITLE),
                        resultSet.getString(QuizTable.CREATOR),
                        resultSet.getTimestamp(QuizTable.CREATED_AT).toInstant(),
                        resultSet.getTimestamp(QuizTable.UPDATED_AT).toInstant()
                ));
            }

            return arrayList;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public static @Nullable QuizModel findById(String id) {
        String query = String.format("SELECT * FROM %s WHERE id = ?", QuizTable.TABLE_NAME);

        try (
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    UUID rsId = UUID.fromString(resultSet.getString(QuizTable.ID));
                    String title = resultSet.getString(QuizTable.TITLE);
                    String creator = resultSet.getString(QuizTable.CREATOR);
                    Instant createdAt = resultSet.getTimestamp(QuizTable.CREATED_AT).toInstant();
                    Instant updatedAt = resultSet.getTimestamp(QuizTable.UPDATED_AT).toInstant();

                    return new QuizModel(rsId, title, creator, createdAt, updatedAt);
                } else {
                    return null;
                }
            }
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
