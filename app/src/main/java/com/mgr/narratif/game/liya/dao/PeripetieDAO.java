package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.model.Peripetie;

import java.util.List;

public class PeripetieDAO {
    private static final PeripetieDAO ourInstance = new PeripetieDAO();

    public static PeripetieDAO getInstance() {
        return ourInstance;
    }

    private PeripetieDAO() {
    }

    public List<Peripetie> getPeripeties(String idAventure) {
        AventureDAO aventureDAO = AventureDAO.getInstance();
        return aventureDAO.getAventure(idAventure).getPeripeties();
    }

    public Peripetie getPrologue(String idAventure) {
        AventureDAO aventureDAO = AventureDAO.getInstance();
        Peripetie retour = null;

        for (Peripetie p : aventureDAO.getAventure(idAventure).getPeripeties()) {
            if (p.isPrologue()) {
                retour = p;
                break;
            }
        }

        return retour;
    }

    public Peripetie getPeripetie(String idPeripetie) {
        String idAventure = idPeripetie.substring(0,4);
        AventureDAO aventureDAO = AventureDAO.getInstance();
        Peripetie retour = null;

        for (Peripetie p : aventureDAO.getAventure(idAventure).getPeripeties()) {
            if (p.getId().equals(idPeripetie)) {
                retour = p;
                break;
            }
        }

        return retour;
    }

}
