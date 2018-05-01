package com.mgr.narratif.game.liya.vue.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.service.AventureEnCoursService;
import com.mgr.narratif.game.liya.service.AventureService;
import com.mgr.narratif.game.liya.service.PeripetieService;
import com.mgr.narratif.game.liya.vue.fragment.ChoixHerosFragment;

import java.util.List;

public class ChoixHerosActivity extends AppCompatActivity implements ChoixHerosFragment.OnChoixHerosListener {
    private AventureService aventureService = new AventureService();
    private PeripetieService peripetieService = new PeripetieService();
    private AventureEnCoursService aventureEnCoursService = new AventureEnCoursService();
    private Aventure aventure;
    private Heros heros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recupererIntentAventure();

        setContentView(R.layout.activity_choix_heros);

        /* Pour finir l'activité quand on veut, le BroadcastReceiver permet
         * de réalisé des actions sur une activité sans y être si elle est ouverte */
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("finish")) {
                    finish();
                }
                unregisterReceiver(this);
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("finish"));
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
        this.heros = heros;
        aventureEnCoursService.commencerAventure(
                aventure.getId(),
                peripetieService.recupererPrologue(aventure.getId()).getId(),
                heros.getId());
    }

    @Override
    public void commencerAventure() {
        Intent intent = new Intent(ChoixHerosActivity.this,PeripetieActivity.class);
        intent.putExtra("idPrologue",peripetieService.recupererPrologue(aventure.getId()).getId());
        intent.putExtra("idAventure", aventure.getId());
        intent.putExtra("idHeros", heros.getId());
        startActivity(intent);
    }

    private void recupererIntentAventure(){
        Intent intent = getIntent();
        aventure = aventureService.recupererAventure(intent.getStringExtra("idAventure"));
    }
}
