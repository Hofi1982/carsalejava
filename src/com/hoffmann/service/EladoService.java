package com.hoffmann.service;

import com.hoffmann.dao.EladoDAO;
import com.hoffmann.entity.EladoEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EladoService {
    private EladoDAO eladoDao;

    public EladoService(Connection connection) {
        this.eladoDao = new EladoDAO(connection);
    }

    public List<EladoEntity> getAllEladok() throws SQLException {
        return eladoDao.getAllEladok();
    }

    public void addElado(EladoEntity elado) throws SQLException {
        eladoDao.addElado(elado);
    }

    public void updateElado(EladoEntity elado) throws SQLException {
        eladoDao.updateElado(elado);
    }

    public void deleteElado(int id) throws SQLException {
        eladoDao.deleteElado(id);
    }
}
