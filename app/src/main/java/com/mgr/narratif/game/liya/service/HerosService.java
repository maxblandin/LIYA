package com.mgr.narratif.game.liya.service;

import com.mgr.narratif.game.liya.dao.HerosDAO;
import com.mgr.narratif.game.liya.model.Heros;

public class HerosService {

    private HerosDAO dao = new HerosDAO();

    public Heros recupererHeros(String idHeros) {
        return dao.getHeros(idHeros);
    }

}
