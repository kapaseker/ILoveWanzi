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
    protected static final int TIME_INTERVAL = 6000;
    protected static final int SUBSECTION = 4;
    protected static final int mDotRadius = 6;

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
            Color.parseColor("#F48FB1"),
            Color.parseColor("#F06292"),
            Color.parseColor("#EC407A"),
            Color.parseColor("#E91E63"),
            Color.parseColor("#D81B60"),
            Color.parseColor("#C2185B"),
            Color.parseColor("#AD1457"),
    };

    private ValueAnimator mLoveAnimation = null;
    private float mValue = 0;


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
        mTopCirclrRadius = mWidth / SUBSECTION - mDotRadius / 2;
        mCentX = mWidth / 2;
        mCentY = mHeight / 2;

        mLeftPos = mCentX - 2 * mTopCirclrRadius;
        mRightPos = mCentX + 2 * mTopCirclrRadius;

        mTop = mDotRadius / 2;
        mBottom = (int) (3.2 * mTopCirclrRadius);

        makePath();
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

        mLoveAnimation = ValueAnimator.ofFloat(0, mPathMeasure.getLength());

    }

    public void startAnimation() {
        if (!mLoveAnimation.isRunning()) {
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

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float val = (float) animation.getAnimatedValue();
        mValue = val;
        onValueUpdated(val);
    }

    protected abstract void onValueUpdated(float value);
}
