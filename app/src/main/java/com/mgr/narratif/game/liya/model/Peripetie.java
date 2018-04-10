package com.mgr.narratif.game.liya.model;

import java.util.List;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Peripetie {
    private String id;
    private String description;
    private boolean isPrologue;
    private List<Action> actions;
    private String idChapitre;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrologue() {
        return isPrologue;
    }
    public void setPrologue(boolean prologue) {
        isPrologue = prologue;
    }

    public List<Action> getActions() {
        return actions;
    }
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getIdChapitre() {
        return idChapitre;
    }
    public void setIdChapitre(String idChapitre) {
        this.idChapitre = idChapitre;
    }

    public Peripetie() {}
    public Peripetie(String id, String description, boolean isPrologue, List<Action> actions, String idChapitre) {
        this.id = id;
        this.description = description;
        this.isPrologue = isPrologue;
        this.actions = actions;
        this.idChapitre = idChapitre;
    }
}
