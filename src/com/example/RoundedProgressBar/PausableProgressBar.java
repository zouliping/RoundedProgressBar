package com.example.RoundedProgressBar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;

/**
 * 可暂停的圆形进度条
 * Author: zouliping
 * Date: 2014-07-22
 */
public class PausableProgressBar extends RoundedProgressBar {

    private Paint paint;

    private int pauseBarColor;

    private float pauseBarWidth;

    private float pauseBarHeight;

    private int pauseBarAlpha;

    private int status;

    private static final int STATUS_DOWNLOADING = 0;

    private static final int STATUS_PAUSE = 1;


    public PausableProgressBar(Context context) {
        this(context, null);
    }

    public PausableProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PausableProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();

        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.PausableProgressBar);
        Resources mResources = context.getResources();

        pauseBarColor = mTypedArray.getColor(R.styleable.PausableProgressBar_pauseBarColor, mResources.getColor(R.color.pauseBarColor));
        pauseBarWidth = mTypedArray.getDimension(R.styleable.PausableProgressBar_pauseBarWidth, mResources.getDimension(R.dimen.pauseBarWidth));
        pauseBarHeight = mTypedArray.getDimension(R.styleable.PausableProgressBar_pauseBarHeight, mResources.getDimension(R.dimen.pauseBarHeight));
        pauseBarAlpha = mTypedArray.getInteger(R.styleable.PausableProgressBar_pauseBarAlpha, mResources.getInteger(R.integer.pauseBarAlpha));
        status = mTypedArray.getInt(R.styleable.PausableProgressBar_status, mResources.getInteger(R.integer.status));

        mTypedArray.recycle();
    }

    public int getPauseBarColor() {
        return pauseBarColor;
    }

    public void setPauseBarColor(int pauseBarColor) {
        this.pauseBarColor = pauseBarColor;
        invalidate();
    }

    public float getPauseBarWidth() {
        return pauseBarWidth;
    }

    public void setPauseBarWidth(float pauseBarWidth) {
        this.pauseBarWidth = pauseBarWidth;
        invalidate();
    }

    public float getPauseBarHeight() {
        return pauseBarHeight;
    }

    public void setPauseBarHeight(float pauseBarHeight) {
        this.pauseBarHeight = pauseBarHeight;
        invalidate();
    }

    public int getPauseBarAlpha() {
        return pauseBarAlpha;
    }

    public void setPauseBarAlpha(int pauseBarAlpha) {
        this.pauseBarAlpha = pauseBarAlpha;
        invalidate();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int centerX = getWidth() / 2; // 圆心的x坐标
        int centerY = getHeight() / 2; // 圆心的y坐标

        switch (status){
            case STATUS_DOWNLOADING:{
                setDisplayText(true);
            }
            break;

            case STATUS_PAUSE:{
                // 不显示进度百分比
                setDisplayText(false);

                paint.setColor(pauseBarColor);
                paint.setStyle(Paint.Style.FILL);
                paint.setAlpha(pauseBarAlpha);

                paint.setAntiAlias(true);

                canvas.drawRect(centerX - 3 * pauseBarWidth / 2, centerY - pauseBarHeight / 2, centerX - pauseBarWidth / 2, centerY + pauseBarHeight / 2, paint);
                canvas.drawRect(centerX +  pauseBarWidth / 2, centerY - pauseBarHeight / 2, centerX + 3 * pauseBarWidth / 2, centerY + pauseBarHeight / 2, paint);
            }
            break;
        }
    }
}
