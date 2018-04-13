package com.mgr.narratif.game.liya.vue.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.AventureEnCours;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.service.AventureService;

import java.util.List;

public class ContinuerAdapteur extends ArrayAdapter<AventureEnCours> {
    AventureEnCours aec;
    ContinuerViewHolder viewHolder;
    public ContinuerAdapteur(@NonNull Context context, List<AventureEnCours> objects ) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_continuer,parent, false);
        }

        viewHolder = (ContinuerViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ContinuerViewHolder();
            viewHolder.lblNomAventure = convertView.findViewById(R.id.lbl_nom_aventure_continuer);
            viewHolder.lblNomHeros = convertView.findViewById(R.id.lbl_nom_heros_continuer);
            viewHolder.lblResume = convertView.findViewById(R.id.lbl_resume_peripetie_continuer);
        }

        aec = getItem(position);
        AventureAsyncTask task = new AventureAsyncTask();
        task.execute();

        return convertView;
    }

    private class AventureAsyncTask extends AsyncTask<Void,Void,Aventure>{
        @Override
        protected Aventure doInBackground(Void... voids) {
            return getAventureById(aec.getIdAventure());
        }

        @Override
        protected void onPostExecute(Aventure aventure) {
            super.onPostExecute(aventure);
            if(aec != null){
                viewHolder.lblNomAventure.setText(aventure.getNom());
                for (Heros h : aventure.getHeros()){
                    if(h.getId().equals(aec.getIdHeros())){
                        viewHolder.lblNomHeros.setText(h.getNom());
                    }
                }
                for (Peripetie p : aventure.getPeripeties()){
                    if(p.getId().equals(aec.getIdPeripetie())){
                        if(p.getDescription().length() < 100){
                            viewHolder.lblResume.setText(p.getDescription() + " ...");
                        }else{
                            viewHolder.lblResume.setText(p.getDescription().substring(0,100) + " ...");
                        }

                    }
                }
            }
        }
    }

    private Aventure getAventureById(String id){
        AventureService aventureService = new AventureService();
        return aventureService.recupererAventure(id);
    }

    private class ContinuerViewHolder{
        TextView lblNomAventure;
        TextView lblNomHeros;
        TextView lblResume;
    }
}
