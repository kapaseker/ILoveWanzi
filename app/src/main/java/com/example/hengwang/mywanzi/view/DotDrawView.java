package com.example.hengwang.mywanzi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

public class DotDrawView extends BaseLoveFrameView {


    public DotDrawView(Context context) {
        super(context);
    }

    public DotDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DotDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DotDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onValueUpdated(float value) {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float[] pos = new float[2];
        mPathMeasure.getPosTan(getValue(), pos, null);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(GRADUAL_COLOR[getCurrentRepeatTimes() % GRADUAL_COLOR.length]);
        canvas.drawCircle(pos[0], pos[1], mDotRadius, mPaint);
    }
}
