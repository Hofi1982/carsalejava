package com.hoffmann.main;

import com.hoffmann.service.AutoService;
import com.hoffmann.service.EladoService;
import com.hoffmann.service.VasarloService;
import com.hoffmann.service.TranzakcioService;
import com.hoffmann.database.DbConnection;
import com.hoffmann.database.DatabaseInitializer;
import java.sql.Connection;

public class Main_db {
    public static void main(String[] args) {
        try (Connection connection = DbConnection.getConnection()) {
            // Az adatbázis táblák inicializálása
            DatabaseInitializer.createTablesIfNotExist(connection);

            // Service osztályok inicializálása
            //AutoService autoService = new AutoService(connection);
            EladoService eladoService = new EladoService(connection);
            VasarloService vasarloService = new VasarloService(connection);
            TranzakcioService tranzakcioService = new TranzakcioService(connection);

            // Itt lehet használni a service osztályokat...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
