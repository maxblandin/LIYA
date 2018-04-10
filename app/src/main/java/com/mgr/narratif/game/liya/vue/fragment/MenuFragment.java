package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.mgr.narratif.game.liya.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {
    private OnMenuListener mListener;

    ImageButton btnNouvellePartie;
    ImageButton btnContinuer;
    ImageButton btnQuitter;

    public MenuFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        btnNouvellePartie = v.findViewById(R.id.btn_new_game);
        btnContinuer = v.findViewById(R.id.btn_continuer);
        btnQuitter = v.findViewById(R.id.btn_quitter);

        if(mListener != null) {
            btnNouvellePartie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.lancerPartie();
                }
            });

            btnContinuer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.continuerPartie();
                }
            });

            btnQuitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.quitterApplication();
                }
            });
        }
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnMenuListener) {
            mListener = (OnMenuListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + context.getPackageName() + "n'est pas instancier !");
        }
    }

    public interface OnMenuListener{
        void lancerPartie();
        void continuerPartie();
        void quitterApplication();
    }

}
