package com.hoffmann.service;

import com.hoffmann.dao.VasarloDAO;
import com.hoffmann.entity.VasarloEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VasarloService {
    private VasarloDAO vasarloDao;

    public VasarloService(Connection connection) {
        this.vasarloDao = new VasarloDAO(connection);
    }

    public List<VasarloEntity> getAllVasarlok() throws SQLException {
        return vasarloDao.getAllVasarlok();
    }

    public void addVasarlo(VasarloEntity vasarlo) throws SQLException {
        vasarloDao.addVasarlo(vasarlo);
    }

    public void updateVasarlo(VasarloEntity vasarlo) throws SQLException {
        vasarloDao.updateVasarlo(vasarlo);
    }

    public void deleteVasarlo(int id) throws SQLException {
        vasarloDao.deleteVasarlo(id);
    }
}
