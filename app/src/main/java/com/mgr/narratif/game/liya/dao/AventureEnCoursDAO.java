package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.model.AventureEnCours;

import java.util.ArrayList;
import java.util.List;

public class AventureEnCoursDAO {
    private static final AventureEnCoursDAO ourInstance = new AventureEnCoursDAO();
    private List<AventureEnCours> aventuresEnCours = new ArrayList<>();

    public static AventureEnCoursDAO getInstance() {
        return ourInstance;
    }

    private AventureEnCoursDAO() {
    }

    public List<AventureEnCours> getAventuresEnCours() {
        return aventuresEnCours;
    }

    public AventureEnCours getAventureEnCours(String idAventure) {
        AventureEnCours aventureEnCours = null;

        for (AventureEnCours aec : aventuresEnCours) {
            if (aec.getIdAventure().equals(idAventure)) {
                aventureEnCours = aec;
                break;
            }
        }

        if (aventureEnCours == null) {
            aventureEnCours = new AventureEnCours("av1", "peri1", "h3");
        }

        return aventureEnCours;
    }

    public void addAventure(String idAventure, String idPeripetie, String idHeros) {
        aventuresEnCours.add(new AventureEnCours(idAventure, idPeripetie, idHeros));
    }

    public void removeAventure(String idAventure) {
        aventuresEnCours.remove(getAventureEnCours(idAventure));
    }

    public void updateAventure(String idAventure, String idPeripetie) {
        int compteur = 0;
        for (AventureEnCours aec : aventuresEnCours) {
            if (aec.getIdAventure().equals(idAventure)) {
                aventuresEnCours.get(compteur).setIdPeripetie(idPeripetie);
                break;
            } else {
                compteur++;
            }
        }
    }
}
