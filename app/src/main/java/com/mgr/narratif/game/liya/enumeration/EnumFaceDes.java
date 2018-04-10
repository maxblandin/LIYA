package com.mgr.narratif.game.liya.enumeration;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public enum EnumFaceDes {
    FACE6(6, 1, 5),
    FACE100(100, 5, 96);

    private int nbFaces;
    private int tauxReussiteCritique;
    private int tauxEchecCritique;

    private EnumFaceDes(int nbFaces, int txReuCrit, int txEcCrit) {
        this.nbFaces = nbFaces;
        this.tauxReussiteCritique = txReuCrit;
        this.tauxEchecCritique = txEcCrit;
    }

    public int getNbFaces() {
        return nbFaces;
    }

    public int getTauxReussiteCritique() {
        return tauxReussiteCritique;
    }

    public int getTauxEchecCritique() {
        return tauxEchecCritique;
    }
}
