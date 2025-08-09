package com.dak.db;

import com.dak.configs.EnvironmentVariable;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final MysqlDataSource dataSource;

    static {
        dataSource = new MysqlDataSource();
        dataSource.setServerName(EnvironmentVariable.DATABASE_HOST);
        dataSource.setPortNumber(EnvironmentVariable.DATABASE_PORT);
        dataSource.setDatabaseName(EnvironmentVariable.DATABASE_NAME);
        dataSource.setUser(EnvironmentVariable.DATABASE_USER);
        dataSource.setPassword(EnvironmentVariable.DATABASE_PASSWORD);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}