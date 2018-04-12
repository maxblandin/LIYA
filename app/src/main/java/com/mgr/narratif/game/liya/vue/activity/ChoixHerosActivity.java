package com.mgr.narratif.game.liya.vue.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.service.AventureService;
import com.mgr.narratif.game.liya.service.PeripetieService;
import com.mgr.narratif.game.liya.vue.fragment.ChoixAventureFragment;
import com.mgr.narratif.game.liya.vue.fragment.ChoixHerosFragment;

import java.util.List;

public class ChoixHerosActivity extends AppCompatActivity implements ChoixHerosFragment.OnChoixHerosListener {
    private AventureService aventureService = new AventureService();
    private PeripetieService peripetieService = new PeripetieService();
    private Aventure aventure = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recupererIntentAventure();

        setContentView(R.layout.activity_choix_heros);
    }

    @Override
    public Context getContext() {
        return ChoixHerosActivity.this;
    }

    @Override
    public List<Heros> recupererListeHeros() {
        return aventure.getHeros();
    }

    @Override
    public void choisirHeros(Heros heros) {
    }

    @Override
    public void commencerAventure() {
        Intent intent = new Intent(ChoixHerosActivity.this,PeripetieActivity.class);
        intent.putExtra("idPrologue",peripetieService.recupererPrologue(aventure.getId()).getId());
        startActivity(intent);
    }

    private void recupererIntentAventure(){
        Intent intent = getIntent();
        aventure = aventureService.recupererAventure(intent.getStringExtra("idAventure"));
    }
}
