package com.mgr.narratif.game.liya.vue.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.dao.AventureDAO;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.service.AventureService;
import com.mgr.narratif.game.liya.vue.fragment.ChoixAventureFragment;

import java.util.List;

public class ChoixAventureActivity extends AppCompatActivity implements ChoixAventureFragment.OnChoixAventureListener {

    AventureService avService = new AventureService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_aventure);
    }

    @Override
    public Context getContext() {
        return ChoixAventureActivity.this;
    }

    @Override
    public List<Aventure> recupererAventures() {
        return avService.recupererAventures();
    }

    @Override
    public void choisirAventure(Aventure aventure) {
        Intent intent = new Intent(ChoixAventureActivity.this,ChoixHerosActivity.class);
        intent.putExtra("idAventure",aventure.getId());
        startActivity(intent);
    }
}
