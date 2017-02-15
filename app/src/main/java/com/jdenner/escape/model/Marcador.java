package com.jdenner.escape.model;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdenner.escape.R;
import com.jdenner.escape.util.Converter;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Marcador extends ImageView {

    private int linhaInicial = 0;
    private int colunaInicial = 0;

    public Marcador(Context context, Grade grade) {
        this(context, grade, grade.getQuantidadeLinhas() * 2 - 1, 1);
    }

    public Marcador(Context context, Grade grade, int linhaInicial, int colunaInicial) {
        super(context);
        this.linhaInicial = linhaInicial;
        this.colunaInicial = colunaInicial;

        Celula celulaCanto = grade.getCelula(linhaInicial, colunaInicial);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(grade.getTamanhoBase() * Grade.PROPORCAO_CELULA, grade.getTamanhoBase() * grade.PROPORCAO_CELULA);
        layoutParams.addRule(RelativeLayout.ALIGN_LEFT, celulaCanto.getId());
        layoutParams.addRule(RelativeLayout.ALIGN_START, celulaCanto.getId());
        layoutParams.addRule(RelativeLayout.ALIGN_TOP, celulaCanto.getId());

        setLayoutParams(layoutParams);
        setImageResource(R.drawable.ic_marcador);

        int p = Converter.dpiEmPixel(context, 4);
        setPadding(p, p, p, p);

        grade.addView(this);
    }

    public int getLinhaInicial() {
        return linhaInicial;
    }

    public int getColunaInicial() {
        return colunaInicial;
    }
}
