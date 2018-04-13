package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.AventureEnCours;
import com.mgr.narratif.game.liya.vue.adapter.ContinuerAdapteur;

import java.util.List;

public class ContinuerFragment extends Fragment {
    private OnContinuerListener mListener;
    private ListView lv;

    public ContinuerFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_continuer, container, false);

        lv = v.findViewById(R.id.lst_continuer_aventure);

        final ContinuerAdapteur adapteur = new ContinuerAdapteur(mListener.getContext(),mListener.recupererListeAventureEnCours());
        lv.setAdapter(adapteur);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.continuerAventure(adapteur.getItem(position));
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnContinuerListener){
            mListener = (OnContinuerListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + context.getPackageName() + "n'est pas instancier !");
        }
    }

    public interface OnContinuerListener{
        Context getContext();
        List<AventureEnCours> recupererListeAventureEnCours();
        void continuerAventure(AventureEnCours aec);
    }
}
