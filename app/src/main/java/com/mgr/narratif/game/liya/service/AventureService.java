package com.mgr.narratif.game.liya.service;

import android.os.StrictMode;

import com.mgr.narratif.game.liya.dao.AventureDAO;
import com.mgr.narratif.game.liya.model.Aventure;

import java.util.List;

public class AventureService {

    private AventureDAO dao = new AventureDAO();

    public List<Aventure> recupererAventures(){
        return dao.getJeuxDeTest();
    }
    public Aventure recupererAventure(String idAventure){
        return dao.getAventure(idAventure);
    }
}
