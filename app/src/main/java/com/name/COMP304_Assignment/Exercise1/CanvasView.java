package com.name.COMP304_Assignment.Exercise1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    private Paint mPaint;
    private float mX1, mY1, mX2, mY2;
    private static final float TOLERANCE = 5;

    public CanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
    }

    public void drawLineCanvas(Paint paint, float x1, float y1, float x2, float y2) {
        mPaint = paint;
        mX1 = x1;
        mX2 = x2;
        mY1 = y1;
        mY2 = y2;
    }

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw the mPath with the mPaint on the canvas when onDraw
        canvas.drawLine(mX1, mY1, mX2, mY2, mPaint);
    }

    public void clearCanvas() {
        mPaint.reset();
        invalidate();
    }

}