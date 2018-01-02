package com.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.customview.R;

/**
 * Created by nicestars on 2017/12/20.
 */

public class MoneyView extends RelativeLayout {

    private Button btn;
    private TextView lefttext;
    private TextView righttext;
    private TextView moneycounttext;
    private String leftsign;
    private String rightsign;
    private String moneycount;
    private float leftsignsize;
    private float moneycountsize;
    private float rightsignsize;
    private int leftsigncolor;
    private int rightsigncolor;
    private int moneycountcolor;
    private ImageView imageView;


    private LayoutParams lefttextparams, righttextparams, moneycountparams, btnparams, imageviewparams;

    private moneyviewOnClickListener listener;

    public interface moneyviewOnClickListener {
        void btnlistener();

    }

    public void setMoneyViewOnclicklistener(moneyviewOnClickListener listener) {

        this.listener = listener;
    }




    public MoneyView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MoneyView);

        leftsign = typedArray.getString(R.styleable.MoneyView_LeftSign);
        rightsign = typedArray.getString(R.styleable.MoneyView_RightSign);
        moneycount = typedArray.getString(R.styleable.MoneyView_Count);
        moneycountcolor = typedArray.getColor(R.styleable.MoneyView_CountColor, 0);
        moneycountsize = typedArray.getDimension(R.styleable.MoneyView_CountSize, 0);
        leftsignsize = typedArray.getDimension(R.styleable.MoneyView_LeftSignTextSize, 0);
        rightsignsize = typedArray.getDimension(R.styleable.MoneyView_RightSignTextSize, 0);
        leftsigncolor = typedArray.getColor(R.styleable.MoneyView_LeftSignTextColor, 0);
        rightsigncolor = typedArray.getColor(R.styleable.MoneyView_RightSignTextColor, 0);

        //内存回收  避免浪费资源
        typedArray.recycle();


        btn = new Button(context);
        btn.setBackgroundResource(R.drawable.btn_bg);

        btnparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(btn, btnparams);


        moneycounttext = new TextView(context);
        moneycounttext.setTextColor(moneycountcolor);
        moneycounttext.setText(moneycount);
        moneycounttext.setTextSize(moneycountsize);

        lefttext = new TextView(context);
        lefttext.setText(leftsign);
        lefttext.setTextColor(leftsigncolor);
        lefttext.setTextSize(leftsignsize);

        righttext = new TextView(context);
        righttext.setText(rightsign);
        righttext.setTextColor(rightsigncolor);
        righttext.setTextSize(rightsignsize);


        lefttextparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lefttextparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        lefttextparams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        lefttextparams.leftMargin = 20;
        addView(lefttext, lefttextparams);

        imageView = new ImageView(context);
        imageView.setBackgroundResource(R.mipmap.ic_vertical);
        imageviewparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
       // imageviewparams.leftMargin = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics()))/3;
        imageviewparams.leftMargin=
        imageviewparams.topMargin=10;
        imageviewparams.bottomMargin=10;
        imageviewparams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        addView(imageView, imageviewparams);

        moneycountparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        moneycountparams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(moneycounttext, moneycountparams);

        righttextparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        righttextparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        righttextparams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        righttextparams.rightMargin = 20;

        addView(righttext, righttextparams);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.btnlistener();

            }
        });
    }
}
