package com.mgr.narratif.game.liya.enumeration;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public enum ResultatDes {
    AUCUN(0),
    REUSSITE(1),
    REUSSITE_CRITIQUE(2),
    ECHEC(3),
    ECHEC_CRITIQUE(4);

    private int resultat;
    private ResultatDes(int resultat){
        this.resultat = resultat;
    }

    public int getResultat(){
        return resultat;
    }

    public static String getStringEnumValeur(ResultatDes value){
        String retour = "";
        for (ResultatDes resultatDes : ResultatDes.values()) {
            if (resultatDes.name().equals(value.name())) {
                retour = resultatDes.name();
            }
        }

        return retour;
    }

    public static ResultatDes getEnumStringValeur(String valeur){
        ResultatDes retour  = null;
        for (ResultatDes resultatDes : ResultatDes.values()) {
            if (resultatDes.name().equals(valeur)) {
                retour = resultatDes;
            }
        }

        return retour;
    }
}
