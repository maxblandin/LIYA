package com.mgr.narratif.game.liya.dao;

import com.mgr.narratif.game.liya.enumeration.FaceDes;
import com.mgr.narratif.game.liya.enumeration.LibelleStat;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Peripetie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeripetieDAO {
    public List<Peripetie> getPeripeties(String idAventure){
        List<Peripetie> peripeties =new ArrayList<>();

        Map<ResultatDes,String> hm1 = new HashMap<>();
        Map<ResultatDes,String> hm2 = new HashMap<>();
        Map<ResultatDes,String> hm3 = new HashMap<>();
        Map<ResultatDes,String> hm4 = new HashMap<>();
        Map<ResultatDes,String> hm5 = new HashMap<>();
        Map<ResultatDes,String> hm6 = new HashMap<>();
        Map<ResultatDes,String> hm7 = new HashMap<>();
        Map<ResultatDes,String> hm8 = new HashMap<>();
        Map<ResultatDes,String> hm9 = new HashMap<>();
        Map<ResultatDes,String> hm10 = new HashMap<>();
        Map<ResultatDes,String> hm11= new HashMap<>();

        hm1.put(ResultatDes.AUCUN,"peri2");
        hm2.put(ResultatDes.AUCUN,"peri3");
        hm3.put(ResultatDes.AUCUN,"peri4");

        List<Action> actions1 = new ArrayList<>();
        Action a1 = new Action("ac1", "Se rendre à Ogrimmar", false,null, hm1, null);
        Action a2 = new Action("ac2","Se rendre à Hurlevent", false,null, hm2, null);
        Action a3 = new Action("ac3","S'isoler dans la montagne", false, null,hm3, null);

        actions1.add(a1);
        actions1.add(a2);
        actions1.add(a3);

        Peripetie peri01 = new Peripetie("peri1",
                "Exilé de vos terre en quête de vengeance vous décidez de prendre la direction de ...",
                true,
                false,
                actions1,
                "paysage1.jpg");

        hm4.put(ResultatDes.REUSSITE,"peri5");
        hm4.put(ResultatDes.ECHEC,"peri6");
        hm5.put(ResultatDes.REUSSITE,"peri7");
        hm5.put(ResultatDes.ECHEC,"peri6");

        List<Action> actions2 = new ArrayList<>();
        Action a4 = new Action("ac4","Négocier avec le garde", true, LibelleStat.SOCIAL, hm4, FaceDes.FACE100);
        Action a6 = new Action("ac6","Tuer le garde", true,LibelleStat.PHYSIQUE, hm5, FaceDes.FACE100);

        actions2.add(a4);
        actions2.add(a6);

        Peripetie peri02 = new Peripetie("peri2",
                "Arrivez devant Orgrimmar, la porte d'entrée est gardé par un garde ...",
                false,false,actions2, "paysage1.jpg");

        Peripetie peri05 = new Peripetie("peri5",
                "Le garde convaincu par votre discours vous ouvre la porte, vous rentrez dans la ville !",
                false,false,null, "paysage1.jpg");

        Peripetie peri06 = new Peripetie("peri6",
                "Votre coup n'atteind pas le garde et il vous tue ... GAME OVER !",
                false,false,null, "paysage1.jpg");

        Peripetie peri07 = new Peripetie("peri7",
                "Le garde mort, vous rentrez dans la ville !",
                false,false,null, "paysage1.jpg");

        Peripetie peri03 = new Peripetie("peri3",
                "Arrivez devant Hurlevent, la porte d'entrée est gardé par un garde ...",
                false,false, actions2, "paysage1.jpg");

        hm6.put(ResultatDes.REUSSITE,"peri8");
        hm6.put(ResultatDes.ECHEC,"peri9");
        hm6.put(ResultatDes.REUSSITE_CRITIQUE,"peri10");
        hm6.put(ResultatDes.ECHEC_CRITIQUE,"peri11");

        List<Action> actions3 = new ArrayList<>();
        Action a8 = new Action("a8","Gravir la montage", true,LibelleStat.PHYSIQUE, hm6, FaceDes.FACE100);

        actions3.add(a8);

        Peripetie peri04 = new Peripetie("peri4",
                "Vous essayer de gravir la montage ...",
                false, false,actions3, "paysage1.jpg");

        Peripetie peri08 = new Peripetie("peri8",
                "Vous gravissez la montage avec réussite !",
                false, true,actions3, "paysage1.jpg");

        Peripetie peri09 = new Peripetie("peri9",
                "Vous n'arrivez pas a vous hissez en haut de la montage, vous allez passer la nuit en bas ! ",
                false, true,actions3, "paysage1.jpg");

        Peripetie peri10 = new Peripetie("peri10",
                "Vous êtes un véritable accrobate ! En haut en 10sec",
                false, true,actions3, "paysage1.jpg");

        Peripetie peri11 = new Peripetie("peri11",
                "Vous faites une lourde chute et mourrez ... GAME OVER",
                false, true,actions3, "paysage1.jpg");

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

        return peripeties;
    }

    public Peripetie getPrologue(String idAventure){
        List<Peripetie> peripeties = getPeripeties(idAventure);
        Peripetie peripetie = null;

        for(Peripetie p : peripeties){
            if(p.isPrologue()){
                peripetie = p;
            }
        }

        return peripetie;
    }

    public Peripetie getPeripetie(String idPeripetie){
        List<Peripetie> peripeties = getPeripeties(null);
        Peripetie peripetie = null;

        for(Peripetie p : peripeties){
            if(p.getId().equals(idPeripetie)){
                peripetie = p;
            }
        }

        return peripetie;
    }
}
