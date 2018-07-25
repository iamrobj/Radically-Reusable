package com.robj.radicallyreusable.base.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;

public class AvatarDrawable extends ColorDrawable {

    private final Paint paint = new Paint();
    private final Rect bounds  = new Rect();
    private final String text;
    private final float measuredTextWidth;
    private final int measuredTextHeight;
    private float xOffset, yOffset;

    public AvatarDrawable (Context context, int color, String text, float fontSizeInSp) {
        super(color);
        this.text = text;
        float fontSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, fontSizeInSp, context.getResources().getDisplayMetrics());
        paint.setAntiAlias(true);
        paint.setTextSize(fontSize);
        measuredTextWidth = paint.measureText(text);
        paint.getTextBounds(text, 0, text.length(), bounds);
        measuredTextHeight = bounds.height();
        paint.setColor(0xffffffff);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if(xOffset == 0 || yOffset == 0) {
            xOffset = ((canvas.getWidth() - measuredTextWidth) / 2);
            yOffset = (int) (measuredTextHeight + (canvas.getHeight() - measuredTextHeight) / 2);
        }

        canvas.drawText(text, xOffset, yOffset, paint);
    }
}
