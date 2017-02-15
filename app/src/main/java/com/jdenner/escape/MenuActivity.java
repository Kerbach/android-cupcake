package com.jdenner.escape;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jdenner.escape.dao.NivelDao;

/**
 * Created by Juliano on 02/12/2016.
 */

public class MenuActivity extends Activity {


    private int nivelAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setFonte();
        setNivelAtual();
        setDisable();
        setConcluido();
    }

    private void setFonte() {
        try {
            Typeface font = Typeface.createFromAsset(getAssets(), "Orbitron.ttf");
            TextView textViewNome = (TextView) findViewById(R.id.textViewNome);
            textViewNome.setTypeface(font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNivelAtual() {
        try {
            this.nivelAtual = NivelDao.nivelAtual(getApplicationContext());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao consultar histórico!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void setDisable() {
        GridLayout menu = (GridLayout) findViewById(R.id.menu);
        for (int i = nivelAtual + 1; i < menu.getChildCount(); i++) {
            menu.getChildAt(i).setEnabled(false);
        }
    }

    private void setConcluido() {
        GridLayout menu = (GridLayout) findViewById(R.id.menu);
        for (int i = 0; i < nivelAtual; i++) {
            ((ImageButton) menu.getChildAt(i)).setImageResource(R.drawable.ic_chegada);
        }
    }

    public void handle(View view) {
        if (!view.isClickable()) return;
        int nivel = Integer.parseInt(view.getTag().toString());
        Intent intent = new Intent(getApplicationContext(), JogoActivity.class);
        intent.putExtra("novoNivel", nivelAtual < nivel);
        intent.putExtra("nivel", nivel);
        startActivity(intent);
    }


}
