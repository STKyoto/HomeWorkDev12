package org.example.db;

import org.flywaydb.core.Flyway;

public class DataBase {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/HomeWorkDev12";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root";

    static {
        Flyway.configure()
                .dataSource(DB_URL, DB_USER, DB_PASSWORD)
                .locations("db/migrations")
                .load()
                .migrate();
    }
}
