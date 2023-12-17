package com.hoffmann.service;

import com.hoffmann.entity.AutoEntity;
import com.hoffmann.dao.AutoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Collections;

public class AutoService {
    private AutoDAO autoDao;

    public AutoService() {
        this.autoDao = new AutoDAO();
    }

    public List<AutoEntity> getAllAutos() throws SQLException {
        return autoDao.getAllAutos();
    }

    public void addAuto(AutoEntity auto) throws SQLException {
        autoDao.addAuto(auto);
    }

    public List<AutoEntity> findAutos(String marka, String modell, Integer evjarat, Integer kilometerora, Double ar, String statusz) throws SQLException {
        // Ellen�rz�s, hogy legal�bb az egyik param�ter nem null �s nem �res
        if ((marka != null && !marka.isEmpty()) || 
            (modell != null && !modell.isEmpty()) || 
            (evjarat != null) || 
            (kilometerora != null) || 
            (ar != null) || 
            (statusz != null && !statusz.isEmpty())) {
            return autoDao.findAutos(marka, modell, evjarat, kilometerora, ar, statusz);
        } else {
            // Ha nincs megadva egyetlen param�ter sem, �res list�t adunk vissza
            return Collections.emptyList();
        }
    }
}
