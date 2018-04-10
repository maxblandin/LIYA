package com.mgr.narratif.game.liya.enumeration;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public enum EnumCritiqueDes {
    REUSSITE_CRITIQUE,
    ECHEC_CRITIQUE,
    NORMAL;

    public static String getStringEnumValeur(EnumCritiqueDes value){
        String retour = "";
        for (EnumCritiqueDes resultatDes : EnumCritiqueDes.values()) {
            if (resultatDes.name().equals(value.name())) {
                retour = resultatDes.name();
            }
        }

        return retour;
    }

    public static EnumCritiqueDes getEnumStringValeur(String valeur){
        EnumCritiqueDes retour  = null;
        for (EnumCritiqueDes resultatDes : EnumCritiqueDes.values()) {
            if (resultatDes.name().equals(valeur)) {
                retour = resultatDes;
            }
        }

        return retour;
    }
}
