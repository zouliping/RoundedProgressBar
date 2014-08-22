package com.example.RoundedProgressBar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * 圆形进度条
 * Author: zouliping
 * Date: 2014-07-17
 */
public class RoundedProgressBar extends View{

    private Paint paint;

    private int innerCircleColor; // 内圆的颜色

    private int progressBarColor; // 进度条的颜色

    private int ringColor; // 圆环的颜色

    private int innerCircleAlpha; // 内圆的透明度

    private int progressBarAlpha; // 进度条的透明度

    private int ringAlpha; // 圆环的透明度

    private float ringWidth; // 圆环的宽度

    private float innerCircleRadius; // 内圆半径

    private int max; // 最大进度

    private int currentProgress; // 当前进度

    private boolean isDisplayText; // 是否显示进度百分比

    private int textColor; // 进度百分比字体颜色

    private float textSize; // 进度百分比字体大小

    private boolean isStrokeStyle; // 进度条的风格，true为空心圆环，false为实心圆环


    public RoundedProgressBar(Context context) {
        this(context, null);
    }

    public RoundedProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundedProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();

        // 获取自定义属性
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundedProgressBar);
        Resources mResources = context.getResources();

        innerCircleColor = mTypedArray.getColor(R.styleable.RoundedProgressBar_innerCircleColor, mResources.getColor(R.color.innerCircleColor));
        progressBarColor = mTypedArray.getColor(R.styleable.RoundedProgressBar_progressBarColor, mResources.getColor(R.color.progressBarColor));
        ringColor = mTypedArray.getColor(R.styleable.RoundedProgressBar_ringColor, mResources.getColor(R.color.ringColor));
        innerCircleAlpha = mTypedArray.getInteger(R.styleable.RoundedProgressBar_innerCircleAlpha, mResources.getInteger(R.integer.innerCircleAlpha));
        progressBarAlpha = mTypedArray.getInteger(R.styleable.RoundedProgressBar_progressBarAlpha, mResources.getInteger(R.integer.progressBarAlpha));
        ringAlpha = mTypedArray.getInteger(R.styleable.RoundedProgressBar_ringAlpha, mResources.getInteger(R.integer.ringAlpha));
        ringWidth = mTypedArray.getDimension(R.styleable.RoundedProgressBar_ringWidth,  mResources.getDimension(R.dimen.ringWidth));
        innerCircleRadius = mTypedArray.getDimension(R.styleable.RoundedProgressBar_innerCircleRadius, mResources.getDimension(R.dimen.innerCircleRadius));
        max = mTypedArray.getInteger(R.styleable.RoundedProgressBar_max, mResources.getInteger(R.integer.max));
        currentProgress = mTypedArray.getInteger(R.styleable.RoundedProgressBar_currentProgress, mResources.getInteger(R.integer.currentProgress));
        isDisplayText = mTypedArray.getBoolean(R.styleable.RoundedProgressBar_isDisplayText, mResources.getBoolean(R.bool.isDisplayText));
        textColor = mTypedArray.getColor(R.styleable.RoundedProgressBar_textColor, mResources.getColor(R.color.textColor));
        textSize = mTypedArray.getDimension(R.styleable.RoundedProgressBar_textSize, mResources.getDimension(R.dimen.textSize));
        isStrokeStyle = mTypedArray.getBoolean(R.styleable.RoundedProgressBar_isStrokeStyle, mResources.getBoolean(R.bool.isStrokeStyle));

        mTypedArray.recycle();
    }

    /**
     * 获取内圆颜色
     * @return
     */
    public int getInnerCircleColor() {
        return innerCircleColor;
    }

    /**
     * 设置内圆颜色
     * @param innerCircleColor
     */
    public void setInnerCircleColor(int innerCircleColor) {
        this.innerCircleColor = innerCircleColor;
        invalidate();
    }

    /**
     * 获取进度条颜色
     * @return
     */
    public int getProgressBarColor() {
        return progressBarColor;
    }

    /**
     * 设置进度条颜色
     * @param progressBarColor
     */
    public void setProgressBarColor(int progressBarColor) {
        this.progressBarColor = progressBarColor;
        invalidate();
    }

    /**
     * 获取圆环颜色
     * @return
     */
    public int getRingColor() {
        return ringColor;
    }

    /**
     * 设置圆环颜色
     * @param ringColor
     */
    public void setRingColor(int ringColor) {
        this.ringColor = ringColor;
        invalidate();
    }

    /**
     * 获取内圆透明度
     * @return
     */
    public int getInnerCircleAlpha() {
        return innerCircleAlpha;
    }

    /**
     * 设置内圆透明度
     * @param innerCircleAlpha
     */
    public void setInnerCircleAlpha(int innerCircleAlpha) {
        if (innerCircleAlpha >= 0 && innerCircleAlpha <= 255) {
            this.innerCircleAlpha = innerCircleAlpha;
            invalidate();
        }
    }

    /**
     * 获取进度条透明度
     * @return
     */
    public int getProgressBarAlpha() {
        return progressBarAlpha;
    }

    /**
     * 设置进度条透明度
     * @param progressBarAlpha
     */
    public void setProgressBarAlpha(int progressBarAlpha) {
        if (progressBarAlpha >= 0 && progressBarAlpha <= 255) {
            this.progressBarAlpha = progressBarAlpha;
            invalidate();
        }
    }

    /**
     * 获取圆环透明度
     * @return
     */
    public int getRingAlpha() {
        return ringAlpha;
    }

    /**
     * 设置圆环透明度
     * @param ringAlpha
     */
    public void setRingAlpha(int ringAlpha) {
        if (ringAlpha >= 0 && ringAlpha <= 255) {
            this.ringAlpha = ringAlpha;
            invalidate();
        }
    }

    /**
     * 获取圆环宽度
     * @return
     */
    public float getRingWidth() {
        return ringWidth;
    }

    /**
     * 设置圆环宽度
     * @param ringWidth
     */
    public void setRingWidth(float ringWidth) {
        this.ringWidth = ringWidth;
        invalidate();
    }

    /**
     * 获取内圆半径
     * @return
     */
    public float getInnerCircleRadius() {
        return innerCircleRadius;
    }

    /**
     * 设置内圆半径
     * @param innerCircleRadius
     */
    public void setInnerCircleRadius(float innerCircleRadius) {
        this.innerCircleRadius = innerCircleRadius;
        invalidate();
    }

    /**
     * 获取最大进度
     * @return
     */
    public synchronized  int getMax() {
        return max;
    }

    /**
     * 设置最大进度
     * @param max
     */
    public synchronized void setMax(int max) {
        if (max > 0 ){
            this.max = max;
            invalidate();
        }
    }

    /**
     * 获取当前进度
     * @return
     */
    public synchronized int getCurrentProgress() {
        return currentProgress;
    }

    /**
     * 设置当前进度
     * @param currentProgress
     */
    public synchronized void setCurrentProgress(int currentProgress) {
        if (currentProgress > max){
            this.currentProgress = max;
        }else {
            this.currentProgress = currentProgress;
            postInvalidate();
        }
    }

    /**
     * 获取是否显示进度百分比文字
     * @return
     */
    public boolean isDisplayText() {
        return isDisplayText;
    }

    /**
     * 设置是否显示进度百分比文字
     * @param isDisplayText
     */
    public void setDisplayText(boolean isDisplayText) {
        this.isDisplayText = isDisplayText;
        invalidate();
    }

    /**
     * 获取进度百分比文字颜色
     * @return
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * 设置进度百分比文字颜色
     * @param textColor
     */
    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }

    /**
     * 获取进度百分比文字大小
     * @return
     */
    public float getTextSize() {
        return textSize;
    }

    /**
     * 设置进度百分比文字大小
     * @param textSize
     */
    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
    }

    /**
     * 获取进度条风格
     * @return
     */
    public boolean isStrokeStyle() {
        return isStrokeStyle;
    }

    /**
     * 设置进度条风格
     * @param isStrokeStyle
     */
    public void setStrokeStyle(boolean isStrokeStyle) {
        this.isStrokeStyle = isStrokeStyle;
        invalidate();
    }

    /**
     * 绘制RoundedProgressBar
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int centerX = getWidth() / 2; // 圆心的x坐标
        int centerY = getHeight() / 2; // 圆心的y坐标
        int radius = (int) (innerCircleRadius + ringWidth / 2);

        // 绘制外圆
        paint.setColor(ringColor);
        paint.setAlpha(ringAlpha);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ringWidth);
        paint.setAntiAlias(true); // 消除锯齿
        canvas.drawCircle(centerX, centerY, radius, paint);

        // 绘制内圆
        paint.setColor(innerCircleColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(innerCircleAlpha);
        paint.setAntiAlias(true);
        canvas.drawCircle(centerX, centerY, innerCircleRadius, paint);

        // 绘制进度
        paint.setColor(progressBarColor);
        paint.setAlpha(progressBarAlpha);
        paint.setAntiAlias(true);

        RectF oval = null;

        if(isStrokeStyle){
            paint.setStrokeWidth(ringWidth);
            paint.setStyle(Paint.Style.STROKE);

            oval = new RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        }else{
            paint.setStyle(Paint.Style.FILL);

            oval = new RectF(centerX - radius - ringWidth / 2, centerY - radius - ringWidth / 2, centerX + radius + ringWidth / 2, centerY + radius + ringWidth / 2);
        }

        if (currentProgress != 0) {
            canvas.drawArc(oval, 270, 360 * currentProgress / max, !isStrokeStyle, paint);
        }

        // 绘制进度百分比
        if (isDisplayText) {
            int percent = (int) (((float) currentProgress / (float) max) * 100);
            String text = percent + "%";

            paint.setColor(textColor);
            paint.setStrokeWidth(0);
            paint.setTextSize(textSize);
            paint.setTypeface(Typeface.DEFAULT_BOLD);

            // 获取进度百分比字符串的边界
            Rect bounds = new Rect();
            paint.getTextBounds(text, 0, text.length(), bounds);

            canvas.drawText(text, centerX - bounds.width() / 2, centerY + bounds.height() / 2, paint);
        }
    }
}
