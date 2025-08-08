package com.dak.db;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.file.Files;
import java.sql.*;
import java.util.Arrays;
import java.util.Comparator;

public class Migrator {
    private static final String MIGRATIONS_DIR = "src/main/resources/db/migrations";

    public static void toLatest() {
        createMigrationsTable();

        File[] upSqlFiles = Arrays.stream(getSqlFiles())
            .filter(file -> file.getName().endsWith("up.sql"))
            .sorted(Comparator.comparing(File::getName))
            .toArray(File[]::new);

        runSqlFiles(upSqlFiles);
    }

    public static void reset() {
        File[] downSqlFiles = Arrays.stream(getSqlFiles())
                .filter(file -> file.getName().endsWith("down.sql"))
                .sorted(Comparator.comparing(File::getName).reversed())
                .toArray(File[]::new);

        runSqlFiles(downSqlFiles);
    }

    private static File @NotNull [] getSqlFiles() {
        File[] files = new File(MIGRATIONS_DIR).listFiles((_, name) -> name.endsWith(".sql"));

        if (files == null || files.length == 0) {
            throw new IllegalArgumentException("No SQL migration files found in: " + MIGRATIONS_DIR);
        }

        return files;
    }

    private static void runSqlFiles(File[] files) {
        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            try {
                for (File file : files) {
                    String sql = Files.readString(file.toPath());

                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute(sql);
                    }
                }
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }

            conn.commit();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while executing SQL file: " + e.getMessage());
        }
    }

    private static void addToMigrations(String name) {
        try (Connection conn = Database.getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException("An error occurred while writing to migration table: " + e.getMessage());
        }
    }

    private static void createMigrationsTable() {
        try (
            Connection conn = Database.getConnection();
        ) {
            DatabaseMetaData dbMeta = conn.getMetaData();

            try (ResultSet rs = dbMeta.getTables(null, null, "migrations", new String[] {"TABLE"})) {
                if (rs.next()) return;
            }

            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE `migrations` (name TEXT NOT NULL, migrated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
                stmt.executeUpdate(sql);
            }

            System.out.println("Created migrations table.");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while creating migrations table: " + e.getMessage());
        }
    }
}