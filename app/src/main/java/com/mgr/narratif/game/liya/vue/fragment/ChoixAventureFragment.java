package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Aventure;
import com.mgr.narratif.game.liya.vue.adapter.AventureAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoixAventureFragment extends Fragment {
    private OnChoixAventureListener mListener;
    private ListView lv;

    public ChoixAventureFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choix_aventure, container, false);

        lv = v.findViewById(R.id.lst_choix_aventure);

        final AventureAdapter adapter = new AventureAdapter(mListener.getContext(),mListener.recupererAventures());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.choisirAventure(adapter.getItem(position));
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnChoixAventureListener) {
            mListener = (OnChoixAventureListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + context.getPackageName() + "n'est pas instancier !");
        }
    }

    public interface OnChoixAventureListener{
        Context getContext();
        List<Aventure> recupererAventures();
        void choisirAventure(Aventure aventure);
    }
}
