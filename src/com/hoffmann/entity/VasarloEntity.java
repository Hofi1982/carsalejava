package com.hoffmann.entity;

public class VasarloEntity {
    private int id;
    private String nev;
    private String telefonszam;
    private String email;
    private int vasarlasokSzama;

    // Konstruktor
    public VasarloEntity(int id, String nev, String telefonszam, String email, int vasarlasokSzama) {
        this.id = id;
        this.nev = nev;
        this.telefonszam = telefonszam;
        this.email = email;
        this.vasarlasokSzama = vasarlasokSzama;
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

    public int getVasarlasokSzama() {
        return vasarlasokSzama;
    }

    public void setVasarlasokSzama(int vasarlasokSzama) {
        this.vasarlasokSzama = vasarlasokSzama;
    }
}
