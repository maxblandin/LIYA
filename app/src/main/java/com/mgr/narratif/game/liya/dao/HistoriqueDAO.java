package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Historique;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by rbonhomme2016 on 13/04/2018.
 */

public class HistoriqueDAO {
    private static final HistoriqueDAO ourInstance = new HistoriqueDAO();
    private List<Historique> historiques = new ArrayList<>();

    public static HistoriqueDAO getInstance() {
        return ourInstance;
    }

    private HistoriqueDAO() {
    }

    public void addHistorique(String idAventure, String idHeros, String idPeripetie, String idAction, ResultatDes resultat) {
        Historique historique = new Historique(UUID.randomUUID().toString(), idAventure, idHeros, idPeripetie, idAction, resultat);
        historiques.add(historique);
    }

    public List<Historique> getHistoriques() {
        return historiques;
    }

    public List<Historique> getHistoriqueAventure(String idAventure, String idHeros) {
        List<Historique> retour = null;

        for (Historique h : historiques) {
            if (h.getIdAventure().equals(idAventure) && h.getIdHeros().equals(idHeros)) {
                retour.add(h);
            }
        }

        return retour;
    }

    public Historique getHistorique(String idAventure, String idPeripetie, String idHeros) {
        Historique retour = null;

        for (Historique h : historiques) {
            if (h.getIdAventure().equals(idAventure) &&
                    h.getIdPeripetie().equals(idPeripetie) &&
                    h.getIdHeros().equals(idHeros)) {
                retour = h;
            }
        }

        return retour;
    }
}
