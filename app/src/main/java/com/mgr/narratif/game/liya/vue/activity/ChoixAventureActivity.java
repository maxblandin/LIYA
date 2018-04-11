package com.mgr.narratif.game.liya.vue.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.dao.AventureDAO;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.service.AventureService;

public class ChoixAventureActivity extends AppCompatActivity {

    AventureService avService = new AventureService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_aventure);
    }
}
