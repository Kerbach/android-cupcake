package com.jdenner.escape.model;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Celula extends View {

    private int linha = 0;
    private int coluna = 0;
    private boolean solido;
    private Grade grade;

    public Celula(Context context, int linha, int coluna, Grade grade) {
        super(context);
        setId(grade.getProximoId());
        setGrade(grade);
        setLinha(linha);
        setColuna(coluna);
        setSolido(false);
        setBackgroundColor(getTipo().getCor(context));
        setLayoutParams(getLeiaute());
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public boolean isSolido() {
        return solido;
    }

    public void setSolido(boolean solido) {
        this.solido = solido;
    }

    public RelativeLayout.LayoutParams getLeiaute() {

        int largura = getGrade().getLargura(getTipo());
        int altura = getGrade().getAltura(getTipo());

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(largura, altura);

        if (getLinha() != 0) {
            layoutParams.addRule(RelativeLayout.BELOW, getGrade().getCelulaAcima(getLinha(), getColuna()).getId());
        }

        if (getColuna() != 0) {
            layoutParams.addRule(RelativeLayout.RIGHT_OF, getGrade().getCelulaEsquerda(getLinha(), getColuna()).getId());
            layoutParams.addRule(RelativeLayout.END_OF, getGrade().getCelulaEsquerda(getLinha(), getColuna()).getId());
        }

        return layoutParams;
    }

    public boolean ehLinhaPar() {
        return getLinha() % 2 == 0;
    }

    public boolean ehColunaPar() {
        return getColuna() % 2 == 0;
    }

    public Tipo getTipo() {
        if (ehLinhaPar() && ehColunaPar()) {
            return Tipo.ESPACO_VAZIO;
        } else if (ehLinhaPar()) {
            return Tipo.SEPARADOR_VERTICAL;
        } else if (ehColunaPar()) {
            return Tipo.SEPARADOR_HORIZONTAL;
        } else {
            return Tipo.CELULA;
        }
    }

    public Celula getCelulaEsquerda() {
        return getGrade().getCelulaEsquerda(getLinha(), getColuna());
    }

    public Celula getCelulaDireita() {
        return getGrade().getCelulaDireita(getLinha(), getColuna());
    }

    public Celula getCelulaAcima() {
        return getGrade().getCelulaAcima(getLinha(), getColuna());
    }

    public Celula getCelulaAbaixo() {
        return getGrade().getCelulaAbaixo(getLinha(), getColuna());
    }
}
