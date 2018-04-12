package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.vue.adapter.ActionAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeripetieFragment extends Fragment {

    private OnPeripetieListener mListener;
    TextView txtDescription;
    ImageView imgPeripetie;
    Button btnAction;
    View popupView;

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
                    + context.getPackageName() + " n'est pas instancié !");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_peripetie, container, false);

        txtDescription = v.findViewById(R.id.peripetie_description);
        imgPeripetie   = v.findViewById(R.id.peripetie_img);
        btnAction      = v.findViewById(R.id.peripetie_btn_actions);
        popupView = getLayoutInflater().inflate(R.layout.popup_action, null);

        // On récupère la Peripetie pour alimenté les champs de l'écran
        Peripetie peripetie = mListener.getPeripetie();

        txtDescription.setText(peripetie.getDescription());

        /* setImageResource prend la valeur int d'un drawable (ex : R.drawable.logo), pour
         * récupérer cette valeur via le nom du drawable sauvegardé dans la Peripetie,
         * on fait appel aux ressources du context pour le récupérer via son nom.
         */
        imgPeripetie.setImageResource(
                mListener.getContext().getResources().getIdentifier(
                        peripetie.getDrawableImage(), "drawable",
                        getContext().getApplicationContext().getPackageName()
                )
        );

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

        return v;
    }

    public void showPopup(View anchorView) {

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ListView actions = (ListView) popupView.findViewById(R.id.popup_liste_action);

        ActionAdapter adapter = new ActionAdapter(mListener.getContext(), mListener.getActions());
        actions.setAdapter(adapter);

        popupWindow.setFocusable(true);

        popupWindow.setBackgroundDrawable(new ColorDrawable());

        popupWindow.showAtLocation(anchorView, Gravity.CENTER, 0, 0);

    }

    public interface OnPeripetieListener {
        Context getContext();
        List<Action> getActions();
        Peripetie getPeripetie();
    }

}
