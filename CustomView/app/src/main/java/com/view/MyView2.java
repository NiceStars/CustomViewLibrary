package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by nicestars on 2017/12/25.
 */

public class MyView2 extends View {

    private Paint mpaint;

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint = new Paint();

        //canvas.drawColor(Color.parseColor("#FF6A6A"));
        canvas.drawColor(Color.GRAY);

        mpaint.setColor(Color.BLACK);

        mpaint.setStyle(Paint.Style.STROKE);
        //画矩形1
        canvas.drawRect(100, 100, 200, 300, mpaint);
        //画线
        mpaint.setColor(Color.GREEN);
        canvas.drawLine(50, 50, 450, 50, mpaint);

        //画矩形2
        mpaint.setStyle(Paint.Style.FILL);

        mpaint.setColor(Color.BLUE);
        canvas.drawRect(300, 100, 400, 300, mpaint);

        // 画矩形3
        RectF r = new RectF(150, 500, 270, 600);
        canvas.drawRect(r, mpaint);

        mpaint.setColor(Color.YELLOW);
        //画圆
        canvas.drawCircle(50, 500, 50, mpaint);

        // 画椭圆
        RectF oval = new RectF(350, 500, 450, 700);
        canvas.drawOval(oval, mpaint);

        // 画圆角矩形
        RectF rect = new RectF(100, 700, 170, 800);
        canvas.drawRoundRect(rect, 30, 20, mpaint);

        //画弧线
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setColor(Color.RED);
        RectF re1 = new RectF(700, 50, 900, 250);
        canvas.drawArc(re1, 10, 190, false, mpaint);
        canvas.drawRect(re1,mpaint);
        RectF re2 = new RectF(700, 300, 900, 500);
        canvas.drawArc(re2, 10, 270, true, mpaint);
        canvas.drawRect(re2,mpaint);

        //设置Path路径
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setColor(Color.GREEN);
        mpaint.setStrokeWidth(3);
        Path path1 = new Path();
        path1.moveTo(500, 100);
        path1.lineTo(920, 80);
        path1.lineTo(720, 200);
        path1.lineTo(600, 400);
        path1.close();
        mpaint.setTextSize(46);
        canvas.drawPath(path1, mpaint);
        canvas.drawTextOnPath("这是个多边形", path1, -20, -20, mpaint);

        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setColor(Color.GREEN);
        mpaint.setStrokeWidth(3);
        //三角形
        Path path=new Path();
        path.moveTo(700, 1200);
        path.lineTo(700, 1600);
        path.lineTo(1000, 1200);
        path.close();
        canvas.drawPath(path, mpaint);
        canvas.drawTextOnPath("这是个直角三角形", path, 10, 40, mpaint);


    }
}
