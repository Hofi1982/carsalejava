package com.hoffmann.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    
    public static void createTablesIfNotExist(Connection connection) throws SQLException {
        DatabaseMetaData dbMetaData = connection.getMetaData();
        try (Statement stmt = connection.createStatement()) {
            // Autók tábla létrehozása, ha még nem létezik
            createTable(stmt, dbMetaData, "Autok",
                        "CREATE TABLE Autok (" +
                        "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                        "marka VARCHAR(50), " +
                        "modell VARCHAR(50), " +
                        "evjarat INT, " +
                        "kilometerora INT, " +
                        "ar DOUBLE, " +
                        "statusz VARCHAR(50))");

            // Eladók tábla létrehozása, ha még nem létezik
            createTable(stmt, dbMetaData, "Eladok",
                        "CREATE TABLE Eladok (" +
                        "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                        "nev VARCHAR(100), " +
                        "beosztas VARCHAR(100), " +
                        "telefonszam VARCHAR(20), " +
                        "email VARCHAR(100))");

            // Vásárlók tábla létrehozása, ha még nem létezik
            createTable(stmt, dbMetaData, "Vasarlok",
                        "CREATE TABLE Vasarlok (" +
                        "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                        "nev VARCHAR(100), " +
                        "telefonszam VARCHAR(20), " +
                        "email VARCHAR(100), " +
                        "vasarlasok_szama INT)");

            // Tranzakciók tábla létrehozása, ha még nem létezik
            createTable(stmt, dbMetaData, "Tranzakciok",
                        "CREATE TABLE Tranzakciok (" +
                        "tranzakcio_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                        "auto_ID INT, " +
                        "elado_ID INT, " +
                        "vasarlo_ID INT, " +
                        "tranzakcio_datuma DATE, " +
                        "tranzakcio_osszege DOUBLE)");

            System.out.println("Az adatbázis táblák ellenõrizve és szükség esetén létrehozva.");
        }
    }

    private static void createTable(Statement stmt, DatabaseMetaData dbMetaData, String tableName, String sql) throws SQLException {
        if (!tableExists(dbMetaData, tableName)) {
            stmt.executeUpdate(sql);
        }
    }

    private static boolean tableExists(DatabaseMetaData dbMetaData, String tableName) throws SQLException {
        try (ResultSet rs = dbMetaData.getTables(null, null, tableName, null)) {
            return rs.next();
        }
    }
}
