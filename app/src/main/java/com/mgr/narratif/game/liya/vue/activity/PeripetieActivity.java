package com.mgr.narratif.game.liya.vue.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.dto.Des;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.service.ActionService;
import com.mgr.narratif.game.liya.service.AventureEnCoursService;
import com.mgr.narratif.game.liya.service.HerosService;
import com.mgr.narratif.game.liya.service.HistoriqueService;
import com.mgr.narratif.game.liya.service.PeripetieService;
import com.mgr.narratif.game.liya.vue.fragment.PeripetieFragment;

public class PeripetieActivity extends AppCompatActivity implements PeripetieFragment.OnPeripetieListener {

    private AventureEnCoursService aventureEnCoursService = new AventureEnCoursService();
    private PeripetieService peripetieService = new PeripetieService();
    private HerosService herosService = new HerosService();
    private HistoriqueService historiqueService = new HistoriqueService();
    private String idAventure;
    private String idPeripetie;
    private String idPeripetieSuite;
    private Heros heros;
    private PeripetieFragment peripetieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        idAventure = getIntent().getStringExtra("idAventure");
        AlimentationAsyncTask aac = new AlimentationAsyncTask();
        aac.execute();

        // On termine les activités d'avant (choix héros, choix aventure)
        Intent intent = new Intent("finish");
        sendBroadcast(intent);

    }

    @Override
    public Context getContext() {
        return PeripetieActivity.this;
    }

    @Override
    public void getPeripetie() {
        PeripetieAsyncTask pat = new PeripetieAsyncTask();
        pat.execute();
    }

    @Override
    public void getHeros() {
        HerosAsyncTask hat = new HerosAsyncTask();
        hat.execute();
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
                if (de != null) {
                    historiqueService.ajouterHistorique(idAventure, heros.getId(), idPeripetieSuite, action.getId(), de.getType());
                } else {
                    historiqueService.ajouterHistorique(idAventure, heros.getId(), idPeripetieSuite, action.getId(), ResultatDes.AUCUN);
                }
            }
        }).start();

    }

    @Override
    public void getPeripetieSuivante(Action action, Des de) {

        // On va récupérer la péripetie suivante
        if (de != null) {
            ResultatDes type = ActionService.verifierResult(action, de.getType());
            idPeripetie = action.getSuite().get(type);
        } else {
            idPeripetie = action.getSuite().get(ResultatDes.AUCUN);
        }

        PeripetieAsyncTask pat = new PeripetieAsyncTask();
        pat.execute();
    }

    @Override
    public void envoyerFragment(PeripetieFragment peripetieFragment) {
        this.peripetieFragment = peripetieFragment;
    }

    @Override
    public void fermerEcranPeripetie() {
        finish();
    }

    @Override
    public void terminerAventure() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                aventureEnCoursService.arreterAventure(idAventure);
            }
        }).start();
    }

    @SuppressLint("StaticFieldLeak")
    private class PeripetieAsyncTask extends AsyncTask<Void, Void, Peripetie> {

        @Override
        protected Peripetie doInBackground(Void... voids) {
            return peripetieService.recupererPeripetie(idPeripetie);
        }

        @Override
        protected void onPostExecute(Peripetie peripetie) {
            super.onPostExecute(peripetie);
            peripetieFragment.afficherPeripetie(peripetie);
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class HerosAsyncTask extends AsyncTask<Void, Void, Heros> {

        @Override
        protected Heros doInBackground(Void... voids) {
            return herosService.recupererHeros(aventureEnCoursService.recupererAventureEnCours(idAventure).getIdHeros());
        }

        @Override
        protected void onPostExecute(Heros hero) {
            super.onPostExecute(hero);
            heros = hero;
            peripetieFragment.implementerHeros(hero);
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class AlimentationAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            idPeripetie = aventureEnCoursService.recupererAventureEnCours(idAventure).getIdPeripetie();
            heros = herosService.recupererHeros(aventureEnCoursService.recupererAventureEnCours(idAventure).getIdHeros());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setContentView(R.layout.activity_peripetie);
        }
    }

}
