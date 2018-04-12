package com.mgr.narratif.game.liya.service;


import com.mgr.narratif.game.liya.dao.PeripetieDAO;
import com.mgr.narratif.game.liya.model.Peripetie;

import java.util.List;

public class PeripetieService {
    private PeripetieDAO dao = new PeripetieDAO();

    public List<Peripetie> recupererPeripeties(String idAventure){
        return dao.getPeripeties(idAventure);
    }

    public Peripetie recupererPeripetie(String idAventure,String idPeripetie){
        return dao.getPeripetie(idAventure,idPeripetie);
    }

    public Peripetie recupererPrologue(String idAventure){
        return dao.getPrologue(idAventure);
    }
}
