package com.hoffmann.dao;

import com.hoffmann.entity.AutoEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/carsalejava";
    private static final String USER = "carsalejava";
    private static final String PASSWORD = "carsalejava";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public void addAuto(AutoEntity auto) throws SQLException {
        String sql = "INSERT INTO Autok (marka, modell, evjarat, kilometerora, ar, statusz) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, auto.getMarka());
            stmt.setString(2, auto.getModell());
            stmt.setInt(3, auto.getEvjarat());
            stmt.setInt(4, auto.getKilometerora());
            stmt.setDouble(5, auto.getAr());
            stmt.setString(6, auto.getStatusz());
            stmt.executeUpdate();
        }
    }

    public List<AutoEntity> getAllAutos() throws SQLException {
        List<AutoEntity> autos = new ArrayList<>();
        String sql = "SELECT * FROM Autok";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AutoEntity auto = new AutoEntity(
                    rs.getInt("ID"),
                    rs.getString("marka"),
                    rs.getString("modell"),
                    rs.getInt("evjarat"),
                    rs.getInt("kilometerora"),
                    rs.getDouble("ar"),
                    rs.getString("statusz")
                );
                autos.add(auto);
            }
        }
        return autos;
    }

    public List<AutoEntity> findAutos(String marka, String modell, Integer evjarat, Integer kilometerora, Double ar, String statusz) throws SQLException {
        List<AutoEntity> autos = new ArrayList<>();
        String sql = "SELECT * FROM Autok WHERE marka LIKE ? AND modell LIKE ? AND (evjarat = ? OR ? IS NULL) AND (kilometerora = ? OR ? IS NULL) AND (ar = ? OR ? IS NULL) AND statusz LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, marka.isEmpty() ? "%" : marka);
            stmt.setString(2, modell.isEmpty() ? "%" : modell);
            stmt.setObject(3, evjarat, Types.INTEGER);
            stmt.setObject(4, evjarat, Types.INTEGER);
            stmt.setObject(5, kilometerora, Types.INTEGER);
            stmt.setObject(6, kilometerora, Types.INTEGER);
            stmt.setObject(7, ar, Types.DOUBLE);
            stmt.setObject(8, ar, Types.DOUBLE);
            stmt.setString(9, statusz.isEmpty() ? "%" : statusz);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AutoEntity auto = new AutoEntity(
                    rs.getInt("ID"),
                    rs.getString("marka"),
                    rs.getString("modell"),
                    rs.getInt("evjarat"),
                    rs.getInt("kilometerora"),
                    rs.getDouble("ar"),
                    rs.getString("statusz")
                );
                autos.add(auto);
            }
        }
        return autos;
    }
}
