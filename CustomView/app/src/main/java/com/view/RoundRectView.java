package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nicestars on 2017/12/26.
 */

public class RoundRectView extends View {
    public RoundRectView(Context context) {
        super(context);
    }

    public RoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        Paint paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
         //x
        canvas.drawLine(50,50,1000,50,paint);

        //y
        canvas.drawLine(50,50,50,1000,paint);
        //x1
        canvas.drawLine(50,450,1000,450,paint);
        //y1
        canvas.drawLine(450,50,450,1000,paint);
        paint.setColor(Color.RED);
        RectF rectF=new RectF(450,450,850,850);

        canvas.drawRoundRect(rectF,150,50,paint);
    }
}
