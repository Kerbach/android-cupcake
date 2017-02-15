package com.jdenner.escape.model;

import android.content.Context;
import android.util.DisplayMetrics;

import com.jdenner.escape.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Jogo {

    private Context context;
    private int nivel;
    private int larguraTela = 0;
    private int alturaTela = 0;
    private Grade grade;
    private Marcador marcador;
    private Chegada chegada;
    private List<Barreira> barreiras = new ArrayList<>();

    public Jogo(Context context, DisplayMetrics metricas, int nivel) {
        int padding = (int) (context.getResources().getDimension(R.dimen.default_padding) * 2);
        this.nivel = nivel;
        this.context = context;
        this.larguraTela = metricas.widthPixels - padding;
        this.alturaTela = metricas.heightPixels - padding;

        get(nivel);
    }

    public int getNivel() {
        return nivel;
    }

    public Grade getGrade() {
        return grade;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public Chegada getChegada() {
        return chegada;
    }

    public List<Barreira> getBarreiras() {
        return barreiras;
    }

    public Grade get(int nivel) {
        switch (nivel) {
            case 1:
                return criarNivel1();
            case 2:
                return criarNivel2();
            case 3:
                return criarNivel3();
            case 4:
                return criarNivel4();
            case 5:
                return criarNivel5();
            case 6:
                return criarNivel6();
            case 7:
                return criarNivel7();
            case 8:
                return criarNivel8();
            case 9:
                return criarNivel9();
            default:
                throw new UnsupportedOperationException(context.getResources().getString(R.string.nivel_invalido));
        }
    }

    private Grade criarNivel1() {
        int quantidadeLinhas = 6;
        int quantidadeColunas = 6;
        this.nivel = 1;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade);
        this.chegada = new Chegada(context, grade, 1, 11);
        this.barreiras.add(new Barreira(context, grade, 0, 7));
        this.barreiras.add(new Barreira(context, grade, 11, 8));
        return this.grade;
    }

    private Grade criarNivel2() {
        int quantidadeLinhas = 6;
        int quantidadeColunas = 6;
        this.nivel = 2;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade);
        this.chegada = new Chegada(context, grade, 1, 11);

        this.barreiras.add(new Barreira(context, grade, 0, 7));
        this.barreiras.add(new Barreira(context, grade, 2, 9));
        this.barreiras.add(new Barreira(context, grade, 4, 1));
        this.barreiras.add(new Barreira(context, grade, 6, 5));
        this.barreiras.add(new Barreira(context, grade, 8, 7));

            this.barreiras.add(new Barreira(context, grade, 5, 12));
            this.barreiras.add(new Barreira(context, grade, 9, 10));
            this.barreiras.add(new Barreira(context, grade, 11, 8));
        return this.grade;
    }

    private Grade criarNivel3() {
        int quantidadeLinhas = 7;
        int quantidadeColunas = 7;
        this.nivel = 3;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 11, 3);
        this.chegada = new Chegada(context, grade, 1, 13);
        this.barreiras.add(new Barreira(context, grade, 0, 1));
        this.barreiras.add(new Barreira(context, grade, 0, 11));
        this.barreiras.add(new Barreira(context, grade, 1, 6));
        this.barreiras.add(new Barreira(context, grade, 2, 3));
        this.barreiras.add(new Barreira(context, grade, 3, 8));
        this.barreiras.add(new Barreira(context, grade, 5, 14));
        this.barreiras.add(new Barreira(context, grade, 6, 9));
        this.barreiras.add(new Barreira(context, grade, 7, 2));
        this.barreiras.add(new Barreira(context, grade, 9, 12));
        this.barreiras.add(new Barreira(context, grade, 10, 5));
        this.barreiras.add(new Barreira(context, grade, 11, 0));
        this.barreiras.add(new Barreira(context, grade, 11, 8));
        this.barreiras.add(new Barreira(context, grade, 13, 10));
        this.barreiras.add(new Barreira(context, grade, 14, 3));
        return this.grade;
    }

    private Grade criarNivel4() {
        int quantidadeLinhas = 7;
        int quantidadeColunas = 7;
        this.nivel = 4;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 11, 3);
        this.chegada = new Chegada(context, grade, 3, 11);
        this.barreiras.add(new Barreira(context, grade, 0, 3));
        this.barreiras.add(new Barreira(context, grade, 1, 10));
        this.barreiras.add(new Barreira(context, grade, 4, 1));
        this.barreiras.add(new Barreira(context, grade, 5, 14));
        this.barreiras.add(new Barreira(context, grade, 7, 12));
        this.barreiras.add(new Barreira(context, grade, 8, 9));
        this.barreiras.add(new Barreira(context, grade, 11, 0));
        this.barreiras.add(new Barreira(context, grade, 14, 1));
        this.barreiras.add(new Barreira(context, grade, 14, 3));
        this.barreiras.add(new Barreira(context, grade, 14, 13));
        return this.grade;
    }

    private Grade criarNivel5() {
        int quantidadeLinhas = 8;
        int quantidadeColunas = 8;
        this.nivel = 5;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 13, 5);
        this.chegada = new Chegada(context, grade, 5, 9);
        this.barreiras.add(new Barreira(context, grade, 0, 1));
        this.barreiras.add(new Barreira(context, grade, 1, 16));
        this.barreiras.add(new Barreira(context, grade, 2, 13));
        this.barreiras.add(new Barreira(context, grade, 3, 6));
        this.barreiras.add(new Barreira(context, grade, 4, 5));
        this.barreiras.add(new Barreira(context, grade, 5, 0));
        this.barreiras.add(new Barreira(context, grade, 5, 8));
        this.barreiras.add(new Barreira(context, grade, 6, 15));
        this.barreiras.add(new Barreira(context, grade, 8, 11));
        this.barreiras.add(new Barreira(context, grade, 9, 16));
        this.barreiras.add(new Barreira(context, grade, 10, 1));
        this.barreiras.add(new Barreira(context, grade, 11, 12));
        this.barreiras.add(new Barreira(context, grade, 12, 7));
        this.barreiras.add(new Barreira(context, grade, 13, 0));
        this.barreiras.add(new Barreira(context, grade, 13, 16));
        this.barreiras.add(new Barreira(context, grade, 15, 8));
        this.barreiras.add(new Barreira(context, grade, 16, 13));
        return this.grade;
    }

    private Grade criarNivel6() {
        int quantidadeLinhas = 8;
        int quantidadeColunas = 8;
        this.nivel = 6;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 11, 7);
        this.chegada = new Chegada(context, grade, 9, 9);
        this.barreiras.add(new Barreira(context, grade, 0, 15));
        this.barreiras.add(new Barreira(context, grade, 1, 10));
        this.barreiras.add(new Barreira(context, grade, 2, 1));
        this.barreiras.add(new Barreira(context, grade, 2, 3));
        this.barreiras.add(new Barreira(context, grade, 3, 16));
        this.barreiras.add(new Barreira(context, grade, 4, 15));
        this.barreiras.add(new Barreira(context, grade, 5, 2));
        this.barreiras.add(new Barreira(context, grade, 7, 0));
        this.barreiras.add(new Barreira(context, grade, 7, 10));
        this.barreiras.add(new Barreira(context, grade, 10, 7));
        this.barreiras.add(new Barreira(context, grade, 11, 0));
        this.barreiras.add(new Barreira(context, grade, 11, 16));
        this.barreiras.add(new Barreira(context, grade, 13, 10));
        this.barreiras.add(new Barreira(context, grade, 14, 3));
        this.barreiras.add(new Barreira(context, grade, 14, 15));
        this.barreiras.add(new Barreira(context, grade, 15, 6));
        this.barreiras.add(new Barreira(context, grade, 16, 11));
        return this.grade;
    }

    private Grade criarNivel7() {
        int quantidadeLinhas = 9;
        int quantidadeColunas = 9;
        this.nivel = 7;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 3, 3);
        this.chegada = new Chegada(context, grade, 15, 5);
        this.barreiras.add(new Barreira(context, grade, 0, 1));
        this.barreiras.add(new Barreira(context, grade, 0, 7));
        this.barreiras.add(new Barreira(context, grade, 1, 12));
        this.barreiras.add(new Barreira(context, grade, 3, 0));
        this.barreiras.add(new Barreira(context, grade, 3, 8));
        this.barreiras.add(new Barreira(context, grade, 4, 13));
        this.barreiras.add(new Barreira(context, grade, 5, 18));
        this.barreiras.add(new Barreira(context, grade, 6, 9));
        this.barreiras.add(new Barreira(context, grade, 7, 0));
        this.barreiras.add(new Barreira(context, grade, 9, 14));
        this.barreiras.add(new Barreira(context, grade, 10, 3));
        this.barreiras.add(new Barreira(context, grade, 11, 16));
        this.barreiras.add(new Barreira(context, grade, 13, 8));
        this.barreiras.add(new Barreira(context, grade, 14, 1));
        this.barreiras.add(new Barreira(context, grade, 14, 11));
        this.barreiras.add(new Barreira(context, grade, 14, 17));
        this.barreiras.add(new Barreira(context, grade, 17, 2));
        this.barreiras.add(new Barreira(context, grade, 17, 18));
        this.barreiras.add(new Barreira(context, grade, 18, 7));
        return this.grade;
    }

    private Grade criarNivel8() {
        int quantidadeLinhas = 9;
        int quantidadeColunas = 9;
        this.nivel = 8;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 7, 11);
        this.chegada = new Chegada(context, grade, 5, 13);
        this.barreiras.add(new Barreira(context, grade, 0, 1));
        this.barreiras.add(new Barreira(context, grade, 0, 17));
        this.barreiras.add(new Barreira(context, grade, 1, 10));
        this.barreiras.add(new Barreira(context, grade, 1, 14));
        this.barreiras.add(new Barreira(context, grade, 2, 3));
        this.barreiras.add(new Barreira(context, grade, 3, 14));
        this.barreiras.add(new Barreira(context, grade, 4, 11));
        this.barreiras.add(new Barreira(context, grade, 5, 0));
        this.barreiras.add(new Barreira(context, grade, 5, 12));
        this.barreiras.add(new Barreira(context, grade, 7, 4));
        this.barreiras.add(new Barreira(context, grade, 8, 15));
        this.barreiras.add(new Barreira(context, grade, 9, 2));
        this.barreiras.add(new Barreira(context, grade, 10, 9));
        this.barreiras.add(new Barreira(context, grade, 11, 0));
        this.barreiras.add(new Barreira(context, grade, 11, 16));
        this.barreiras.add(new Barreira(context, grade, 12, 11));
        this.barreiras.add(new Barreira(context, grade, 13, 18));
        this.barreiras.add(new Barreira(context, grade, 14, 5));
        this.barreiras.add(new Barreira(context, grade, 15, 18));
        this.barreiras.add(new Barreira(context, grade, 16, 1));
        this.barreiras.add(new Barreira(context, grade, 16, 15));
        this.barreiras.add(new Barreira(context, grade, 18, 9));
        return this.grade;
    }

    private Grade criarNivel9() {
        int quantidadeLinhas = 10;
        int quantidadeColunas = 10;
        this.nivel = 9;
        this.grade = new Grade(context, quantidadeLinhas, quantidadeColunas, larguraTela, alturaTela);
        this.marcador = new Marcador(context, grade, 11, 9);
        this.chegada = new Chegada(context, grade, 11, 11);
        this.barreiras.add(new Barreira(context, grade, 0, 1));
        this.barreiras.add(new Barreira(context, grade, 0, 15));
        this.barreiras.add(new Barreira(context, grade, 1, 6));
        this.barreiras.add(new Barreira(context, grade, 3, 16));
        this.barreiras.add(new Barreira(context, grade, 4, 5));
        this.barreiras.add(new Barreira(context, grade, 5, 0));
        this.barreiras.add(new Barreira(context, grade, 5, 20));
        this.barreiras.add(new Barreira(context, grade, 8, 9));
        this.barreiras.add(new Barreira(context, grade, 9, 0));
        this.barreiras.add(new Barreira(context, grade, 9, 14));
        this.barreiras.add(new Barreira(context, grade, 11, 10));
        this.barreiras.add(new Barreira(context, grade, 11, 20));
        this.barreiras.add(new Barreira(context, grade, 12, 15));
        this.barreiras.add(new Barreira(context, grade, 13, 6));
        this.barreiras.add(new Barreira(context, grade, 14, 1));
        this.barreiras.add(new Barreira(context, grade, 17, 10));
        this.barreiras.add(new Barreira(context, grade, 18, 5));
        this.barreiras.add(new Barreira(context, grade, 18, 19));
        this.barreiras.add(new Barreira(context, grade, 19, 0));
        this.barreiras.add(new Barreira(context, grade, 20, 13));
        return this.grade;
    }
}
