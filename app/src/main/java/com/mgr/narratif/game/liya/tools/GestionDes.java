package com.mgr.narratif.game.liya.tools;

import com.mgr.narratif.game.liya.enumeration.EnumCritiqueDes;
import com.mgr.narratif.game.liya.enumeration.EnumDes;

import java.util.Random;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class GestionDes {
    // Score minimum possible au dés
    private final int MIN_DES = 1;

    public GestionDes() {
    }

    public Des lancerDes(EnumDes eDes){
        Des des = new Des();

        Random rand = new Random();
        des.setResultat(rand.nextInt(eDes.getNbFaces() + MIN_DES));

        if (des.getResultat() <= eDes.getTauxReussiteCritique()) {
            des.setType(EnumCritiqueDes.REUSSITE_CRITIQUE);
        } else if (des.getResultat() >= eDes.getTauxEchecCritique()) {
            des.setType(EnumCritiqueDes.ECHEC_CRITIQUE);
        } else {
            des.setType(EnumCritiqueDes.NORMAL);
        }

        return des;
    }
}
