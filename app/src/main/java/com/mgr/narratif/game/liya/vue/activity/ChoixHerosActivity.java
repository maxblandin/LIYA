package com.mgr.narratif.game.liya.vue.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.service.AventureService;
import com.mgr.narratif.game.liya.vue.fragment.ChoixAventureFragment;
import com.mgr.narratif.game.liya.vue.fragment.ChoixHerosFragment;

import java.util.List;

public class ChoixHerosActivity extends AppCompatActivity implements ChoixHerosFragment.OnChoixHerosListener {

    AventureService aventureService = new AventureService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_heros);
    }

    @Override
    public Context getContext() {
        return ChoixHerosActivity.this;
    }

    @Override
    public List<Heros> recupererListeHeros() {
        Intent intent = getIntent();
        return aventureService.recupererAventure(intent.getStringExtra("idAventure")).getHeros();
    }
}
