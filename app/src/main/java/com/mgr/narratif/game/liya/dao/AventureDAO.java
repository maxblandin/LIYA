package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.model.Aventure;

import java.util.ArrayList;
import java.util.List;

public class AventureDAO {
    private static final AventureDAO ourInstance = new AventureDAO();
    private List<Aventure> aventures = new ArrayList<>();

    public static AventureDAO getInstance() {
        return ourInstance;
    }

    private AventureDAO() {
    }

    public List<Aventure> getAventures() {
        return this.aventures;
    }

    public Aventure getAventure(String idAventure) {
        Aventure retour = null;

        for (Aventure a : aventures) {
            if (a.getId().equals(idAventure)) {
                retour = a;
                break;
            }
        }

        return retour;
    }

    public void addAventure(Aventure aventure) {
        aventures.add(aventure);
    }

    public void removeAventure(String idAventure) {
        for (Aventure a : aventures) {
            if (a.getId().equals(idAventure)) {
                aventures.remove(a);
                break;
            }
        }
    }

    public void updateAventure(Aventure aventure) {
        for (Aventure a : aventures) {
            if (a.getId().equals(aventure.getId())) {
                aventures.add(aventure);
                removeAventure(a.getId());
                break;
            }
        }
    }

}
