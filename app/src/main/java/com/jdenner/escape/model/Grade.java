package com.jdenner.escape.model;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Grade extends RelativeLayout {

    protected static final int PROPORCAO_CELULA = 6;
    protected static final int PROPORCAO_SEPARADOR = 1;
    private Celula celulas[][];
    private int larguraTela;
    private int alturaTela;
    private int quantidadeLinhas;
    private int quantidadeColunas;
    private int ultimoId = 1000;

    public Grade(Context context, int quantidadeLinhas, int quantidadeColunas, int larguraTela, int alturaTela) {
        super(context);
        setQuantidadeLinhas(quantidadeLinhas);
        setQuantidadeColunas(quantidadeColunas);
        setLarguraTela(larguraTela);
        setAlturaTela(alturaTela);
        setCelulas(new Celula[quantidadeLinhas * 2 + 1][quantidadeColunas * 2 + 1]);
    }

    public Celula[][] getCelulas() {
        return celulas;
    }

    public void setCelulas(Celula[][] celulas) {
        this.celulas = celulas;

        for (int linha = 0; linha < celulas.length; linha++) {
            for (int coluna = 0; coluna < celulas[linha].length; coluna++) {
                addView(celulas[linha][coluna] = new Celula(getContext(), linha, coluna, this));
            }
        }
    }

    public int getLarguraTela() {
        return larguraTela;
    }

    public void setLarguraTela(int larguraTela) {
        this.larguraTela = larguraTela;
    }

    public int getAlturaTela() {
        return alturaTela;
    }

    public void setAlturaTela(int alturaTela) {
        this.alturaTela = alturaTela;
    }

    public int getQuantidadeLinhas() {
        return quantidadeLinhas;
    }

    public void setQuantidadeLinhas(int quantidadeLinhas) {
        this.quantidadeLinhas = quantidadeLinhas;
    }

    public int getQuantidadeColunas() {
        return quantidadeColunas;
    }

    public void setQuantidadeColunas(int quantidadeColunas) {
        this.quantidadeColunas = quantidadeColunas;
    }

    public int getUltimoId() {
        return ultimoId;
    }

    public void setUltimoId(int ultimoId) {
        this.ultimoId = ultimoId;
    }

    public int getProximoId() {
        while (findViewById(++ultimoId) != null) ;
        return ultimoId;
    }

    public int getTamanhoBase() {
        int larguraBase = getLarguraTela() / ((getQuantidadeColunas() * PROPORCAO_CELULA) + ((getQuantidadeColunas() + 1) * PROPORCAO_SEPARADOR));
        int alturaBase = getAlturaTela() / ((getQuantidadeLinhas() * PROPORCAO_CELULA) + ((getQuantidadeLinhas() + 1) * PROPORCAO_SEPARADOR));
        return (larguraBase < alturaBase) ? larguraBase : alturaBase;
    }

    public int getLargura(Tipo tipo) {
        switch (tipo) {
            case CELULA:
                return getTamanhoBase() * PROPORCAO_CELULA;
            case SEPARADOR_VERTICAL:
                return getTamanhoBase() * PROPORCAO_CELULA;
            case SEPARADOR_HORIZONTAL:
                return getTamanhoBase() * PROPORCAO_SEPARADOR;
            default:
                return getTamanhoBase() * PROPORCAO_SEPARADOR;
        }
    }

    public int getAltura(Tipo tipo) {
        switch (tipo) {
            case CELULA:
                return getTamanhoBase() * PROPORCAO_CELULA;
            case SEPARADOR_VERTICAL:
                return getTamanhoBase() * PROPORCAO_SEPARADOR;
            case SEPARADOR_HORIZONTAL:
                return getTamanhoBase() * PROPORCAO_CELULA;
            default:
                return getTamanhoBase() * PROPORCAO_SEPARADOR;
        }
    }

    public void setBarreira(Barreira barreira, int linha, int coluna) {
        this.celulas[linha][coluna] = barreira;
        addView(barreira);
    }

    public Celula getCelula(int linha, int coluna) {
        return celulas[linha][coluna];
    }

    public Celula getCelulaAcima(int linha, int coluna) {
        if (linha - 1 < 0) return null;
        return celulas[linha - 1][coluna];
    }

    public Celula getCelulaAbaixo(int linha, int coluna) {
        if (linha + 1 >= celulas.length) return null;
        return celulas[linha + 1][coluna];
    }

    public Celula getCelulaEsquerda(int linha, int coluna) {
        if (coluna - 1 < 0) return null;
        return celulas[linha][coluna - 1];
    }

    public Celula getCelulaDireita(int linha, int coluna) {
        if (coluna + 1 >= celulas[linha].length) return null;
        return celulas[linha][coluna + 1];
    }
}
