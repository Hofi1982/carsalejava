package com.hoffmann.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionMemory {
    private static final String URL = "jdbc:derby:memory:carsalejava;create=true"; // Memóriában futó adatbázis URL-je

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            initializeDatabase(connection); // Inicializálja az adatbázist
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Nem sikerült csatlakozni az adatbázishoz", e);
        }
    }

    private static void initializeDatabase(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // Táblák létrehozása és tesztadatokkal való feltöltés
            // Például:
            stmt.execute("CREATE TABLE Autok (id INT PRIMARY KEY, marka VARCHAR(255), modell VARCHAR(255), ...)");
            stmt.execute("INSERT INTO Autok (id, marka, modell, ...) VALUES (1, 'Toyota', 'Corolla', ...)");
            
            // További táblák és adatok...
            System.out.println("Az adatbázis kész a teszt adatokkal.");
        }
    }
}
