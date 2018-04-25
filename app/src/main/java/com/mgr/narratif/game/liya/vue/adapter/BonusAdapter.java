package com.mgr.narratif.game.liya.vue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.BonusBoutique;

import java.util.List;

public class BonusAdapter extends ArrayAdapter<BonusBoutique> {
    public BonusAdapter(@NonNull Context context, @NonNull List<BonusBoutique> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_bonus_boutique,parent, false);
        }

        BonusAdapter.BonusBoutiqueViewHolder viewHolder = (BonusAdapter.BonusBoutiqueViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new BonusAdapter.BonusBoutiqueViewHolder();
            viewHolder.txtOffre = convertView.findViewById(R.id.lbl_nom_offre);
            viewHolder.txtPrix = convertView.findViewById(R.id.lbl_prix);
            viewHolder.imgBonus = convertView.findViewById(R.id.bonus_img);
            convertView.setTag(viewHolder);
        }

        BonusBoutique bonus = getItem(position);

        if (bonus != null) {
            viewHolder.txtOffre.setText(bonus.getOffre());
            viewHolder.txtPrix.setText(String.valueOf(bonus.getPrix()));
            viewHolder.imgBonus.setImageResource(R.drawable.de_action);
        }

        return convertView;
    }

    private class BonusBoutiqueViewHolder {
        TextView txtOffre;
        TextView txtPrix;
        ImageView imgBonus;
    }
}
