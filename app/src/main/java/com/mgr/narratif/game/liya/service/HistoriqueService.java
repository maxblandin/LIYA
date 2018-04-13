package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.dao.HistoriqueDAO;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Historique;

import java.util.List;

/**
 * Created by rbonhomme2016 on 13/04/2018.
 */

public class HistoriqueService {

    private HistoriqueDAO dao = HistoriqueDAO.getInstance();

    public List<Historique> recupererHistoriques() {
        return dao.getHistoriques();
    }

    public List<Historique> recupererHistoriqueAventure(String idAventure, String idHeros) {
        return dao.getHistoriqueAventure(idAventure, idHeros);
    }

    public void ajouterHistorique(String idAventure, String idHeros, String idPeripetie, String idAction, ResultatDes resultat) {
        dao.addHistorique(idAventure, idHeros, idPeripetie, idAction, resultat);
    }

    public Historique recupererHistorique(String idAventure, String idPeripetie, String idHeros) {
        return dao.getHistorique(idAventure, idPeripetie, idHeros);
    }

}
