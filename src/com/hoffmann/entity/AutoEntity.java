package com.hoffmann.entity;

public class AutoEntity {
    private int id;
    private String marka;
    private String modell;
    private int evjarat;
    private int kilometerora;
    private double ar;
    private String statusz;

    // Konstruktor
    public AutoEntity(int id, String marka, String modell, int evjarat, int kilometerora, double ar, String statusz) {
        this.id = id;
        this.marka = marka;
        this.modell = modell;
        this.evjarat = evjarat;
        this.kilometerora = kilometerora;
        this.ar = ar;
        this.statusz = statusz;
    }

    // Getterek és Setterek
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(int evjarat) {
        this.evjarat = evjarat;
    }

    public int getKilometerora() {
        return kilometerora;
    }

    public void setKilometerora(int kilometerora) {
        this.kilometerora = kilometerora;
    }

    public double getAr() {
        return ar;
    }

    public void setAr(double ar) {
        this.ar = ar;
    }

    public String getStatusz() {
        return statusz;
    }

    public void setStatusz(String statusz) {
        this.statusz = statusz;
    }
}
