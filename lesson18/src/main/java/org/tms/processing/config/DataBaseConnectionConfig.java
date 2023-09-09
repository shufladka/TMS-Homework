package org.tms.processing.config;

import org.postgresql.Driver;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnectionConfig {
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection () {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/c23",
                    "postgres",
                    "Frikadel01"
            );
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
