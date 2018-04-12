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

    public List<Aventure> getJeuxDeTest(){
        List<Aventure> aventures = new ArrayList<>();
        Statistique s1 = new Statistique("stat1",65,45,50);
        Statistique s2 = new Statistique("stat1",45,60,60);
        Statistique s3 = new Statistique("stat1",55,30,40);

        List<Heros> lstHeros = new ArrayList<>();
        Heros h1= new Heros("h1","Garrosh","Ancien chef guerrier de la horde, maintenant chasser de ces terre.", ClasseHeros.LUTIN,s1);
        Heros h2 = new Heros("h2","Trall","Ancien chef chaman de la horde, maintenant chasser de ces terre.", ClasseHeros.LUTIN,s2);
        Heros h3 = new Heros("h3","Vol'jin","Chef de la horde, expluser après une rebelion", ClasseHeros.LUTIN,s3);

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

        actions1.add(a1);
        actions1.add(a2);
        actions1.add(a3);

        Peripetie peri01 = new Peripetie("peri1",
                "Exilé de vos terre en quête de vengeance vous décidez de prendre la direction de ...",
                true,
                false,
                false,
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

        actions2.add(a4);
        actions2.add(a5);
        actions2.add(a6);
        actions2.add(a7);

        Peripetie peri02 = new Peripetie("peri2",
                "Arrivez devant Orgrimmar, la porte d'entrée est gardé par un garde ...",
                false,false,true,actions2);

        Peripetie peri05 = new Peripetie("peri5",
                "Le garde convaincu par votre discours vous ouvre la porte, vous rentrez dans la ville !",
                false,false,false,null);

        Peripetie peri06 = new Peripetie("peri6",
                "Votre coup n'atteind pas le garde et il vous tue ... GAME OVER !",
                false,false,false,null);

        Peripetie peri07 = new Peripetie("peri7",
                "Le garde mort, vous rentrez dans la ville !",
                false,false,false,null);

        Peripetie peri03 = new Peripetie("peri3",
                "Arrivez devant Hurlevent, la porte d'entrée est gardé par un garde ...",
                false,false,false, actions2);

        hm8.put(ResultatDes.REUSSITE.getResultat(),"peri8");
        hm9.put(ResultatDes.ECHEC.getResultat(),"peri9");
        hm10.put(ResultatDes.REUSSITE_CRITIQUE.getResultat(),"peri10");
        hm11.put(ResultatDes.ECHEC_CRITIQUE.getResultat(),"peri11");

        List<Action> actions3 = new ArrayList<>();
        Action a8 = new Action("a8","Gravir la montage", hm8);
        Action a9 = new Action("a9","Gravir la montage", hm9);
        Action a10 = new Action("a10","Gravir la montage", hm10);
        Action a11 = new Action("a11","Gravir la montage", hm11);

        actions3.add(a8);
        actions3.add(a9);
        actions3.add(a10);
        actions3.add(a11);

        Peripetie peri04 = new Peripetie("peri4",
                "Vous essayer de gravir la montage ...",
                false, false,true,actions3);

        Peripetie peri08 = new Peripetie("peri8",
                "Vous gravissez la montage avec réussite !",
                false, true,false,actions3);

        Peripetie peri09 = new Peripetie("peri9",
                "Vous n'arrivez pas a vous hissez en haut de la montage, vous allez passer la nuit en bas ! ",
                false, true,false,actions3);

        Peripetie peri10 = new Peripetie("peri10",
                "Vous êtes un véritable accrobate ! En haut en 10sec",
                false, true,false,actions3);

        Peripetie peri11 = new Peripetie("peri04",
                "Vous faites une lourde chute et mourrez ... GAME OVER",
                false, true,false,actions3);

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

        Aventure aventure1 = new Aventure("av1","L'histoire de wow","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque auctor diam nibh, eget elementum nulla consequat eget. Etiam sit amet dolor ex. Vestibulum non augue velit. Nullam vulputate, ipsum vel vehicula rhoncus, ipsum odio facilisis urna, at tristique velit mi sit amet turpis. Maecenas sagittis dolor at massa ultrices interdum. Morbi sapien nisl, congue in urna a, pretium lobortis erat. Proin consectetur velit sem, eu feugiat quam scelerisque quis. Fusce eget neque sed purus congue mollis.",
                peripeties,lstHeros,false);

        Aventure aventure2 = new Aventure("av2","L'histoire de test 2","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque auctor diam nibh, eget elementum nulla consequat eget. Etiam sit amet dolor ex. Vestibulum non augue velit. Nullam vulputate, ipsum vel vehicula rhoncus, ipsum odio facilisis urna, at tristique velit mi sit amet turpis. Maecenas sagittis dolor at massa ultrices interdum. Morbi sapien nisl, congue in urna a, pretium lobortis erat. Proin consectetur velit sem, eu feugiat quam scelerisque quis. Fusce eget neque sed purus congue mollis.",
                peripeties,lstHeros,false);

        aventures.add(aventure1);
        aventures.add(aventure2);

        return aventures;
    }

    public Aventure getAventure(String idAventure){
        Statistique s1 = new Statistique("stat1",65,45,50);
        Statistique s2 = new Statistique("stat1",45,60,60);
        Statistique s3 = new Statistique("stat1",55,30,40);

        List<Heros> lstHeros = new ArrayList<>();
        Heros h1= new Heros("h1","Garrosh","Ancien chef guerrier de la horde, maintenant chasser de ces terre.", ClasseHeros.LUTIN,s1);
        Heros h2 = new Heros("h2","Trall","Ancien chef chaman de la horde, maintenant chasser de ces terre.", ClasseHeros.LUTIN,s2);
        Heros h3 = new Heros("h3","Vol'jin","Chef de la horde, expluser après une rebelion", ClasseHeros.LUTIN,s3);

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

        actions1.add(a1);
        actions1.add(a2);
        actions1.add(a3);

        Peripetie peri01 = new Peripetie("peri1",
                "Exilé de vos terre en quête de vengeance vous décidez de prendre la direction de ...",
                true,
                false,
                false,
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

        actions2.add(a4);
        actions2.add(a5);
        actions2.add(a6);
        actions2.add(a7);

        Peripetie peri02 = new Peripetie("peri2",
                "Arrivez devant Orgrimmar, la porte d'entrée est gardé par un garde ...",
                false,false,true,actions2);

        Peripetie peri05 = new Peripetie("peri5",
                "Le garde convaincu par votre discours vous ouvre la porte, vous rentrez dans la ville !",
                false,false,false,null);

        Peripetie peri06 = new Peripetie("peri6",
                "Votre coup n'atteind pas le garde et il vous tue ... GAME OVER !",
                false,false,false,null);

        Peripetie peri07 = new Peripetie("peri7",
                "Le garde mort, vous rentrez dans la ville !",
                false,false,false,null);

        Peripetie peri03 = new Peripetie("peri3",
                "Arrivez devant Hurlevent, la porte d'entrée est gardé par un garde ...",
                false,false,false, actions2);

        hm8.put(ResultatDes.REUSSITE.getResultat(),"peri8");
        hm9.put(ResultatDes.ECHEC.getResultat(),"peri9");
        hm10.put(ResultatDes.REUSSITE_CRITIQUE.getResultat(),"peri10");
        hm11.put(ResultatDes.ECHEC_CRITIQUE.getResultat(),"peri11");

        List<Action> actions3 = new ArrayList<>();
        Action a8 = new Action("a8","Gravir la montage", hm8);
        Action a9 = new Action("a9","Gravir la montage", hm9);
        Action a10 = new Action("a10","Gravir la montage", hm10);
        Action a11 = new Action("a11","Gravir la montage", hm11);

        actions3.add(a8);
        actions3.add(a9);
        actions3.add(a10);
        actions3.add(a11);

        Peripetie peri04 = new Peripetie("peri4",
                "Vous essayer de gravir la montage ...",
                false, false,true,actions3);

        Peripetie peri08 = new Peripetie("peri8",
                "Vous gravissez la montage avec réussite !",
                false, true,false,actions3);

        Peripetie peri09 = new Peripetie("peri9",
                "Vous n'arrivez pas a vous hissez en haut de la montage, vous allez passer la nuit en bas ! ",
                false, true,false,actions3);

        Peripetie peri10 = new Peripetie("peri10",
                "Vous êtes un véritable accrobate ! En haut en 10sec",
                false, true,false,actions3);

        Peripetie peri11 = new Peripetie("peri04",
                "Vous faites une lourde chute et mourrez ... GAME OVER",
                false, true,false,actions3);

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

        Aventure aventure1 = new Aventure("av1","L'histoire de wow","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque auctor diam nibh, eget elementum nulla consequat eget. Etiam sit amet dolor ex. Vestibulum non augue velit. Nullam vulputate, ipsum vel vehicula rhoncus, ipsum odio facilisis urna, at tristique velit mi sit amet turpis. Maecenas sagittis dolor at massa ultrices interdum. Morbi sapien nisl, congue in urna a, pretium lobortis erat. Proin consectetur velit sem, eu feugiat quam scelerisque quis. Fusce eget neque sed purus congue mollis.",
                peripeties,lstHeros,false);

        return aventure1;
    }

}
