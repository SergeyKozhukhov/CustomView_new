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
    private static final Paint TEXT_PAINT = new Paint(Paint.CURSOR_AFTER);
    private static final float STROKE_WIDTH = 50f;
    private static final float RADIUS = 400f;
    private static final int FONT_SIZE = 128;
    private static final RectF ARC_RECT = new RectF(STROKE_WIDTH/2,STROKE_WIDTH/2,2*RADIUS, 2*RADIUS);



    private static final float MAX_ANGLE = 360f;
    private static final float START_ANGLE = -90f;


    private int mProgress = 0;


    public int getmProgress() {
        return mProgress;
    }

    public void setmProgress(int mProgress) {
        this.mProgress = mProgress;
        invalidate();
    }



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
        //canvas.drawCircle(RADIUS + STROKE_WIDTH/2,RADIUS + STROKE_WIDTH/2, RADIUS + STROKE_WIDTH/2, BACKGROUND_CIRCLE_PAINT);
        canvas.drawArc(ARC_RECT, 0, 360, false, BACKGROUND_CIRCLE_PAINT);
        canvas.drawArc(ARC_RECT, START_ANGLE , MAX_ANGLE+mProgress/100, false, FRONT_ARC_PAINT);
        canvas.drawLine(0, RADIUS + STROKE_WIDTH/2, 2*RADIUS + STROKE_WIDTH/2,RADIUS + STROKE_WIDTH/2, TEXT_PAINT);


        final String text = String.format("%d %%", mProgress);
        final float textWidth = TEXT_PAINT.measureText(text);
        canvas.drawText(text, RADIUS - FONT_SIZE, RADIUS+FONT_SIZE, TEXT_PAINT);
    }

    private void init()
    {
        BACKGROUND_CIRCLE_PAINT.setColor(Color.GRAY);
        BACKGROUND_CIRCLE_PAINT.setStyle(Paint.Style.STROKE);
        BACKGROUND_CIRCLE_PAINT.setStrokeWidth(STROKE_WIDTH);

        FRONT_ARC_PAINT.setColor(Color.GREEN);
        FRONT_ARC_PAINT.setStyle(Paint.Style.STROKE);
        FRONT_ARC_PAINT.setStrokeWidth(STROKE_WIDTH);

        TEXT_PAINT.setColor(Color.GREEN);
        TEXT_PAINT.setStyle(Paint.Style.FILL);

        TEXT_PAINT.setTextSize(FONT_SIZE);


    }



}
