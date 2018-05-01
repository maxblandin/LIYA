package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.dao.BonusBoutiqueDAO;
import com.mgr.narratif.game.liya.model.BonusBoutique;

import java.util.List;

public class BonusBoutiqueService {
    BonusBoutiqueDAO dao = new BonusBoutiqueDAO();

    public List<BonusBoutique> recupererBonus(){
        return  dao.getAll();
    }


}
