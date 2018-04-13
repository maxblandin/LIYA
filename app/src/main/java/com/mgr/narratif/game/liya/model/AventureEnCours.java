package com.mgr.narratif.game.liya.model;

public class AventureEnCours {
    private String idAventure;
    private String idPeripetie;
    private String idHeros;

    public String getIdAventure() {
        return idAventure;
    }
    public void setIdAventure(String idAventure) {
        this.idAventure = idAventure;
    }

    public String getIdPeripetie() {
        return idPeripetie;
    }
    public void setIdPeripetie(String idPeripetie) {
        this.idPeripetie = idPeripetie;
    }

    public String getIdHeros() {
        return idHeros;
    }
    public void setIdHeros(String idHeros) {
        this.idHeros = idHeros;
    }

    public AventureEnCours() {}
    public AventureEnCours(String idAventure, String idPeripetie, String idHeros) {
        this.idAventure = idAventure;
        this.idPeripetie = idPeripetie;
        this.idHeros = idHeros;
    }
}
