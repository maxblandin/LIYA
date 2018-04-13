package com.mgr.narratif.game.liya.vue.fragment;


import android.content.Context;
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
    private PopupWindow popupWindow;

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

        // On envoie l'instance du fragment à l'activité (je crois que c'est moche mais ça marche)
        mListener.envoyerFragment(this);

        // Alimentation des champs de la vue
        txtDescription = v.findViewById(R.id.peripetie_description);
        imgPeripetie   = v.findViewById(R.id.peripetie_img);
        btnAction      = v.findViewById(R.id.peripetie_btn_actions);
        popupActions   = inflater.inflate(R.layout.popup_action, container, false);

        // On récupère la Peripetie pour alimenté les champs de l'écran
        mListener.getPeripetie();

        // On récupère le héros pour le traitement avec les stats des lancés de dés
        heros = mListener.getHeros();

        return v;
    }

    /**
     * Permet d'actualiser les champs de l'écran, utilise la propriété Peripetie du fragment
     */
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

        // Si la péripetie actuelle est la dernière
        if (peripetie.isFin()) {
            btnAction.setVisibility(View.GONE);
        } else {
            btnAction.setVisibility(View.VISIBLE);
            btnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    montrerPopupAction(v);
                }
            });
        }
    }

    /**
     * Permet d'afficher la popup contenant les actions
     * @param view La vue de base sur la quelle la popup viendra s'afficher
     */
    public void montrerPopupAction(View view) {

        popupWindow = new PopupWindow(popupActions,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // ListView contenant les actions
        final ListView actions = popupActions.findViewById(R.id.popup_liste_action);

        // On lui donne la liste d'actions de la peripetie qu'on récupère via getActions()
        ActionAdapter adapter = new ActionAdapter(mListener.getContext(), peripetie.getActions());
        actions.setAdapter(adapter);

        // Action lors du choix sur la popup
        actions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // On récupère l'action, on check si un lancer de dé est à faire
                Action action = (Action) actions.getItemAtPosition(position);
                Des de = null;
                String idSuite = null;

                // On effectue le lancer de dé (ou non)
                if (action.isLancerDes()) {
                    de = lancerDe(action);
                    idSuite = action.getSuite().get(de.getType());
                } else {
                    idSuite = action.getSuite().get(ResultatDes.AUCUN);
                }

                mListener.sauvegarderAventure(action, de);

                // Ici on peut ajouter le fait de relancer
                mListener.getPeripetieSuivante(action, de);
            }
        });

        popupWindow.setFocusable(true);

        // On lui donne l'endroit ou s'afficher
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

    }

    /**
     * Attend la réponse du service de péripetie pour actualiser l'affichage
     * @param peripetie La peripetie à afficher
     */
    public void afficherPeripetie(Peripetie peripetie) {
        // Récupération de la péripetie du service
        this.peripetie = peripetie;

        // On actualise la péripetie
        actualiserPeripetie();

        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /**
     * Lancement des dés lors d'une action
     * @param action L'action choisie sur l'écran
     * @return Des le dé contenant le résultat et le type de résultat (normal, echec, etc.)
     */
    public Des lancerDe(Action action) {
        // On réalise le lancer de dés suivant la stat demandé
        Des resultat;
        Statistique stat = null;

        // Les statistiques sont récupérer de l'Enum des stats
        switch (action.getStatistique()) {
            // Jet de dés avec la caractéristique physique
            case PHYSIQUE:
                stat = null;
                for (Statistique s : heros.getStatistiques()) {
                    if (s.getLibelle() == LibelleStat.PHYSIQUE) {
                        stat = s;
                        break;
                    }
                }
                break;
            // Jet de dés avec la caractéristique mental
            case MENTAL:
                stat = null;
                for (Statistique s : heros.getStatistiques()) {
                    if (s.getLibelle() == LibelleStat.MENTAL) {
                        stat = s;
                        break;
                    }
                }
                break;
            // Jet de dés avec la caractéristique social
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

        // On lance les dés
        resultat = GestionDes.lancerDes(FaceDes.FACE100, stat.getPourcentage());

        // Le résultat est le dés contenant le chiffre obtenu et le type de resultat (echec, normal, etc.)
        return resultat;
    }

    public interface OnPeripetieListener {
        Context getContext();
        void getPeripetie();
        Heros getHeros();
        void sauvegarderAventure(Action action, Des de);
        void getPeripetieSuivante(Action action, Des de);
        void envoyerFragment(PeripetieFragment peripetieFragment);
    }

}
