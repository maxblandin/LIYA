package com.mgr.narratif.game.liya.vue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.model.Heros;

import java.util.List;

public class HerosAdapter extends ArrayAdapter<Heros>{

    public HerosAdapter(@NonNull Context context, @NonNull List<Heros> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_choix_heros,parent, false);
        }

        HerosViewHolder viewHolder = (HerosViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new HerosViewHolder();
            viewHolder.lblNom = convertView.findViewById(R.id.lbl_nom_heros);
            viewHolder.lblClasse = convertView.findViewById(R.id.lbl_classe_heros);
            viewHolder.lblHistoire = convertView.findViewById(R.id.lbl_histoire_heros);
            viewHolder.lblStatPhysique = convertView.findViewById(R.id.lbl_pourcentage_physique);
            viewHolder.lblStatMental = convertView.findViewById(R.id.lbl_pourcentage_mental);
            viewHolder.lblStatSocial = convertView.findViewById(R.id.lbl_pourcentage_social);
            convertView.setTag(viewHolder);
        }

        Heros heros = getItem(position);

        if(heros != null){
            viewHolder.lblNom.setText(heros.getNom());
            viewHolder.lblClasse.setText(heros.getClasse().toString());
            viewHolder.lblHistoire.setText(heros.getHistoire());
            viewHolder.lblStatPhysique.setText(String.valueOf(heros.getStatistiques().getPourcentagePhysique()));
            viewHolder.lblStatMental.setText(String.valueOf(heros.getStatistiques().getPourcentageMental()));
            viewHolder.lblStatSocial.setText(String.valueOf(heros.getStatistiques().getPourcentageSocial()));
        }


        return convertView;
    }

    private class HerosViewHolder{
        TextView lblNom;
        TextView lblClasse;
        TextView lblHistoire;
        TextView lblStatPhysique;
        TextView lblStatMental;
        TextView lblStatSocial;
    }
}
