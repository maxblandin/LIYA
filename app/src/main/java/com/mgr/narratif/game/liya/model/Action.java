package com.mgr.narratif.game.liya.model;

import com.mgr.narratif.game.liya.enumeration.EnumCritiqueDes;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Action {
    private String id;
    private String libelle;
    private EnumCritiqueDes resultatDes;
    private String idPeripetieSuivante;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public EnumCritiqueDes getResultatDes() {
        return resultatDes;
    }
    public void setResultatDes(EnumCritiqueDes resultatDes) {
        this.resultatDes = resultatDes;
    }

    public String getIdPeripetieSuivante() {
        return idPeripetieSuivante;
    }
    public void setIdPeripetieSuivante(String idPeripetieSuivante) {
        this.idPeripetieSuivante = idPeripetieSuivante;
    }

    public Action() {}
    public Action(String id, String libelle, EnumCritiqueDes resultatDes, String idPeripetieSuivante) {
        this.id = id;
        this.libelle = libelle;
        this.resultatDes = resultatDes;
        this.idPeripetieSuivante = idPeripetieSuivante;
    }
}
