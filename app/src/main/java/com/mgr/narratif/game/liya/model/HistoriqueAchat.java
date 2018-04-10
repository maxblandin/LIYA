package com.mgr.narratif.game.liya.model;

import java.util.Date;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class HistoriqueAchat {
    private String id;
    private Date dateAchat;
    private int nbPassePartout;
    private float prix;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Date getDateAchat() {
        return dateAchat;
    }
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getNbPassePartout() {
        return nbPassePartout;
    }
    public void setNbPassePartout(int nbPassePartout) {
        this.nbPassePartout = nbPassePartout;
    }

    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }

    public HistoriqueAchat() {}
    public HistoriqueAchat(String id, Date dateAchat, int nbPassePartout, float prix) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.nbPassePartout = nbPassePartout;
        this.prix = prix;
    }
}
