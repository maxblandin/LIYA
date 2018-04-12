package com.mgr.narratif.game.liya.model;

import java.util.List;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Peripetie {
    private String id;
    private String description;
    private boolean isPrologue;
    private boolean isFin;
    private String drawableImage;
    private List<Action> actions;

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

    public boolean isFin() {
        return isFin;
    }
    public void setFin(boolean fin) {
        isFin = fin;
    }

    public List<Action> getActions() {
        return actions;
    }
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getDrawableImage() {
        return drawableImage;
    }
    public void setDrawableImage(String drawableImage) {
        this.drawableImage = drawableImage;
    }

    public Peripetie() {}
    public Peripetie(String id, String description, boolean isPrologue, boolean isFin, List<Action> actions, String drawableImage) {
        this.id = id;
        this.description = description;
        this.isPrologue = isPrologue;
        this.isFin = isFin;
        this.actions = actions;
        this.drawableImage = drawableImage;
    }
}
