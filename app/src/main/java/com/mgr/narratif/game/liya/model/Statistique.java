package com.mgr.narratif.game.liya.model;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class Statistique {
    private String id;
    private int pourcentagePhysique;
    private int pourcentageMental;
    private int pourcentageSocial;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getPourcentagePhysique() {
        return pourcentagePhysique;
    }
    public void setPourcentagePhysique(int pourcentagePhysique) {
        this.pourcentagePhysique = pourcentagePhysique;
    }

    public int getPourcentageMental() {
        return pourcentageMental;
    }
    public void setPourcentageMental(int pourcentageMental) {
        this.pourcentageMental = pourcentageMental;
    }

    public int getPourcentageSocial() {
        return pourcentageSocial;
    }
    public void setPourcentageSocial(int pourcentageSocial) {
        this.pourcentageSocial = pourcentageSocial;
    }

    public Statistique() {}
    public Statistique(String id, int pourcentagePhysique, int pourcentageMental, int pourcentageSocial) {
        this.id = id;
        this.pourcentagePhysique = pourcentagePhysique;
        this.pourcentageMental = pourcentageMental;
        this.pourcentageSocial = pourcentageSocial;
    }
}
