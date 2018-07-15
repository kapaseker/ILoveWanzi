package com.example.hengwang.mywanzi.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class LoveView extends DotDrawView {

    public LoveView(Context context) {
        super(context);
    }

    public LoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onValueUpdated(float value) {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(GRADUAL_COLOR[3]);
        mPaint.setStrokeWidth(mDotRadius / 2);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawPath(mDrawPath, mPaint);
    }
}
