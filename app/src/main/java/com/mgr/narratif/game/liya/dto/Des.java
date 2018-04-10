package com.mgr.narratif.game.liya.dto;

import com.mgr.narratif.game.liya.enumeration.EnumResultatDes;

public class Des {
    private int resultat;
    private EnumResultatDes type;

    public int getResultat() {
        return resultat;
    }
    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public EnumResultatDes getType() {
        return type;
    }
    public void setType(EnumResultatDes type) {
        this.type = type;
    }

    public Des(){}
    public Des(int resultat, EnumResultatDes type) {
        this.resultat = resultat;
        this.type = type;
    }
}
