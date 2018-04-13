package com.mgr.narratif.game.liya.model;

import com.mgr.narratif.game.liya.enumeration.FaceDes;
import com.mgr.narratif.game.liya.enumeration.LibelleStat;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;

import java.util.Map;

public class Action {
    private String id;
    private String libelle;
    private boolean isLancerDes;
    private LibelleStat statistique;
    private Map<ResultatDes,String> suite;
    private FaceDes de;

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

    public Map<ResultatDes, String> getSuite() {
        return suite;
    }
    public void setSuite(Map<ResultatDes, String> suite) {
        this.suite = suite;
    }

    public boolean isLancerDes() {
        return isLancerDes;
    }
    public void setLancerDes(boolean lancerDes) {
        isLancerDes = lancerDes;
    }

    public LibelleStat getStatistique() {
        return statistique;
    }
    public void setStatistique(LibelleStat statistique) {
        this.statistique = statistique;
    }

    public FaceDes getDe() {
        return de;
    }
    public void setDe(FaceDes de) {
        this.de = de;
    }

    public Action() {}
    public Action(String id, String libelle, boolean isLancerDes, LibelleStat statistique, Map<ResultatDes,String> suite, FaceDes de) {
        this.id = id;
        this.libelle = libelle;
        this.isLancerDes = isLancerDes;
        this.statistique = statistique;
        this.suite = suite;
        this.de = de;
    }
}
