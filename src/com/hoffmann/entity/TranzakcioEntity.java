package com.hoffmann.entity;

import java.sql.Date;

public class TranzakcioEntity {
    private int tranzakcioId;
    private int autoId;
    private int eladoId;
    private int vasarloId;
    private Date tranzakcioDatuma;
    private double tranzakcioOsszege;

    // Konstruktor
    public TranzakcioEntity(int tranzakcioId, int autoId, int eladoId, int vasarloId, Date tranzakcioDatuma, double tranzakcioOsszege) {
        this.tranzakcioId = tranzakcioId;
        this.autoId = autoId;
        this.eladoId = eladoId;
        this.vasarloId = vasarloId;
        this.tranzakcioDatuma = tranzakcioDatuma;
        this.tranzakcioOsszege = tranzakcioOsszege;
    }

    // Getterek és Setterek
    public int getTranzakcioId() {
        return tranzakcioId;
    }

    public void setTranzakcioId(int tranzakcioId) {
        this.tranzakcioId = tranzakcioId;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getEladoId() {
        return eladoId;
    }

    public void setEladoId(int eladoId) {
        this.eladoId = eladoId;
    }

    public int getVasarloId() {
        return vasarloId;
    }

    public void setVasarloId(int vasarloId) {
        this.vasarloId = vasarloId;
    }

    public Date getTranzakcioDatuma() {
        return tranzakcioDatuma;
    }

    public void setTranzakcioDatuma(Date tranzakcioDatuma) {
        this.tranzakcioDatuma = tranzakcioDatuma;
    }

    public double getTranzakcioOsszege() {
        return tranzakcioOsszege;
    }

    public void setTranzakcioOsszege(double tranzakcioOsszege) {
        this.tranzakcioOsszege = tranzakcioOsszege;
    }
}
