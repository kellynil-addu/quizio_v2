package com.dak.mappers;

import com.dak.db.tables.CategoryTable;
import com.dak.models.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CategoryMapper {
    public static CategoryModel toModel(ResultSet resultSet) throws SQLException {
        return new CategoryModel(
            UUID.fromString(resultSet.getString(CategoryTable.ID)),
            resultSet.getString(CategoryTable.NAME),
            resultSet.getString(CategoryTable.IMAGE)
        );
    }
}
