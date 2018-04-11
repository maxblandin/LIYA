package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;

public class ChoixHerosFragment extends Fragment {

    private OnChoixHerosListener mListener;

    TextView lblNomHeros;
    TextView lblClasseHeros;
    TextView lblHistoireHeros;
    TextView lblStatPhysique;
    TextView lblStatMental;
    TextView lblStatSocial;

    public ChoixHerosFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choix_heros, container, false);

        lblNomHeros = v.findViewById(R.id.lbl_nom_heros);
        lblClasseHeros = v.findViewById(R.id.lbl_classe_heros);
        lblHistoireHeros = v.findViewById(R.id.lbl_histoire_heros);
        lblStatPhysique = v.findViewById(R.id.lbl_stat_physique);
        lblStatMental = v.findViewById(R.id.lbl_stat_mental);
        lblStatSocial = v.findViewById(R.id.lbl_stat_social);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(mListener instanceof OnChoixHerosListener){
            mListener = (OnChoixHerosListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + context.getPackageName() + "n'est pas instancier !");
        }
    }

    public interface OnChoixHerosListener{
        int getIdAventure();
    }

}
