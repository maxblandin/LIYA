package com.mgr.narratif.game.liya.vue.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Statistique;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ApplicationActivity extends AppCompatActivity {

    private final String URL = "http://rolyncraft.fr/img/perso/liya/aventure.json";
    Aventure aventure = null;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        progress = findViewById(R.id.progress_installation);

        installationLIYA install = new installationLIYA();
        install.execute();
    }

    public class installationLIYA extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... strings) {
            lireJson();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            OuvrirEcranMenu();
        }
    }

    private void lireJson(){
        JSONObject response = null;
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, future, future);

        RequestQueue queue = Volley.newRequestQueue(ApplicationActivity.this);
        queue.add(request);

        try {
            response = future.get();

            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<Aventure> jsonAdapter = moshi.adapter(Aventure.class);

            aventure = jsonAdapter.fromJson(response.toString());
            creerSQLite(aventure);

        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
    }

    private void creerSQLite(Aventure aventure){

    }

    private void  OuvrirEcranMenu(){
        Intent intent = new Intent(ApplicationActivity.this,MenuActivity.class);
        startActivity(intent);
    }
}
