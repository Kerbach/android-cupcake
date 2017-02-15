package com.jdenner.escape;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Juliano on 02/12/2016.
 */

public class AberturaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);
        new Timer().schedule(new AbrirMenu(), 2000);
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
