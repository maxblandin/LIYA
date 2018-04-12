package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgr.narratif.game.liya.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeripetieFragment extends Fragment {

    private OnPeripetieListener mListener;

    public PeripetieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnPeripetieListener) {
            mListener = (OnPeripetieListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + context.getPackageName() + "n'est pas instancier !");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_peripetie, container, false);
    }

    public interface OnPeripetieListener {

    }

}
