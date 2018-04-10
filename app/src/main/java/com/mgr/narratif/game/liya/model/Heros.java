package com.mgr.narratif.game.liya.model;

import com.mgr.narratif.game.liya.enumeration.ClasseHeros;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Heros {
    private String id;
    private String nom;
    private String histoire;
    private ClasseHeros classe;
    private Statistique statistique;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHistoire() {
        return histoire;
    }
    public void setHistoire(String histoire) {
        this.histoire = histoire;
    }

    public ClasseHeros getClasse() {
        return classe;
    }
    public void setClasse(ClasseHeros classe) {
        this.classe = classe;
    }

    public Statistique getStatistiques() {
        return statistique;
    }
    public void setStatistiques(Statistique statistiques) {
        this.statistique = statistiques;
    }

    public Heros() {}
    public Heros(String id, String nom, String histoire, ClasseHeros classe, Statistique statistique) {
        this.id = id;
        this.nom = nom;
        this.histoire = histoire;
        this.classe = classe;
        this.statistique = statistique;
    }
}
