package com.hoffmann.dao;

import com.hoffmann.entity.VasarloEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VasarloDAO {
    private Connection connection;

    public VasarloDAO(Connection connection) {
        this.connection = connection;
    }

    public List<VasarloEntity> getAllVasarlok() throws SQLException {
        List<VasarloEntity> vasarlok = new ArrayList<>();
        String sql = "SELECT * FROM Vasarlok";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                VasarloEntity vasarlo = new VasarloEntity(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("telefonszam"),
                    rs.getString("email"),
                    rs.getInt("vasarlasokSzama")
                );
                vasarlok.add(vasarlo);
            }
        }
        return vasarlok;
    }

    public void addVasarlo(VasarloEntity vasarlo) throws SQLException {
        String sql = "INSERT INTO Vasarlok (nev, telefonszam, email, vasarlasokSzama) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vasarlo.getNev());
            pstmt.setString(2, vasarlo.getTelefonszam());
            pstmt.setString(3, vasarlo.getEmail());
            pstmt.setInt(4, vasarlo.getVasarlasokSzama());
            pstmt.executeUpdate();
        }
    }

    public void updateVasarlo(VasarloEntity vasarlo) throws SQLException {
        String sql = "UPDATE Vasarlok SET nev = ?, telefonszam = ?, email = ?, vasarlasokSzama = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vasarlo.getNev());
            pstmt.setString(2, vasarlo.getTelefonszam());
            pstmt.setString(3, vasarlo.getEmail());
            pstmt.setInt(4, vasarlo.getVasarlasokSzama());
            pstmt.setInt(5, vasarlo.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteVasarlo(int id) throws SQLException {
        String sql = "DELETE FROM Vasarlok WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
