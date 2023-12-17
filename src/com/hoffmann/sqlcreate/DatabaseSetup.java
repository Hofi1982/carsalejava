package com.hoffmann.sqlcreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        // Adatbázis kapcsolat beállításai
        String url = "jdbc:mysql://localhost:3306/auto_kereskedes";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Autók tábla létrehozása
            String sql = "CREATE TABLE Autok (" +
                         "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                         "marka VARCHAR(50), " +
                         "modell VARCHAR(50), " +
                         "evjarat INT, " +
                         "kilometerora INT, " +
                         "ar DOUBLE, " +
                         "statusz VARCHAR(50))";
            stmt.executeUpdate(sql);

            // Eladók tábla létrehozása
            sql = "CREATE TABLE Eladok (" +
                  "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                  "nev VARCHAR(100), " +
                  "beosztas VARCHAR(100), " +
                  "telefonszam VARCHAR(20), " +
                  "email VARCHAR(100))";
            stmt.executeUpdate(sql);

            // Vásárlók tábla létrehozása
            sql = "CREATE TABLE Vasarlok (" +
                  "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                  "nev VARCHAR(100), " +
                  "telefonszam VARCHAR(20), " +
                  "email VARCHAR(100), " +
                  "vasarlasok_szama INT)";
            stmt.executeUpdate(sql);

            // Tranzakciók tábla létrehozása
            sql = "CREATE TABLE Tranzakciok (" +
                  "tranzakcio_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                  "auto_ID INT, " +
                  "elado_ID INT, " +
                  "vasarlo_ID INT, " +
                  "tranzakcio_datuma DATE, " +
                  "tranzakcio_osszege DOUBLE)";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
