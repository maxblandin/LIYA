package com.mgr.narratif.game.liya.vue.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.dto.Des;
import com.mgr.narratif.game.liya.enumeration.FaceDes;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.AventureEnCours;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.model.Statistique;
import com.mgr.narratif.game.liya.service.AventureEnCoursService;
import com.mgr.narratif.game.liya.service.HerosService;
import com.mgr.narratif.game.liya.service.HistoriqueService;
import com.mgr.narratif.game.liya.service.PeripetieService;
import com.mgr.narratif.game.liya.tools.GestionDes;
import com.mgr.narratif.game.liya.vue.fragment.PeripetieFragment;

import java.util.List;

public class PeripetieActivity extends AppCompatActivity implements PeripetieFragment.OnPeripetieListener {

    private AventureEnCoursService aventureEnCoursService = new AventureEnCoursService();
    private PeripetieService peripetieService = new PeripetieService();
    private HerosService herosService = new HerosService();
    private HistoriqueService historiqueService = new HistoriqueService();
    private String idAventure;
    private String idPeripetie;
    private String idPeripetieSuite;
    private Heros heros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        idAventure = getIntent().getStringExtra("idAventure");
        idPeripetie = aventureEnCoursService.recupererAventureEnCours(idAventure).getIdPeripetie();
        heros = herosService.recupererHeros(aventureEnCoursService.recupererAventureEnCours(idAventure).getIdHeros());

        setContentView(R.layout.activity_peripetie);

    }

    @Override
    protected void onResume() {
        super.onResume();

        idAventure = getIntent().getStringExtra("idAventure");
        idPeripetie = aventureEnCoursService.recupererAventureEnCours(idAventure).getIdPeripetie();
        heros = herosService.recupererHeros(aventureEnCoursService.recupererAventureEnCours(idAventure).getIdHeros());

    }

    @Override
    public Context getContext() {
        return PeripetieActivity.this;
    }

    @Override
    public List<Action> getActions() {
        return peripetieService.recupererPeripetie(idPeripetie).getActions();
    }

    @Override
    public Peripetie getPeripetie() {
        return peripetieService.recupererPeripetie(idPeripetie);
    }

    @Override
    public Heros getHeros() {
        return herosService.recupererHeros(aventureEnCoursService.recupererAventureEnCours(idAventure).getIdHeros());
    }

    @Override
    public void sauvegarderAventure(final Action action, final Des de) {

        if (de != null) {
            idPeripetieSuite = action.getSuite().get(de.getType());
        } else {
            idPeripetieSuite = action.getSuite().get(ResultatDes.AUCUN);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                aventureEnCoursService.continuerAventure(idAventure, idPeripetieSuite);
                historiqueService.ajouterHistorique(idAventure, heros.getId(), idPeripetieSuite, action.getId(), de.getType());
            }
        }).start();

    }

    @Override
    public void getPeripetieSuivante(Action action, Des de) {

        // On va récupérer la péripetie suivante
        if (de != null) {
            idPeripetie = action.getSuite().get(de.getType());
        } else {
            idPeripetie = action.getSuite().get(ResultatDes.AUCUN);
        }

        PeripetieAsyncTask pat = new PeripetieAsyncTask();
        pat.execute();
    }

    private class PeripetieAsyncTask extends AsyncTask<Void, Void, Peripetie> {

        @Override
        protected Peripetie doInBackground(Void... voids) {
            Peripetie peripetie = peripetieService.recupererPeripetie(idPeripetie);
            return peripetie;
        }

        @Override
        protected void onPostExecute(Peripetie peripetie) {
            super.onPostExecute(peripetie);

        }
    }

}
