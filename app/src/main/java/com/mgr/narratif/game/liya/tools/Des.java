package com.mgr.narratif.game.liya.tools;

import com.mgr.narratif.game.liya.enumeration.EnumCritiqueDes;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Des {
    private int resultat;
    private EnumCritiqueDes type;

    public int getResultat() {
        return resultat;
    }
    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public EnumCritiqueDes getType() {
        return type;
    }
    public void setType(EnumCritiqueDes type) {
        this.type = type;
    }

    public Des(){}
    public Des(int resultat, EnumCritiqueDes type) {
        this.resultat = resultat;
        this.type = type;
    }
}
