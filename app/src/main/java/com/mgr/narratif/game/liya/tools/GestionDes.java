package com.mgr.narratif.game.liya.tools;

import com.mgr.narratif.game.liya.dto.Des;
import com.mgr.narratif.game.liya.enumeration.EnumResultatDes;
import com.mgr.narratif.game.liya.enumeration.EnumFaceDes;

import java.util.Random;

public class GestionDes {
    // Score minimum possible au dés
    private final int MIN_DES = 1;

    public GestionDes() {}

    /*
    Réussite = lancer de des inférieur à la statistique du héros
    Echec = lancer de des supérieur à la statistique du héros
    Réussite critique = lancer de des inférieur au Taux de réussite critique (5% exemple sur un des 100 il faut un jet inférieeur ou égale à 5)
    Echec critique = lancer de des supérieur au Taux d'échec critique (5% exemple sur un des 100 il faut un jet supérieur ou égale à 96)
    * */
    public Des lancerDes(EnumFaceDes eDes, int valeurStatistique){
        Des des = new Des();

        Random rand = new Random();
        des.setResultat(rand.nextInt(eDes.getNbFaces() + MIN_DES));

        if(des.getResultat() >= eDes.getTauxReussiteCritique() && des.getResultat() <= valeurStatistique){
            des.setType(EnumResultatDes.REUSSITE);
        }
        else if(des.getResultat() <= eDes.getTauxEchecCritique() && des.getResultat() >= valeurStatistique){
            des.setType(EnumResultatDes.ECHEC);
        }
        else if (des.getResultat() <= eDes.getTauxReussiteCritique()) {
            des.setType(EnumResultatDes.REUSSITE_CRITIQUE);
        }
        else if (des.getResultat() >= eDes.getTauxEchecCritique()) {
            des.setType(EnumResultatDes.ECHEC_CRITIQUE);
        }

        return des;
    }
}
