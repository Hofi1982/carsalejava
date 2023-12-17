package com.hoffmann.dao;

import com.hoffmann.entity.TranzakcioEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TranzakcioDAO {
    private Connection connection;

    public TranzakcioDAO(Connection connection) {
        this.connection = connection;
    }

    public List<TranzakcioEntity> getAllTranzakciok() throws SQLException {
        List<TranzakcioEntity> tranzakciok = new ArrayList<>();
        String sql = "SELECT * FROM Tranzakciok";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TranzakcioEntity tranzakcio = new TranzakcioEntity(
                    rs.getInt("tranzakcioId"),
                    rs.getInt("autoId"),
                    rs.getInt("eladoId"),
                    rs.getInt("vasarloId"),
                    rs.getDate("tranzakcioDatuma"),
                    rs.getDouble("tranzakcioOsszege")
                );
                tranzakciok.add(tranzakcio);
            }
        }
        return tranzakciok;
    }

    public void addTranzakcio(TranzakcioEntity tranzakcio) throws SQLException {
        String sql = "INSERT INTO Tranzakciok (autoId, eladoId, vasarloId, tranzakcioDatuma, tranzakcioOsszege) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, tranzakcio.getAutoId());
            pstmt.setInt(2, tranzakcio.getEladoId());
            pstmt.setInt(3, tranzakcio.getVasarloId());
            pstmt.setDate(4, tranzakcio.getTranzakcioDatuma());
            pstmt.setDouble(5, tranzakcio.getTranzakcioOsszege());
            pstmt.executeUpdate();
        }
    }

    public void updateTranzakcio(TranzakcioEntity tranzakcio) throws SQLException {
        String sql = "UPDATE Tranzakciok SET autoId = ?, eladoId = ?, vasarloId = ?, tranzakcioDatuma = ?, tranzakcioOsszege = ? WHERE tranzakcioId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, tranzakcio.getAutoId());
            pstmt.setInt(2, tranzakcio.getEladoId());
            pstmt.setInt(3, tranzakcio.getVasarloId());
            pstmt.setDate(4, tranzakcio.getTranzakcioDatuma());
            pstmt.setDouble(5, tranzakcio.getTranzakcioOsszege());
            pstmt.setInt(6, tranzakcio.getTranzakcioId());
            pstmt.executeUpdate();
        }
    }

    public void deleteTranzakcio(int tranzakcioId) throws SQLException {
        String sql = "DELETE FROM Tranzakciok WHERE tranzakcioId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, tranzakcioId);
            pstmt.executeUpdate();
        }
    }
}
