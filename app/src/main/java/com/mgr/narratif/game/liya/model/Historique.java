package com.mgr.narratif.game.liya.model;

import com.mgr.narratif.game.liya.enumeration.ResultatDes;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Historique {
    private String id;
    private String idAventure;
    private String idHeros;
    private String idPeripetie;
    private String idAction;
    private ResultatDes resultat;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdAventure() {
        return idAventure;
    }
    public void setIdAventure(String idAventure) {
        this.idAventure = idAventure;
    }

    public String getIdHeros() {
        return idHeros;
    }
    public void setIdHeros(String idHeros) {
        this.idHeros = idHeros;
    }

    public String getIdPeripetie() {
        return idPeripetie;
    }
    public void setIdPeripetie(String idPeripetie) {
        this.idPeripetie = idPeripetie;
    }

    public String getIdAction() {
        return idAction;
    }
    public void setIdAction(String idAction) {
        this.idAction = idAction;
    }

    public ResultatDes getResultat() {
        return resultat;
    }
    public void setResultat(ResultatDes resultat) {
        this.resultat = resultat;
    }

    public Historique() {}
    public Historique(String id, String idAventure, String idHeros, String idPeripetie, String idAction, ResultatDes resultat) {
        this.id = id;
        this.idAventure = idAventure;
        this.idHeros = idHeros;
        this.idPeripetie = idPeripetie;
        this.idAction = idAction;
        this.resultat = resultat;
    }
}
