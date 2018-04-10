package com.mgr.narratif.game.liya.model;

import java.util.List;

public class Aventure {
    private String id;
    private String nom;
    private String intrigue;
    private List<Peripetie> peripeties;
    private List<Heros> heros;
    private boolean isCommencer;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIntrigue() {
        return intrigue;
    }
    public void setIntrigue(String intrigue) {
        this.intrigue = intrigue;
    }

    public List<Peripetie> getPeripeties() {
        return peripeties;
    }
    public void setPeripeties(List<Peripetie> peripeties) {
        this.peripeties = peripeties;
    }

    public List<Heros> getHeros() {
        return heros;
    }
    public void setHeros(List<Heros> heros) {
        this.heros = heros;
    }

    public boolean isCommencer() {
        return isCommencer;
    }
    public void setCommencer(boolean commencer) {
        isCommencer = commencer;
    }

    public Aventure() {}
    public Aventure(String id, String nom, String intrigue, List<Peripetie> peripeties, List<Heros> heros, boolean isCommencer) {
        this.id = id;
        this.nom = nom;
        this.intrigue = intrigue;
        this.peripeties = peripeties;
        this.heros = heros;
        this.isCommencer = isCommencer;
    }
}
