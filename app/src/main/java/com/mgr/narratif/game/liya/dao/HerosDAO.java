package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.enumeration.ClasseHeros;
import com.mgr.narratif.game.liya.enumeration.LibelleStat;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Statistique;

import java.util.ArrayList;
import java.util.List;

public class HerosDAO {

    public Heros getHeros(String idHeros) {
        List<Statistique> statistiques3 = new ArrayList<>();

        Statistique s7 = new Statistique("stat1", LibelleStat.PHYSIQUE,60);
        Statistique s8 = new Statistique("stat1", LibelleStat.MENTAL,60);
        Statistique s9 = new Statistique("stat1", LibelleStat.SOCIAL,30);

        statistiques3.add(s7);
        statistiques3.add(s8);
        statistiques3.add(s9);

        return new Heros("h3","Vol'jin","Chef de la horde, expluser après une rebelion", ClasseHeros.LUTIN,statistiques3);
    }
}
