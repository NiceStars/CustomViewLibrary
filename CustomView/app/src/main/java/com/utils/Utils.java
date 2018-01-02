package com.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by nicestars on 2017/12/27.
 */

public class Utils {

    //dp转px
    public static int Dp2Px(Context context, int dpi) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpi, context.getResources().getDisplayMetrics());
    }

    //px转dp
    public static int Px2Dp(Context context, int px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, context.getResources().getDisplayMetrics());
    }


}
