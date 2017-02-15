package com.jdenner.escape.model;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.jdenner.escape.R;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Barreira extends Celula {

    public Barreira(Context context, Grade grade, int linha, int coluna) {
        super(context, linha, coluna, grade);
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        setSolido(true);
        grade.setBarreira(this, linha, coluna);
    }
}
