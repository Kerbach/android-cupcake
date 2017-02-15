package com.jdenner.escape.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Juliano on 01/12/2016.
 */

public class Converter {

    public static int dpiEmPixel(Context context, int dpi) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpi, context.getResources().getDisplayMetrics());
    }
}
