package com.dak.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ModelUtils<T> {
    protected abstract T map(ResultSet resultSet) throws SQLException;
    
    @Nullable
    public T getResult(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return map(resultSet);
        } else {
            return null;
        }
    }

    @NotNull
    public List<T> getAllResults(ResultSet resultSet) throws SQLException {
        ArrayList<T> arrayList = new ArrayList<>();

        while (resultSet.next()) {
            arrayList.add(map(resultSet));
        }

        return arrayList;
    }
}
