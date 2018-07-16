package com.example.hengwang.mywanzi.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public abstract class BaseLoveFrameView extends View implements ValueAnimator.AnimatorUpdateListener {

    //    protected static final int MAX_VAL_COUNT = 1000;
    protected static final int TIME_INTERVAL = 4800;
    protected static final int SUBSECTION = 4;
    protected static final int mDotRadius = 8;

    PathMeasure mPathMeasure = null;

    Path mDrawPath = new Path();
    protected int mHeight = 0;
    protected int mWidth = 0;
    protected int mTopCirclrRadius = 0;
    protected int mCentX = 0;
    protected int mCentY = 0;

    protected int mLeftPos = 0;
    protected int mRightPos = 0;

    protected int mTop = 0;
    protected int mBottom = 0;

    protected Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    protected static final int[] GRADUAL_COLOR = new int[]{
            Color.parseColor("#1976D2"),
            Color.parseColor("#5E35B1"),
            Color.parseColor("#ef5350"),
            Color.parseColor("#D81B60"),
            Color.parseColor("#F57F17"),
            Color.parseColor("#FF5722"),
            Color.parseColor("#6A1B9A"),
    };

    private ValueAnimator mLoveAnimation = ValueAnimator.ofFloat(0, 1);

    private float mValue = 0;
    private int mRepeatIndex = 0;


    public BaseLoveFrameView(Context context) {
        super(context);
    }

    public BaseLoveFrameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseLoveFrameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseLoveFrameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mTopCirclrRadius = mWidth / SUBSECTION - mDotRadius;
        mCentX = mWidth / 2;
        mCentY = mHeight / 2;

        mLeftPos = mCentX - 2 * mTopCirclrRadius;
        mRightPos = mCentX + 2 * mTopCirclrRadius;

        mTop = mDotRadius;
        mBottom = (int) (3.2 * mTopCirclrRadius);

        makePath();

        startAnimation();
    }

    private void makePath() {

        mDrawPath.moveTo(mCentX, mTopCirclrRadius);
        mDrawPath.arcTo(new RectF(mCentX, mTop, mRightPos, 0 + 2 * mTopCirclrRadius),
                180, 180);
        mDrawPath.cubicTo(mRightPos, 2.2F * mTopCirclrRadius, mCentX, mCentY * 1.1F, mCentX, mBottom);
        mDrawPath.cubicTo(mCentX, mCentY * 1.1F, mLeftPos, 2.2F * mTopCirclrRadius, mLeftPos, mTopCirclrRadius);

        mDrawPath.arcTo(new RectF(mLeftPos, mTop, mCentX, 0 + 2 * mTopCirclrRadius),
                180, 180);

        mDrawPath.close();

        mPathMeasure = new PathMeasure(mDrawPath, false);

        mLoveAnimation.setFloatValues(0, mPathMeasure.getLength());
    }

    public void startAnimation() {
        if (!mLoveAnimation.isStarted()) {
            clearAnimation();
            mLoveAnimation.setDuration(TIME_INTERVAL);
            mLoveAnimation.setRepeatCount(ValueAnimator.INFINITE);
            mLoveAnimation.setRepeatMode(ValueAnimator.RESTART);
            mLoveAnimation.addUpdateListener(this);
            mLoveAnimation.setInterpolator(new LinearInterpolator());
            mLoveAnimation.start();
        }
    }

    public void clearAnimation() {
        mLoveAnimation.cancel();
    }

    public float getValue() {
        return mValue;
    }

    public int getCurrentRepeatTimes() {
        return mRepeatIndex;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float val = (float) animation.getAnimatedValue();

        if (mValue > val) {
            ++mRepeatIndex;
        }

        mValue = val;
        onValueUpdated(val);
    }

    protected abstract void onValueUpdated(float value);
}
