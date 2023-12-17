package com.hoffmann.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionMemory {
    private static final String URL = "jdbc:derby:memory:carsalejava;create=true"; // Mem�ri�ban fut� adatb�zis URL-je

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            initializeDatabase(connection); // Inicializ�lja az adatb�zist
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Nem siker�lt csatlakozni az adatb�zishoz", e);
        }
    }

    private static void initializeDatabase(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // T�bl�k l�trehoz�sa �s tesztadatokkal val� felt�lt�s
            // P�ld�ul:
            stmt.execute("CREATE TABLE Autok (id INT PRIMARY KEY, marka VARCHAR(255), modell VARCHAR(255), ...)");
            stmt.execute("INSERT INTO Autok (id, marka, modell, ...) VALUES (1, 'Toyota', 'Corolla', ...)");
            
            // Tov�bbi t�bl�k �s adatok...
            System.out.println("Az adatb�zis k�sz a teszt adatokkal.");
        }
    }
}
