package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.model.BonusBoutique;

import java.util.ArrayList;
import java.util.List;

public class BonusBoutiqueDAO {
    public List<BonusBoutique> getAll(){
        List<BonusBoutique> lst = new ArrayList<>();

        BonusBoutique bonus1 = new BonusBoutique("1","1 Passe partout",1f);
        BonusBoutique bonus2 = new BonusBoutique("2","5 Passe partout",4f);
        BonusBoutique bonus3 = new BonusBoutique("3","10 Passe partout",8f);

        lst.add(bonus1);
        lst.add(bonus2);
        lst.add(bonus3);

        return lst;
    }
}
