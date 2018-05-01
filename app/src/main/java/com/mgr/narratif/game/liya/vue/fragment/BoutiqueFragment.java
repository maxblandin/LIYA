package com.mgr.narratif.game.liya.vue.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.BonusBoutique;
import com.mgr.narratif.game.liya.vue.activity.BoutiqueActivity;
import com.mgr.narratif.game.liya.vue.adapter.BonusAdapter;

import java.util.List;

public class BoutiqueFragment extends Fragment {
    private ListView lv;
    private OnBoutiqueListener mListener;

    public BoutiqueFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_boutique, container, false);

        lv = v.findViewById(R.id.lst_bonus);

        final BonusAdapter adapter = new BonusAdapter(mListener.getContext(),mListener.recupererAllBonus());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mListener.isCnxWeb()){
                    mListener.effectuerAchat(adapter.getItem(position));
                }else{
                    mListener.gererErreurCnx();
                }
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBoutiqueListener) {
            mListener = (OnBoutiqueListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public interface OnBoutiqueListener {
        Context getContext();
        boolean isCnxWeb();
        void gererErreurCnx();
        void effectuerAchat(BonusBoutique bonus);
        List<BonusBoutique> recupererAllBonus();
    }
}
