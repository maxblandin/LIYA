package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.dao.AventureDAO;
import com.mgr.narratif.game.liya.model.Aventure;

import java.util.List;

public class AventureService {

    AventureDAO dao = new AventureDAO();

    public List<Aventure> recupererAventures(){
        return dao.getJeuxDeTest();
    }
}
