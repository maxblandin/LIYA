package com.mgr.narratif.game.liya.tools;

import android.transition.Transition;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

public class GestionAnimation {

    public static void ajouterFondu(View v) {
        Animation fonduArrivee = new AlphaAnimation(0, 1);
        fonduArrivee.setInterpolator(new DecelerateInterpolator());
        fonduArrivee.setDuration(500);

        Animation fonduDepart = new AlphaAnimation(1, 0);
        fonduDepart.setInterpolator(new AccelerateInterpolator());
        fonduDepart.setStartOffset(4000);
        fonduDepart.setDuration(500);

        AnimationSet fondu = new AnimationSet(false);
        fondu.addAnimation(fonduArrivee);
        fondu.addAnimation(fonduDepart);

        v.setAnimation(fondu);
    }

}
