package com.mgr.narratif.game.liya.model;

import com.mgr.narratif.game.liya.enumeration.EnumCritiqueDes;

import java.util.Map;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Action {
    private String id;
    private String libelle;
    private Map<Integer,String> suite;

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

    public Map<Integer, String> getSuite() {
        return suite;
    }
    public void setSuite(Map<Integer, String> suite) {
        this.suite = suite;
    }

    public Action() {}
    public Action(String id, String libelle, Map<Integer,String> suite) {
        this.id = id;
        this.libelle = libelle;
        this.suite = suite;
    }
}
