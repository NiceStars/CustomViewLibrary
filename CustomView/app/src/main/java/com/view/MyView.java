package com.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

/**
 * Created by nicestars on 2017/9/28.
 */

public class MyView extends View {

    private String mtext;
    private int msrc;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        int resourceId = 0;
        int textId = attrs.getAttributeResourceValue(null, "Text",0);
        int srcId = attrs.getAttributeResourceValue(null, "Src", 0);
        mtext = context.getResources().getText(textId).toString();
        msrc = srcId;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        InputStream is = getResources().openRawResource(msrc);
        Bitmap mBitmap = BitmapFactory.decodeStream(is);
        int bh = mBitmap.getHeight();
        int bw = mBitmap.getWidth();
        canvas.drawBitmap(mBitmap, 0,0, paint);
        //canvas.drawCircle(40, 90, 15, paint);
       // canvas.drawText(mtext, bw/2, 30, paint);
        canvas.drawText(mtext, 10, 30, paint);
        canvas.drawText(mtext, 10, bh, paint);

    }
}