package com.jdenner.escape.model;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdenner.escape.R;
import com.jdenner.escape.util.Converter;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Chegada extends ImageView {

    private int linha;
    private int coluna;

    public Chegada(Context context, Grade grade, int linha, int coluna) {
        super(context);

        this.linha = linha;
        this.coluna = coluna;

        Celula celulaChegada = grade.getCelula(linha, coluna);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(grade.getTamanhoBase() * Grade.PROPORCAO_CELULA, grade.getTamanhoBase() * grade.PROPORCAO_CELULA);
        layoutParams.addRule(RelativeLayout.ALIGN_LEFT, celulaChegada.getId());
        layoutParams.addRule(RelativeLayout.ALIGN_START, celulaChegada.getId());
        layoutParams.addRule(RelativeLayout.ALIGN_TOP, celulaChegada.getId());

        setLayoutParams(layoutParams);
        setImageResource(R.drawable.ic_chegada);

        int p = Converter.dpiEmPixel(context, 4);
        setPadding(p, p, p, p);

        grade.addView(this);
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
