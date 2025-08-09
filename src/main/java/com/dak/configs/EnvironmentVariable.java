package com.dak.configs;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentVariable {
    public static final String DATABASE_HOST;
    public static final int DATABASE_PORT;
    public static final String DATABASE_NAME;
    public static final String DATABASE_USER;
    public static final String DATABASE_PASSWORD;
    public static final String DATABASE_URL;

    static {
        Dotenv dotenv = Dotenv.load();

        DATABASE_HOST = dotenv.get("DATABASE_HOST");
        DATABASE_PORT = Integer.parseInt(dotenv.get("DATABASE_PORT", "3306"));
        DATABASE_NAME = dotenv.get("DATABASE_NAME");
        DATABASE_USER = dotenv.get("DATABASE_USER");
        DATABASE_PASSWORD = dotenv.get("DATABASE_PASSWORD");
        DATABASE_URL = dotenv.get("DATABASE_URL");

        if (DATABASE_HOST == null || DATABASE_NAME == null || DATABASE_USER == null || DATABASE_PASSWORD == null || DATABASE_URL == null) {
            throw new IllegalStateException("One or more required environment variables are not set.");
        }
    }
}
