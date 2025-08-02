package com.dak.configs;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentVariable {
    public static String MYSQL_URL;

    static {
        Dotenv dotenv = Dotenv.load();

        MYSQL_URL = dotenv.get("MYSQL_URL");

        if (MYSQL_URL == null) {
            throw new IllegalStateException("One or more environment variables are not set.");
        }
    }
}
