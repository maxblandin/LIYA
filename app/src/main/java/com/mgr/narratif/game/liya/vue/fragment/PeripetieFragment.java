package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mgr.narratif.game.liya.R;
import com.mgr.narratif.game.liya.dto.Des;
import com.mgr.narratif.game.liya.enumeration.FaceDes;
import com.mgr.narratif.game.liya.enumeration.LibelleStat;
import com.mgr.narratif.game.liya.enumeration.ResultatDes;
import com.mgr.narratif.game.liya.model.Action;
import com.mgr.narratif.game.liya.model.Heros;
import com.mgr.narratif.game.liya.model.Peripetie;
import com.mgr.narratif.game.liya.model.Statistique;
import com.mgr.narratif.game.liya.tools.GestionDes;
import com.mgr.narratif.game.liya.vue.adapter.ActionAdapter;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeripetieFragment extends Fragment {

    private OnPeripetieListener mListener;
    TextView txtDescription;
    ImageView imgPeripetie;
    Button btnAction;
    View popupActions;
    private Heros heros;
    private Peripetie peripetie;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_peripetie, container, false);

        txtDescription = v.findViewById(R.id.peripetie_description);
        imgPeripetie   = v.findViewById(R.id.peripetie_img);
        btnAction      = v.findViewById(R.id.peripetie_btn_actions);
        popupActions   = inflater.inflate(R.layout.popup_action, container, false);

        // On récupère la Peripetie pour alimenté les champs de l'écran
        peripetie = mListener.getPeripetie();

        // On récupère le héros pour le traitement avec les stats des lancés de dés
        heros = mListener.getHeros();

        // Première instanciation de l'écran
        actualiserPeripetie();

        return v;
    }

    public void actualiserPeripetie(){
        txtDescription.setText(peripetie.getDescription());

        /* setImageResource prend la valeur int d'un drawable (ex : R.drawable.logo), pour
         * récupérer cette valeur via le nom du drawable sauvegardé dans la Peripetie,
         * on fait appel aux ressources du context pour le récupérer via son nom.
         */
        imgPeripetie.setImageResource(
                mListener.getContext().getResources().getIdentifier(
                        peripetie.getDrawableImage(), "drawable",
                        Objects.requireNonNull(getContext()).getPackageName()
                )
        );

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montrerPopup(v);
            }
        });
    }

    public void montrerPopup(View view) {

        PopupWindow popupWindow = new PopupWindow(popupActions,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        final ListView actions = popupActions.findViewById(R.id.popup_liste_action);

        ActionAdapter adapter = new ActionAdapter(mListener.getContext(), mListener.getActions());
        actions.setAdapter(adapter);

        actions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Action action = (Action) actions.getItemAtPosition(position);
                Des des;
                String idSuite = null;

                if (action.isLancerDes()) {
                    des = lancerDe(action);
                    idSuite = action.getSuite().get(des.getType());
                } else {
                    idSuite = action.getSuite().get(ResultatDes.AUCUN);
                }

                actualiserPeripetie();
            }
        });

        popupWindow.setFocusable(true);

        popupWindow.setBackgroundDrawable(new ColorDrawable());

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

    }

    public Des lancerDe(Action action) {
        Des resultat;
        Statistique stat = null;

        switch (action.getStatistique()) {
            case PHYSIQUE:
                stat = null;
                for (Statistique s : heros.getStatistiques()) {
                    if (s.getLibelle() == LibelleStat.PHYSIQUE) {
                        stat = s;
                        break;
                    }
                }
                break;
            case MENTAL:
                stat = null;
                for (Statistique s : heros.getStatistiques()) {
                    if (s.getLibelle() == LibelleStat.MENTAL) {
                        stat = s;
                        break;
                    }
                }
                break;
            case SOCIAL:
                stat = null;
                for (Statistique s : heros.getStatistiques()) {
                    if (s.getLibelle() == LibelleStat.SOCIAL) {
                        stat = s;
                        break;
                    }
                }
                break;
        }

        resultat = GestionDes.lancerDes(FaceDes.FACE100, stat.getPourcentage());

        return resultat;
    }

    public interface OnPeripetieListener {
        Context getContext();
        List<Action> getActions();
        Peripetie getPeripetie();
        Heros getHeros();
        void sauvegarderAventure(Action action);
    }

}
