package com.mgr.narratif.game.liya.vue.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.AventureEnCours;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.service.AventureEnCoursService;
import com.mgr.narratif.game.liya.service.AventureService;
import com.mgr.narratif.game.liya.vue.fragment.ContinuerFragment;

import java.util.List;

public class ContinuerActivity extends AppCompatActivity implements ContinuerFragment.OnContinuerListener{

    AventureEnCoursService aecService = new AventureEnCoursService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuer);

        /* Pour finir l'activité quand on veut, le BroadcastReceiver permet
         * de réalisé des actions sur une activité sans y être si elle est ouverte */
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("finish")) {
                    finish();
                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("finish"));
    }

    @Override
    public Context getContext() {
        return ContinuerActivity.this;
    }

    @Override
    public List<AventureEnCours> recupererListeAventureEnCours() {
        return aecService.recupererAventuresEnCours();
    }

    @Override
    public void continuerAventure(AventureEnCours aec) {
        Intent intent = new Intent(ContinuerActivity.this, PeripetieActivity.class);
        intent.putExtra("idAventure",aec.getIdAventure());
        startActivity(intent);
    }
}
