package com.jdenner.escape;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jdenner.escape.dao.NivelDao;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Juliano on 02/12/2016.
 */

public class SucessoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso);
        setFonte();

        boolean salvar = getIntent().getExtras().getBoolean("salvar");
        int nivel = getIntent().getExtras().getInt("nivel");
        int movimentos = getIntent().getExtras().getInt("movimentos");

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.sucesso);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }

        });
        mp.start();

        if (salvar) {
            salvar(nivel, movimentos);
            new Timer().schedule(new AbrirMenu(), 2000);
        } else {
            new Timer().schedule(new AbrirMenu(), 2000);
        }

    }

    private void setFonte() {
        try {
            Typeface font = Typeface.createFromAsset(getAssets(), "Orbitron.ttf");
            TextView textViewNome = (TextView) findViewById(R.id.textView);
            textViewNome.setTypeface(font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void salvar(int nivel, int movimentos) {
        try {
            NivelDao.inserir(getApplicationContext(), nivel, movimentos);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao salvar!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private class AbrirMenu extends TimerTask {

        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

}

