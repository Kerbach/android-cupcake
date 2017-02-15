package com.jdenner.escape.util;

import android.animation.Animator;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Animacao implements Animator.AnimatorListener {

    @Override
    public void onAnimationStart(Animator animation) {
        aoIniciar();
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        aoFinalizar();
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        aoCancelar();
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        aoRepetir();
    }

    public void aoIniciar() {
    }

    public void aoFinalizar() {
    }

    public void aoCancelar() {
    }

    public void aoRepetir() {
    }
}
