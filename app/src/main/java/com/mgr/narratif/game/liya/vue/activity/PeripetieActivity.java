package com.mgr.narratif.game.liya.vue.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.dto.Des;
import com.mgr.narratif.game.liya.enumeration.FaceDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.AventureEnCours;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.model.Statistique;
import com.mgr.narratif.game.liya.service.AventureEnCoursService;
import com.mgr.narratif.game.liya.service.HerosService;
import com.mgr.narratif.game.liya.service.PeripetieService;
import com.mgr.narratif.game.liya.tools.GestionDes;
import com.mgr.narratif.game.liya.vue.fragment.PeripetieFragment;

import java.util.List;

public class PeripetieActivity extends AppCompatActivity implements PeripetieFragment.OnPeripetieListener {

    private AventureEnCoursService aventureEnCoursService = new AventureEnCoursService();
    private PeripetieService peripetieService = new PeripetieService();
    private HerosService herosService = new HerosService();
    private String idAventure;
    private String idPeripetie;
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
    public void sauvegarderAventure(Action action) {

    }

}
