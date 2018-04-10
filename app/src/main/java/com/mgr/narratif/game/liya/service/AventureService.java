package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.dao.AventureDAO;
import com.mgr.narratif.game.liya.model.Aventure;

public class AventureService {

    AventureDAO dao = new AventureDAO();

    public Aventure recupererAventure(){
        return dao.getJeuxDeTest();
    }
}
