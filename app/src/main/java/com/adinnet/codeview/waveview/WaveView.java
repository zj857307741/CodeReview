package com.adinnet.codeview.waveview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.adinnet.codeview.R;

/**
 * @author zoujian.
 * @date 2018/9/29
 */


public class WaveView extends View{
    private int waveView_boatBitmap;
    private boolean waveView_rise;
    private int duration,waveHeight,waveLenght,originY;
    private Bitmap mBitmap;
    private Paint paint;
    private Path path;
    private int width ,height;
    private ValueAnimator animator;
    private int dx,dy;


    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public void init(Context context,AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.WaveView);
        waveView_boatBitmap = array.getResourceId(R.styleable.WaveView_boatBitmap,0);
        waveView_rise = array.getBoolean(R.styleable.WaveView_rise,false);
        duration = (int) array.getDimension(R.styleable.WaveView_duration,1000);
        originY = (int) array.getDimension(R.styleable.WaveView_originY,200);
        waveHeight = (int) array.getDimension(R.styleable.WaveView_waveHeight,200);
        waveLenght = (int) array.getDimension(R.styleable.WaveView_waveLenght,400);
        array.recycle();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize =1;
        if(waveView_boatBitmap>0){
            mBitmap = BitmapFactory.decodeResource(getResources(),waveView_boatBitmap,options);
            mBitmap = getCircleBitmap(mBitmap);
        }else {
            mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher,options);
        }

        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL_AND_STROKE); // 填充
        path = new Path();
    }

    /**
     *  圆形图片
     * @param bitmap
     * @return
     */
    private Bitmap getCircleBitmap(Bitmap bitmap) {
        if(bitmap == null){
            return null;
        }
        try {
            Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(circleBitmap);
            final Paint paint = new Paint();
            final Rect rect = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
            final RectF rectF = new RectF(new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()));
            float roundPx = 0.0f;
            if(bitmap.getWidth()>bitmap.getHeight()){
                roundPx = bitmap.getHeight()/2.0f;
            }else {
                roundPx = bitmap.getWidth()/2.0f;
            }

            paint.setAntiAlias(true);
            canvas.drawARGB(0,0,0,0);
            paint.setColor(Color.WHITE);
            canvas.drawRoundRect(rectF,roundPx,roundPx,paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            final Rect src = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
            canvas.drawBitmap(bitmap,src,rect,paint);
            return circleBitmap;
        }catch (Exception e){
            return bitmap;
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width= MeasureSpec.getSize(widthMeasureSpec);
        height= MeasureSpec.getSize(heightMeasureSpec);
        if(originY<0){
            originY = height;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 定义曲线
        setPathData();

        canvas.drawPath(path,paint);
    }

    private void setPathData() {
        path.reset();
        int halfWaveLenght = waveLenght/2;
        path.moveTo(-waveLenght+dx,originY);
        for (int i = -waveLenght;i<width;i+=waveLenght){
            path.rQuadTo(halfWaveLenght/2,-waveHeight,halfWaveLenght,0);//相对坐标
            path.rQuadTo(halfWaveLenght/2,waveHeight,halfWaveLenght,0);//相对坐标
        }
        path.lineTo(width,height);
        path.lineTo(0,height);
        path.close();
    }

    public void startAnimator(){
        animator = ValueAnimator.ofFloat(0,1);
        animator.setDuration(duration);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (float) animation.getAnimatedValue();
                dx = (int) (waveLenght* fraction);
                postInvalidate();
            }
        });
        animator.start();
    }
}
