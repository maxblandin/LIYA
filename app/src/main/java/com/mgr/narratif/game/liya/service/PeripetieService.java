package com.mgr.narratif.game.liya.service;


import com.mgr.narratif.game.liya.dao.PeripetieDAO;
import com.mgr.narratif.game.liya.model.Peripetie;

import java.util.List;

public class PeripetieService {
    private PeripetieDAO dao = new PeripetieDAO();

    public List<Peripetie> recupererPeripeties(String idPeripetie){
        return dao.getPeripeties(idPeripetie);
    }

    public Peripetie recupererPeripetie(String idPeripetie){
        return dao.getPeripetie(idPeripetie);
    }

    public Peripetie recupererPrologue(String idPeripetie){
        return dao.getPrologue(idPeripetie);
    }
}
