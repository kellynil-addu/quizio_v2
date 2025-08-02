package com.dak.db;

import com.dak.configs.EnvironmentVariable;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static MysqlDataSource dataSource;

    static {
        Database.dataSource = new MysqlDataSource();
        Database.dataSource.setUrl(EnvironmentVariable.MYSQL_URL);
    }

    public static Connection getConnection() throws SQLException {
        return Database.dataSource.getConnection();
    }
}
