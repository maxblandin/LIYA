package com.mgr.narratif.game.liya.vue.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.enumeration.ClasseHeros;
import com.mgr.narratif.game.liya.enumeration.FaceDes;
import com.mgr.narratif.game.liya.enumeration.LibelleStat;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.model.Statistique;
import com.mgr.narratif.game.liya.service.AventureService;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ApplicationActivity extends AppCompatActivity {

    private final String URL = "http://rolyncraft.fr/img/perso/liya/aventure.json";
    Aventure aventure = null;
    ProgressBar progress;
    AventureService aventureService = new AventureService();
    static String idNouvelleAventure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        progress = findViewById(R.id.progress_installation);

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

        AventureAsyncTask aventureAsyncTask = new AventureAsyncTask();
        aventureAsyncTask.execute();
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
            creerSQLite(aventure);
            OuvrirEcranMenu();
        }
    }

    public class TestJSON extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            lireJson("https://writer.inklestudios.com/stories/xnrh.json");
            return null;
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

    private void lireJson(String url) {
        JSONObject response = null;
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, future, future);

        RequestQueue queue = Volley.newRequestQueue(ApplicationActivity.this);
        queue.add(request);

        try {
            response = future.get();

            // Création de l'aventure
            aventure = new Aventure();
            aventure.setNom(response.getString("title"));
            aventure.setIntrigue("Test d'intrigue");

            // On récupère l'id de l'aventure
            aventure.setId(idNouvelleAventure);

            final JSONObject data = response.getJSONObject("data");

            final JSONObject jsonPeripetie = data.getJSONObject("stitches");
            final JSONArray nomPeripeties = jsonPeripetie.names();

            // Instanciation des variables nécessaires à la génération des péripéties
            List<Peripetie> peripeties = new ArrayList<>();
            final String idPeripetie = idNouvelleAventure + "per";
            int compteurIdPeripetie = 1;
            Map<String, Peripetie> correspondancePeripetie = new HashMap<>();

            // Première boucle pour la génération des IDs
            for (int i = 0; i < nomPeripeties.length(); i++) {
                Peripetie p = new Peripetie();

                // Création de l'id de la péripétie
                p.setId(idPeripetie + String.valueOf(compteurIdPeripetie));
                compteurIdPeripetie++;

                // On l'ajoute à la liste des corresponde id / peripetie pour retrouver une peripetie via le nom de la peripetie dans le json
                correspondancePeripetie.put(nomPeripeties.get(i).toString(), p);
            }

            // Deuxième boucle pour la génération des péripéties
            for (int i = 0; i < nomPeripeties.length(); i++) {
                // Récupération de la péripétie "stitches"
                JSONObject peripetie = jsonPeripetie.getJSONObject(nomPeripeties.get(i).toString());

                // Récupération de la péripétie correspondant à l'objet en cours
                Peripetie p = correspondancePeripetie.get(nomPeripeties.get(i).toString());

                // Récupération des détails de cette péripétie
                JSONArray content = peripetie.getJSONArray("content");

                // On créer la description pour chercher la péripétie de début
                String description = "";

                if (content.get(0).toString().contains("DEBUT")) {
                    description = content.get(0).toString().replace("DEBUT ", "");
                    p.setPrologue(true);
                } else {
                    description = content.get(0).toString();
                }
                // L'index 0 de content correspond au text de la péripétie
                p.setDescription(description);

                // On instancie la liste des actions pour la péripétie
                List<Action> actions = new ArrayList<>();

                // Récupération des données de la péripetie, cast en JSONObject certain
                for (int j = 1; j < content.length(); j++) {
                    if (content.get(j) instanceof JSONObject) {
                        // On récupère les données de la péripétie
                        JSONObject donnees = (JSONObject) content.get(j);

                        // On instancie la map de suite
                        Map<ResultatDes, String> suite = new HashMap<>();

                        // On récupère la valeur option pour faire els tests dessus (libellé de l'action)
                        String option = null;
                        try {
                            option = donnees.getString("option");
                        } catch (JSONException e) {
                        }

                        // On test si c'est une péripétie de fin
                        if (option != null && option.equals("FIN")) {
                            p.setFin(true);
                        } else if (option != null) {
                            // Création de l'action en cours
                            Action action = new Action();

                            // Création de l'id de l'action
                            action.setId(p.getId() + "act" + String.valueOf(j));

                            // Le libellé sera construit après
                            String libelleAction = "";

                            // On check si c'est un lancer de dés
                            if (option.contains("(ECHEC_CRITIQUE)") || option.contains("(ECHEC)") ||
                                    option.contains("(REUSSITE)") || option.contains("(REUSSITE_CRITIQUE)")) {
                                // Si ça contient une de ces chaines, c'est un lancer de dés
                                action.setLancerDes(true);
                                action.setDe(FaceDes.FACE100);
                            }

                            // Si c'est un lancer de dés, on créer son libéllé et ton type de suite (echec, reussite, etc.)
                            if (action.isLancerDes()) {
                                if (option.contains("(ECHEC_CRITIQUE)")) {
                                    libelleAction = option.substring(2).replace(" (ECHEC_CRITIQUE)", "");
                                    suite.put(ResultatDes.ECHEC_CRITIQUE, correspondancePeripetie.get(donnees.getString("linkPath")).getId());
                                    action.setSuite(suite);
                                }

                                if (option.contains("(ECHEC)")) {
                                    libelleAction = option.substring(2).replace(" (ECHEC)", "");
                                    suite.put(ResultatDes.ECHEC, correspondancePeripetie.get(donnees.getString("linkPath")).getId());
                                    action.setSuite(suite);
                                }

                                if (option.contains("(REUSSITE)")) {
                                    libelleAction = option.substring(2).replace(" (REUSSITE)", "");
                                    suite.put(ResultatDes.REUSSITE, correspondancePeripetie.get(donnees.getString("linkPath")).getId());
                                    action.setSuite(suite);
                                }

                                if (option.contains("(REUSSITE_CRITIQUE)")) {
                                    libelleAction = option.substring(2).replace(" (REUSSITE_CRITIQUE)", "");
                                    suite.put(ResultatDes.REUSSITE_CRITIQUE, correspondancePeripetie.get(donnees.getString("linkPath")).getId());
                                    action.setSuite(suite);
                                }

                                // Gestion de la stat utilisée
                                if (option.startsWith("S")) {
                                    action.setStatistique(LibelleStat.SOCIAL);
                                } else if (option.startsWith("P")) {
                                    action.setStatistique(LibelleStat.PHYSIQUE);
                                } else if (option.startsWith("M")) {
                                    action.setStatistique(LibelleStat.MENTAL);
                                }
                            } else {
                                // Si c'est pas un lancer de dé, alors le libellé correspond au nom de l'action directement
                                libelleAction = option;

                                // On créer la suite
                                suite.put(ResultatDes.AUCUN, correspondancePeripetie.get(donnees.getString("linkPath")).getId());
                                action.setSuite(suite);
                            }

                            // Vérification que l'action est à ajouter
                            if (action.isLancerDes() && actions.size() > 0) {
                                boolean existe = false;

                                /* On cherche dans la liste d'actions si celle qu'on traite est déjà présente, si c'est le
                                   cas, on ajoute juste la suite que ça engendre pour le résultat de dé associer
                                 */
                                for (int k = 0; k < actions.size(); k++) {
                                    if (actions.get(k).getLibelle().equals(libelleAction)) {
                                        actions.get(k).getSuite().putAll(suite);
                                        existe = true;
                                        break;
                                    }
                                }

                                // Si on a pas trouver cette action, on l'ajoute comme nouvelle action dans la liste
                                if (!existe) {
                                    action.setLibelle(libelleAction);
                                    actions.add(action);
                                }
                            } else {
                                // On ajoute l'action car ce n'est pas un lancer de dé
                                action.setLibelle(libelleAction);
                                actions.add(action);
                            }

                        }

                    }

                }

                if (actions.size() > 0) {
                    p.setActions(actions);
                }

                peripeties.add(p);
            }

            aventure.setPeripeties(peripeties);

            List<Heros> heros = new ArrayList<>();
            List<Statistique> stats = new ArrayList<>();
            stats.add(new Statistique("ave1her1sta1", LibelleStat.PHYSIQUE, 70));
            stats.add(new Statistique("ave1her1sta2", LibelleStat.MENTAL, 55));
            stats.add(new Statistique("ave1her1sta3", LibelleStat.SOCIAL, 45));
            heros.add(new Heros("ave1her1", "Althir", "Un mec cool", ClasseHeros.AVENTURIER, stats));

            aventure.setHeros(heros);

            AjouterAventureAsyncTask ajouterAventureAsyncTask = new AjouterAventureAsyncTask();
            ajouterAventureAsyncTask.execute();
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
    }

    private class AventureAsyncTask extends AsyncTask<Void, Void, List<Aventure>> {

        @Override
        protected List<Aventure> doInBackground(Void... voids) {
            return aventureService.recupererAventures();
        }

        @Override
        protected void onPostExecute(List<Aventure> aventures) {
            super.onPostExecute(aventures);
            idNouvelleAventure = "ave" + String.valueOf(aventures.size() + 1);
            TestJSON testJSON = new TestJSON();
            testJSON.execute();
        }
    }

    private class AjouterAventureAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            aventureService.ajouterAventure(aventure);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            OuvrirEcranMenu();
        }
    }

    private void  OuvrirEcranMenu(){
        Intent intent = new Intent(ApplicationActivity.this,MenuActivity.class);
        startActivity(intent);
    }
}
