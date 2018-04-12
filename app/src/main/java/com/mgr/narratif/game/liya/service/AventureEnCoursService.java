package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.dao.AventureEnCoursDAO;
import com.mgr.narratif.game.liya.model.AventureEnCours;

import java.util.List;

public class AventureEnCoursService {

    private AventureEnCoursDAO dao = AventureEnCoursDAO.getInstance();

    public AventureEnCoursService() {
    }

    public List<AventureEnCours> recupererAventuresEnCours() {
        return dao.getAventuresEnCours();
    }

    public AventureEnCours recupererAventureEnCours(String idAventure) {
        return dao.getAventureEnCours(idAventure);
    }

    public void commencerAventure(String idAventure, String idPeripetie, String idHeros) {
        dao.addAventure(idAventure, idPeripetie, idHeros);
    }

    public void arreterAventure(String idAventure) {
        dao.removeAventure(idAventure);
    }

    public void continuerAventure(String idAventure, String idPeripetie) {
        dao.updateAventure(idAventure, idPeripetie);
    }

}
