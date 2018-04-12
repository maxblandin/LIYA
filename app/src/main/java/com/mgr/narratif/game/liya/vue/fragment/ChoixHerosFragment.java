package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.vue.adapter.HerosAdapter;

import java.util.List;

public class ChoixHerosFragment extends Fragment {
    private OnChoixHerosListener mListener;
    ListView lv;

    public ChoixHerosFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choix_heros, container, false);

        lv = v.findViewById(R.id.lst_choix_heros);

        final HerosAdapter adapter = new HerosAdapter(mListener.getContext(),mListener.recupererListeHeros());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.choisirHeros(adapter.getItem(position));
                mListener.commencerAventure();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnChoixHerosListener){
            mListener = (OnChoixHerosListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + context.getPackageName() + "n'est pas instancier !");
        }
    }

    public interface OnChoixHerosListener{
        Context getContext();
        List<Heros> recupererListeHeros();
        void choisirHeros(Heros heros);
        void commencerAventure();
    }

}
