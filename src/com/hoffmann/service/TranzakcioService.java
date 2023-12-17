package com.hoffmann.service;

import com.hoffmann.dao.TranzakcioDAO;
import com.hoffmann.entity.TranzakcioEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TranzakcioService {
    private TranzakcioDAO tranzakcioDao;

    public TranzakcioService(Connection connection) {
        this.tranzakcioDao = new TranzakcioDAO(connection);
    }

    public List<TranzakcioEntity> getAllTranzakciok() throws SQLException {
        return tranzakcioDao.getAllTranzakciok();
    }

    public void addTranzakcio(TranzakcioEntity tranzakcio) throws SQLException {
        tranzakcioDao.addTranzakcio(tranzakcio);
    }

    public void updateTranzakcio(TranzakcioEntity tranzakcio) throws SQLException {
        tranzakcioDao.updateTranzakcio(tranzakcio);
    }

    public void deleteTranzakcio(int tranzakcioId) throws SQLException {
        tranzakcioDao.deleteTranzakcio(tranzakcioId);
    }
}
