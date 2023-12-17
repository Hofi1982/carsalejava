package com.hoffmann.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/carsalejava"; // Az adatb�zis URL-je
    private static final String USER = "carsalejava"; // Adatb�zis felhaszn�l�neve
    private static final String PASSWORD = "carsalejava"; // Adatb�zis jelszava

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Nem siker�lt csatlakozni az adatb�zishoz", e);
        }
    }
}
