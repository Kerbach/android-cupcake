package com.jdenner.escape.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.jdenner.escape.R;

/**
 * Created by Juliano on 02/12/2016.
 */

public enum Tipo {

    CELULA(R.color.colorPrimaryLight),
    SEPARADOR_VERTICAL(R.color.colorSeparator),
    SEPARADOR_HORIZONTAL(R.color.colorSeparator),
    ESPACO_VAZIO(R.color.colorSeparator);

    private int cor;

    Tipo(int cor) {
        this.cor = cor;
    }

    public int getCor(Context context) {
        return ContextCompat.getColor(context, this.cor);
    }
}
