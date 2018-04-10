package com.mgr.narratif.game.liya.dto;

import com.mgr.narratif.game.liya.enumeration.ResultatDes;

public class Des {
    private int resultat;
    private ResultatDes type;

    public int getResultat() {
        return resultat;
    }
    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public ResultatDes getType() {
        return type;
    }
    public void setType(ResultatDes type) {
        this.type = type;
    }

    public Des(){}
    public Des(int resultat, ResultatDes type) {
        this.resultat = resultat;
        this.type = type;
    }
}
