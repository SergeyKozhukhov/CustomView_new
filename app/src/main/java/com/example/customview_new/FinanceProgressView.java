package com.example.customview_new;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class FinanceProgressView extends View{

    private static final Paint BACKGROUND_CIRCLE_PAINT = new Paint(Paint.CURSOR_AFTER);
    private static final Paint FRONT_ARC_PAINT = new Paint(Paint.CURSOR_AFTER);
    private static final float STROKE_WIDTH = 50f;
    private static final float RADIUS = 400f;
    private static final RectF Rectangle= new RectF(0,0,2*RADIUS, 2*RADIUS);





    public FinanceProgressView(Context context) {
        this(context, null,0);
    }

    public FinanceProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, null,0);

    }

    public FinanceProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs,0);
        init();
    }



    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawCircle(RADIUS + STROKE_WIDTH/2,RADIUS + STROKE_WIDTH/2, RADIUS + STROKE_WIDTH/2, BACKGROUND_CIRCLE_PAINT);
        canvas.drawArc(Rectangle, 0, 45, false, FRONT_ARC_PAINT);
    }

    private void init()
    {
        BACKGROUND_CIRCLE_PAINT.setColor(Color.GRAY);
        BACKGROUND_CIRCLE_PAINT.setStyle(Paint.Style.STROKE);
        BACKGROUND_CIRCLE_PAINT.setStrokeWidth(STROKE_WIDTH);

        FRONT_ARC_PAINT.setColor(Color.GREEN);
        FRONT_ARC_PAINT.setStyle(Paint.Style.STROKE);


    }



}
