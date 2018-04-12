package com.mgr.narratif.game.liya.vue.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ApplicationActivity extends AppCompatActivity {

    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        progress = findViewById(R.id.progress_installation);

        LectureJsonAventure lja = new LectureJsonAventure();
        lja.execute();
    }

    public class LectureJsonAventure extends AsyncTask<String,Integer,Aventure> {
        private final String URL = "http://rolyncraft.fr/img/perso/liya/aventure.json";
        private Aventure aventure = null;

        @Override
        protected Aventure doInBackground(String... strings) {
            JSONObject response = null;
            RequestFuture<JSONObject> future = RequestFuture.newFuture();
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, future, future);

            RequestQueue queue = Volley.newRequestQueue(ApplicationActivity.this);
            queue.add(request);

            try {
                response = future.get();

                response = response.getJSONObject("aventure");

                Moshi moshi = new Moshi.Builder().build();
                JsonAdapter<Aventure> jsonAdapter = moshi.adapter(Aventure.class);

                aventure = jsonAdapter.fromJson(response.toString());

                return aventure;
            } catch (InterruptedException | ExecutionException | JSONException | IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progress.setProgress(values[0]);
        }
    }
}
