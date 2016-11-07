package com.example.administrator.choshibaike.scandal.view.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.administrator.choshibaike.R;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class MyImagView extends ImageView {
    private int shape;
    public static final int AIRCLE = 0;
    public static final int RECTANGLE = 1;
    public static final int ZHENGFANGXING = 2;
    public static final int LIUBIANXING = 3;
    private Paint paint;
    public MyImagView(Context context) {
        this(context,null);
    }

    public MyImagView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyImagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyImagView);
        shape = ta.getInt(R.styleable.MyImagView_shape, AIRCLE);
        ta.recycle();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            paint.reset();
            Bitmap ibitmap = ((BitmapDrawable) drawable).getBitmap();
            int width = ibitmap.getWidth();
            int height = ibitmap.getHeight();
            float max = Math.max(getWidth() * 1f / width, getHeight() * 1f / height);
            Matrix matrix = new Matrix();
            matrix.postScale(max, max);

            Bitmap bitmap = Bitmap.createBitmap(ibitmap, 0, 0, width, height, matrix, true);
            Bitmap blinkBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas mCanvas = new Canvas(blinkBitmap);
            switch (shape) {
                case AIRCLE:
                    mCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2, paint);
                    break;
                case RECTANGLE:
                    mCanvas.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()), 10, 10, paint);
                    break;
                case ZHENGFANGXING: {
                    Path path = new Path();
                    path.moveTo(getMeasuredWidth() / 2, 0);
                    path.lineTo(getMeasuredWidth(), getMeasuredWidth() / 2);
                    path.lineTo(getMeasuredWidth() / 2, getMeasuredWidth());
                    path.lineTo(0, getMeasuredWidth() / 2);
                    path.close();
                    mCanvas.drawPath(path, paint);
                }
                break;
                case LIUBIANXING: {
                    Path path = new Path();
                    path.moveTo(getWidth() / 2, 0);
                    path.lineTo(getWidth(), getWidth() / 4);
                    path.lineTo(getWidth(), getWidth() * 3 / 4);
                    path.lineTo(getWidth() / 2, getWidth());
                    path.lineTo(0, getWidth() * 3 / 4);
                    path.lineTo(0, getWidth() / 4);
                    path.close();
                    mCanvas.drawPath(path, paint);
                }
                break;
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            mCanvas.drawBitmap(bitmap, 0, 0, paint);
            canvas.drawBitmap(blinkBitmap, 0, 0, null);
//            if (bitmap != null && !bitmap.isRecycled()) {
//                bitmap.recycle();
//            }
        }
    }
}
