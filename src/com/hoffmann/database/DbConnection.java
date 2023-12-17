package com.hoffmann.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/carsalejava"; // Az adatbázis URL-je
    private static final String USER = "carsalejava"; // Adatbázis felhasználóneve
    private static final String PASSWORD = "carsalejava"; // Adatbázis jelszava

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Nem sikerült csatlakozni az adatbázishoz", e);
        }
    }
}
