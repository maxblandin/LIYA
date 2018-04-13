package com.mgr.narratif.game.liya.vue.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.vue.fragment.MenuFragment;

public class MenuActivity extends AppCompatActivity implements MenuFragment.OnMenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
