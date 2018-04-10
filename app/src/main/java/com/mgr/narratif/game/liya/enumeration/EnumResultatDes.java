package com.mgr.narratif.game.liya.enumeration;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public enum EnumResultatDes {
    AUCUN,
    REUSSITE,
    REUSSITE_CRITIQUE,
    ECHEC,
    ECHEC_CRITIQUE;

    public static String getStringEnumValeur(EnumResultatDes value){
        String retour = "";
        for (EnumResultatDes resultatDes : EnumResultatDes.values()) {
            if (resultatDes.name().equals(value.name())) {
                retour = resultatDes.name();
            }
        }

        return retour;
    }

    public static EnumResultatDes getEnumStringValeur(String valeur){
        EnumResultatDes retour  = null;
        for (EnumResultatDes resultatDes : EnumResultatDes.values()) {
            if (resultatDes.name().equals(valeur)) {
                retour = resultatDes;
            }
        }

        return retour;
    }
}
