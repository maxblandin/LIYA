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

import java.util.List;

/**
 * Created by rbonhomme2016 on 12/04/2018.
 */

public class ActionAdapter extends ArrayAdapter<Action> {
    public ActionAdapter(@NonNull Context context, @NonNull List<Action> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ligne_action,parent, false);
        }

        ActionViewHolder viewHolder = (ActionViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ActionViewHolder();
            viewHolder.txtLibelle = convertView.findViewById(R.id.popup_libelle_action);
            viewHolder.imgLancerDes = convertView.findViewById(R.id.popup_img_lancer_des);
            convertView.setTag(viewHolder);
        }

        Action action = getItem(position);

        viewHolder.txtLibelle.setText(action.getLibelle());
        viewHolder.imgLancerDes.setImageResource(R.drawable.bouton_continue_vierge);

        return convertView;
    }

    private class ActionViewHolder {
        TextView txtLibelle;
        ImageView imgLancerDes;
    }
}
