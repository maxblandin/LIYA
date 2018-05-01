package com.mgr.narratif.game.liya.model;

public class BonusBoutique {
    private String id;
    private String offre;
    private float prix;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getOffre() {
        return offre;
    }
    public void setOffre(String offre) {
        this.offre = offre;
    }

    public BonusBoutique() {
    }
    public BonusBoutique(String id, String offre,float prix) {
        this.id = id;
        this.offre = offre;
        this.prix = prix;
    }
}

