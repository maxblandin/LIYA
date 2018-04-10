package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.enumeration.ClasseHeros;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.model.Statistique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AventureDAO {

    public Aventure getJeuxDeTest(){
        Statistique statistique = new Statistique("stat1",65,45,50);

        List<Heros> lstHeros = new ArrayList<>();
        Heros h1= new Heros("h1","Garrosh","Ancien chef guerrier de la horde, maintenant chasser de ces terre.", ClasseHeros.LUTIN,statistique);
        Heros h2 = new Heros("h2","Trall","Ancien chef chaman de la horde, maintenant chasser de ces terre.", ClasseHeros.LUTIN,statistique);
        Heros h3 = new Heros("h3","Vol'jin","Chef de la horde, expluser après une rebelion", ClasseHeros.LUTIN,statistique);

        lstHeros.add(h1);
        lstHeros.add(h2);
        lstHeros.add(h3);

        List<Peripetie> peripeties =new ArrayList<>();

        Map<Integer,String> hm1 = new HashMap<>();
        Map<Integer,String> hm2 = new HashMap<>();
        Map<Integer,String> hm3 = new HashMap<>();
        Map<Integer,String> hm4 = new HashMap<>();
        Map<Integer,String> hm5 = new HashMap<>();
        Map<Integer,String> hm6 = new HashMap<>();
        Map<Integer,String> hm7 = new HashMap<>();
        Map<Integer,String> hm8 = new HashMap<>();
        Map<Integer,String> hm9 = new HashMap<>();
        Map<Integer,String> hm10 = new HashMap<>();
        Map<Integer,String> hm11= new HashMap<>();

        hm1.put(ResultatDes.AUCUN.getResultat(),"peri02");
        hm2.put(ResultatDes.AUCUN.getResultat(),"peri03");
        hm3.put(ResultatDes.AUCUN.getResultat(),"peri04");

        List<Action> actions1 = new ArrayList<>();
        Action a1 = new Action("ac1", "Se rendre à Ogrimmar",hm1 );
        Action a2 = new Action("ac2","Se rendre à Hurlevent", hm2);
        Action a3 = new Action("ac3","S'isoler dans la montagne", hm3);

        Peripetie peri01 = new Peripetie("peri1",
                "Exilé de vos terre en quête de vengeance vous décidez de prendre la direction de ...",
                true,
                actions1);

        hm4.put(ResultatDes.REUSSITE.getResultat(),"peri5");
        hm5.put(ResultatDes.ECHEC.getResultat(),"peri6");
        hm6.put(ResultatDes.REUSSITE.getResultat(),"peri7");
        hm7.put(ResultatDes.ECHEC.getResultat(),"peri6");

        List<Action> actions2 = new ArrayList<>();
        Action a4 = new Action("ac4","Négocier avec le garde", hm4);
        Action a5 = new Action("ac5","Négocier avec le garde", hm5);
        Action a6 = new Action("ac6","Tuer le garde", hm6);
        Action a7 = new Action("ac7","Tuer le garde", hm7);

        Peripetie peri02 = new Peripetie("peri2",
                "Arrivez devant Orgrimmar, la porte d'entrée est gardé par un garde ...",
                true,actions2);

        Peripetie peri05 = new Peripetie("peri5",
                "Le garde convaincu par votre discours vous ouvre la porte, vous rentrez dans la ville !",
                true,null);

        Peripetie peri06 = new Peripetie("peri6",
                "Votre coup n'atteind pas le garde et il vous tue ... GAME OVER !",
                true,null);

        Peripetie peri07 = new Peripetie("peri7",
                "Le garde mort, vous rentrez dans la ville !",
                true,null);

        Peripetie peri03 = new Peripetie("peri3",
                "Arrivez devant Hurlevent, la porte d'entrée est gardé par un garde ...",
                true, actions2);

        hm8.put(ResultatDes.REUSSITE.getResultat(),"peri8");
        hm9.put(ResultatDes.ECHEC.getResultat(),"peri9");
        hm10.put(ResultatDes.REUSSITE_CRITIQUE.getResultat(),"peri10");
        hm11.put(ResultatDes.ECHEC_CRITIQUE.getResultat(),"peri11");

        List<Action> actions3 = new ArrayList<>();
        Action a8 = new Action("a8","Gravir la montage", hm8);
        Action a9 = new Action("a9","Gravir", hm9);
        Action a10 = new Action("a10","Gravir", hm10);
        Action a11 = new Action("a11","Gravir", hm11);

        Peripetie peri04 = new Peripetie("peri4",
                "Vous essayer de gravir la montage ...",
                true, actions3);

        Peripetie peri08 = new Peripetie("peri8",
                "Vous gravissez la montage avec réussite !",
                true, actions3);

        Peripetie peri09 = new Peripetie("peri9",
                "Vous n'arrivez pas a vous hissez en haut de la montage, vous allez passer la nuit en bas ! ",
                true, actions3);

        Peripetie peri10 = new Peripetie("peri10",
                "Vous êtes un véritable accrobate ! En haut en 10sec",
                true, actions3);

        Peripetie peri11 = new Peripetie("peri04",
                "Vous faites une lourde chute et mourrez ... GAME OVER",
                true, actions3);

        peripeties.add(peri01);
        peripeties.add(peri02);
        peripeties.add(peri03);
        peripeties.add(peri04);
        peripeties.add(peri05);
        peripeties.add(peri06);
        peripeties.add(peri07);
        peripeties.add(peri08);
        peripeties.add(peri09);
        peripeties.add(peri10);
        peripeties.add(peri11);

        Aventure aventure = new Aventure("av1","L'histoire de test","C'est le récit d'une histoire créer uniquement pour le test !",
                peripeties,lstHeros,false);

        return aventure;
    }
}
