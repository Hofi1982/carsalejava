package com.hoffmann.dao;

import com.hoffmann.entity.EladoEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EladoDAO {
    private Connection connection;

    public EladoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<EladoEntity> getAllEladok() throws SQLException {
        List<EladoEntity> eladok = new ArrayList<>();
        String sql = "SELECT * FROM Eladok";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EladoEntity elado = new EladoEntity(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("beosztas"),
                    rs.getString("telefonszam"),
                    rs.getString("email")
                );
                eladok.add(elado);
            }
        }
        return eladok;
    }

    public void addElado(EladoEntity elado) throws SQLException {
        String sql = "INSERT INTO Eladok (nev, beosztas, telefonszam, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, elado.getNev());
            pstmt.setString(2, elado.getBeosztas());
            pstmt.setString(3, elado.getTelefonszam());
            pstmt.setString(4, elado.getEmail());
            pstmt.executeUpdate();
        }
    }

    public void updateElado(EladoEntity elado) throws SQLException {
        String sql = "UPDATE Eladok SET nev = ?, beosztas = ?, telefonszam = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, elado.getNev());
            pstmt.setString(2, elado.getBeosztas());
            pstmt.setString(3, elado.getTelefonszam());
            pstmt.setString(4, elado.getEmail());
            pstmt.setInt(5, elado.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteElado(int id) throws SQLException {
        String sql = "DELETE FROM Eladok WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
