package com.mgr.narratif.game.liya.vue.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.BonusBoutique;
import com.mgr.narratif.game.liya.model.PassePartout;
import com.mgr.narratif.game.liya.service.BonusBoutiqueService;
import com.mgr.narratif.game.liya.vue.fragment.BoutiqueFragment;

import java.util.List;

public class BoutiqueActivity extends AppCompatActivity implements BoutiqueFragment.OnBoutiqueListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique);
    }

    @Override
    public Context getContext() { return BoutiqueActivity.this; }

    @Override
    public boolean isCnxWeb() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void gererErreurCnx() {
        Toast t = Toast.makeText(BoutiqueActivity.this,"L'achat n'a pas pu aboutir, une connexion internet est requise !",Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public void effectuerAchat(BonusBoutique bonus) {
        Toast t = Toast.makeText(BoutiqueActivity.this,"L'achat de " + String.valueOf(bonus.getPrix()) +"euros à été effectuer !",Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public List<BonusBoutique> recupererAllBonus() {
        BonusBoutiqueService bbs = new BonusBoutiqueService();
        return bbs.recupererBonus();
    }
}
