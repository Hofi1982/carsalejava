package com.hoffmann.entity;

public class EladoEntity {
    private int id;
    private String nev;
    private String beosztas;
    private String telefonszam;
    private String email;

    // Konstruktor
    public EladoEntity(int id, String nev, String beosztas, String telefonszam, String email) {
        this.id = id;
        this.nev = nev;
        this.beosztas = beosztas;
        this.telefonszam = telefonszam;
        this.email = email;
    }

    // Getterek és Setterek
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getBeosztas() {
        return beosztas;
    }

    public void setBeosztas(String beosztas) {
        this.beosztas = beosztas;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
