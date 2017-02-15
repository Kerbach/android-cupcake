package com.jdenner.escape;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jdenner.escape.model.Celula;
import com.jdenner.escape.model.Jogo;
import com.jdenner.escape.model.Movimento;
import com.jdenner.escape.util.Animacao;
import com.jdenner.escape.util.Gesto;

import java.text.NumberFormat;

/**
 * Created by Juliano on 02/12/2016.
 */

public class JogoActivity extends Activity {

    private RelativeLayout area;
    private TextView textViewNumeroNivel;
    private TextView textViewNumeroMovimentos;
    private GestureDetector gestos;
    private Jogo jogo;
    private Celula celulaAtual;
    private boolean novoNivel = false;
    private int nivel = 0;
    private int movimentos = 0;
    private NumberFormat nf = NumberFormat.getIntegerInstance();
    private boolean saiu = false;
    private Movimento movimento;
    private int passadas = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        setFonte();

        DisplayMetrics metricas = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metricas);

        this.area = (RelativeLayout) findViewById(R.id.area);
        this.textViewNumeroMovimentos = (TextView) findViewById(R.id.textViewNumeroMovimentos);
        this.textViewNumeroNivel = (TextView) findViewById(R.id.textViewNumeroNivel);
        this.novoNivel = getIntent().getExtras().getBoolean("novoNivel");
        this.nivel = getIntent().getExtras().getInt("nivel");
        this.jogo = new Jogo(getApplicationContext(), metricas, nivel);
        this.celulaAtual = jogo.getGrade().getCelula(jogo.getMarcador().getLinhaInicial(), jogo.getMarcador().getColunaInicial());
        this.gestos = new GestureDetector(getApplicationContext(), new Gesto() {
            @Override
            public void paraBaixo() {
                moverParaBaixo();
            }

            @Override
            public void paraCima() {
                moverParaCima();
            }

            @Override
            public void paraDireita() {
                moverParaDireita();
            }

            @Override
            public void paraEsquerda() {
                moverParaEsquerda();
            }
        });

        carregar();
    }

    private void setFonte() {
        try {
            Typeface font = Typeface.createFromAsset(getAssets(), "Orbitron.ttf");
            ((TextView) findViewById(R.id.textViewNivel)).setTypeface(font);
            ((TextView) findViewById(R.id.textViewNumeroNivel)).setTypeface(font);
            ((TextView) findViewById(R.id.textViewMovimentos)).setTypeface(font);
            ((TextView) findViewById(R.id.textViewNumeroMovimentos)).setTypeface(font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestos.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void carregar() {
        this.area.removeView(jogo.getGrade());
        this.area.addView(jogo.get(nivel));
        this.textViewNumeroNivel.setText(nf.format(jogo.getNivel()));
        this.textViewNumeroMovimentos.setText(nf.format(movimentos));
    }

    private boolean ehChegada(Celula celula) {
        if (celula.getLinha() == jogo.getChegada().getLinha() && celula.getColuna() == jogo.getChegada().getColuna()) {
            return true;
        } else {
            return false;
        }
    }

    private void mover() {
        celulaAtual = jogo.getGrade().getCelula(celulaAtual.getLinha(), celulaAtual.getColuna());
        textViewNumeroMovimentos.setText(nf.format(++movimentos));
        jogo.getMarcador().animate()
                .x(celulaAtual.getX())
                .y(celulaAtual.getY())
                //.alpha(saiu ? 0 : 1)
                .setListener(new Animacao() {
                    @Override
                    public void aoIniciar() {
                        if (!ehChegada(celulaAtual) && !saiu) {
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.mover);
                            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp.release();
                                }

                            });
                            mp.start();
                        }
                    }

                    @Override
                    public void aoFinalizar() {
                        if (ehChegada(celulaAtual)) {
                            Intent intent = new Intent(getApplicationContext(), SucessoActivity.class);
                            intent.putExtra("salvar", novoNivel);
                            intent.putExtra("nivel", nivel);
                            intent.putExtra("movimentos", movimentos);
                            startActivity(intent);
                            finish();
                        } else if (saiu) {
                            passadas++;
                            saiu = false;

                            if (passadas == 3) {
                                Intent intent = new Intent(getApplicationContext(), FalhaActivity.class);
                                intent.putExtra("salvar", novoNivel);
                                intent.putExtra("nivel", nivel);
                                startActivity(intent);
                                finish();
                            } else {
                                switch (movimento) {
                                    case ESQUERDA:
                                        celulaAtual = jogo.getGrade().getCelula(celulaAtual.getLinha(), jogo.getGrade().getQuantidadeColunas() - 1);
                                        moverParaEsquerda();
                                    case DIREITA:
                                        celulaAtual = jogo.getGrade().getCelula(celulaAtual.getLinha(), 0);
                                        moverParaDireita();
                                    case ABAIXO:
                                        celulaAtual = jogo.getGrade().getCelula(0, celulaAtual.getColuna());
                                        moverParaBaixo();
                                    case ACIMA:
                                        celulaAtual = jogo.getGrade().getCelula(jogo.getGrade().getQuantidadeLinhas() - 1, celulaAtual.getColuna());
                                        moverParaCima();
                                }
                            }

                        }
                    }
                }).start();
    }

    private void moverParaEsquerda() {
        movimento = Movimento.ESQUERDA;
        while (!celulaAtual.getCelulaEsquerda().isSolido()) {
            celulaAtual = celulaAtual.getCelulaEsquerda();
            if (ehChegada(celulaAtual)) {
                break;
            } else if (saiu = celulaAtual.getCelulaEsquerda() == null) {
                break;
            }
        }
        mover();
    }

    private void moverParaDireita() {
        movimento = Movimento.DIREITA;
        while (!celulaAtual.getCelulaDireita().isSolido()) {
            celulaAtual = celulaAtual.getCelulaDireita();
            if (ehChegada(celulaAtual)) {
                break;
            } else if (saiu = celulaAtual.getCelulaDireita() == null) {
                break;
            }
        }
        mover();
    }

    private void moverParaCima() {
        movimento = Movimento.ACIMA;
        while (!celulaAtual.getCelulaAcima().isSolido()) {
            celulaAtual = celulaAtual.getCelulaAcima();
            if (ehChegada(celulaAtual)) {
                break;
            } else if (saiu = celulaAtual.getCelulaAcima() == null) {
                break;
            }
        }
        mover();
    }

    private void moverParaBaixo() {
        movimento = Movimento.ABAIXO;
        while (!celulaAtual.getCelulaAbaixo().isSolido()) {
            celulaAtual = celulaAtual.getCelulaAbaixo();
            if (ehChegada(celulaAtual)) {
                break;
            } else if (saiu = celulaAtual.getCelulaAbaixo() == null) {
                break;
            }
        }
        mover();
    }
}
