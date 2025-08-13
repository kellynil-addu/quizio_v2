package com.dak.models;

import com.dak.db.Database;
import com.dak.db.tables.CategoryTable;
import com.dak.exceptions.DatabaseReadException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryModel {
    private final UUID id;

    private String name;
    private String image;

    public CategoryModel(UUID id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newValue) {
        this.name = newValue;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String newValue) {
        this.image = newValue;
    }

    public static @NotNull List<CategoryModel> findAll() {
        String query = String.format("SELECT * FROM %s", CategoryTable.TABLE_NAME);

        try (
                Connection connection = Database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            ArrayList<CategoryModel> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                arrayList.add(new CategoryModel(
                        UUID.fromString(resultSet.getString(CategoryTable.ID)),
                        resultSet.getString(CategoryTable.NAME),
                        resultSet.getString(CategoryTable.IMAGE)
                ));
            }

            return arrayList;
        } catch (SQLException error) {
            throw new DatabaseReadException(error.getMessage());
        }
    }

    public static @Nullable CategoryModel findById(String id) {
        String query = String.format("SELECT * FROM %s WHERE id = ?", CategoryTable.TABLE_NAME);

        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    UUID rsId = UUID.fromString(resultSet.getString(CategoryTable.ID));
                    String name = resultSet.getString(CategoryTable.NAME);
                    String image = resultSet.getString(CategoryTable.IMAGE);

                    return new CategoryModel(rsId, name, image);
                } else {
                    return null;
                }
            }
        } catch (SQLException error) {
            throw new DatabaseReadException(error.getMessage());
        }
    }
}
