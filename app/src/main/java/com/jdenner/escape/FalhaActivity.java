package com.jdenner.escape;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Juliano on 02/12/2016.
 */

public class FalhaActivity extends Activity {

    private boolean salvar = false;
    private int nivel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falha);
        setFonte();

        salvar = getIntent().getExtras().getBoolean("salvar");
        nivel = getIntent().getExtras().getInt("nivel");

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.falha);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }

        });
        mp.start();

        new Timer().schedule(new AbrirJogo(), 2000);
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

    private class AbrirJogo extends TimerTask {

        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), JogoActivity.class);
            intent.putExtra("novoNivel", salvar);
            intent.putExtra("nivel", nivel);
            startActivity(intent);
            finish();
        }
    }
}
