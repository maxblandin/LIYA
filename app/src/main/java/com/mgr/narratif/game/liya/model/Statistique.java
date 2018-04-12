package com.mgr.narratif.game.liya.model;

import com.mgr.narratif.game.liya.enumeration.LibelleStat;

public class Statistique {
    private String id;
    private LibelleStat libelle;
    private int pourcentage;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public LibelleStat getLibelle() {
        return libelle;
    }
    public void setLibelle(LibelleStat libelle) {
        this.libelle = libelle;
    }

    public int getPourcentage() {
        return pourcentage;
    }
    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Statistique() {}
    public Statistique(String id, LibelleStat libelle, int pourcentage) {
        this.id = id;
        this.libelle = libelle;
        this.pourcentage = pourcentage;
    }
}
