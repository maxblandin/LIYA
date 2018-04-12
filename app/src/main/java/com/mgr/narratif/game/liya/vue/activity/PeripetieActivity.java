package com.mgr.narratif.game.liya.vue.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.service.PeripetieService;
import com.mgr.narratif.game.liya.vue.fragment.PeripetieFragment;

import java.util.List;

public class PeripetieActivity extends AppCompatActivity implements PeripetieFragment.OnPeripetieListener {

    private PeripetieService peripetieService = new PeripetieService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peripetie);
    }

    @Override
    public Context getContext() {
        return PeripetieActivity.this;
    }

    @Override
    public List<Action> getActions() {
        return peripetieService.recupererPeripetie(getIntent().getStringExtra("idPrologue")).getActions();
    }

    @Override
    public Peripetie getPeripetie() {
        return peripetieService.recupererPeripetie(getIntent().getStringExtra("idPrologue"));
    }
}
