package com.jdenner.escape.util;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Juliano on 02/12/2016.
 */

public class Gesto extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float difX = e1.getX() - e2.getX();
        float difY = e1.getY() - e2.getY();
        if (Math.abs(difX) > Math.abs(difY)) {
            if (difX > 0) {
                paraEsquerda();
            } else {
                paraDireita();
            }
        } else {
            if (difY > 0) {
                paraCima();
            } else {
                paraBaixo();
            }
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void paraBaixo() {
        throw new UnsupportedOperationException();
    }

    public void paraCima() {
        throw new UnsupportedOperationException();
    }

    public void paraDireita() {
        throw new UnsupportedOperationException();
    }

    public void paraEsquerda() {
        throw new UnsupportedOperationException();
    }
}
