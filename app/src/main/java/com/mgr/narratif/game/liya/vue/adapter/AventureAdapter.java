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

import java.util.List;

public class AventureAdapter extends ArrayAdapter<Aventure>{

    public AventureAdapter(@NonNull Context context, @NonNull List<Aventure> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_choix_aventure,parent, false);
        }

        AventureViewHolder viewHolder = (AventureViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new AventureViewHolder();
            viewHolder.lblNom = convertView.findViewById(R.id.lbl_nom_aventure);
            viewHolder.lblIntrigue = convertView.findViewById(R.id.lbl_intrigue_aventure);
            convertView.setTag(viewHolder);
        }

        Aventure aventure = getItem(position);

        viewHolder.lblNom.setText(aventure.getNom());
        viewHolder.lblIntrigue.setText(aventure.getIntrigue());

        return convertView;
    }

    private class AventureViewHolder{
        TextView lblNom;
        TextView lblIntrigue;
    }
}
