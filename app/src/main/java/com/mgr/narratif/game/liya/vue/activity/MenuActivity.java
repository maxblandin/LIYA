package com.mgr.narratif.game.liya.vue.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.vue.fragment.MenuFragment;

public class MenuActivity extends AppCompatActivity implements MenuFragment.OnMenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // On termine l'activité d'avant (début appli)
        Intent intent = new Intent("finish");
        sendBroadcast(intent);
    }

    @Override
    public void lancerPartie() {
        Intent intent = new Intent(MenuActivity.this,ChoixAventureActivity.class);
        startActivity(intent);
    }

    @Override
    public void continuerPartie() {
        Intent intent = new Intent(MenuActivity.this,ContinuerActivity.class);
        startActivity(intent);
    }

    @Override
    public void quitterApplication() {
        finish();
    }
}
