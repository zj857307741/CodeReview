package com.adinnet.codeview.anim;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * @author zoujian.
 * @date 2018/9/19
 * 动画
 */

public class Animations {

    public  void alpha(View view){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f,1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        view.setAnimation(alphaAnimation);
    }

    public void scale(View view){
        /**
         * fromX 动画开始时X坐标的伸缩尺寸
         * toX 动画结束时X坐标的伸缩尺寸
         * fromY 动画开始时Y 坐标的伸缩尺寸
         * toY 动画结束时Y 坐标的伸缩尺寸
         * pivotX/pivotXValue 缩放动画的中心点X坐标
         * pivotY/pivotYValue 缩放动画的中心点Y坐标
         * pivotXType 动画在X轴的伸缩模式，
         * pivotYType 动画在Y轴的伸缩模式 Animation.RELATIVE_TO_SELF或者Animation.RELATIVE_TO_PARENT或者Animation.ABSOLUTE
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,4.0f,1.0f,4.0f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);
        view.setAnimation(scaleAnimation);
    }

    public void translate(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,2f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,2f);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        view.setAnimation(translateAnimation);
    }

    public void rotate(View view){
        RotateAnimation rotateAnimation = new RotateAnimation(0,-720,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(500);
        view.setAnimation(rotateAnimation);
    }

    public void valueAnimator(int... values){
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(values);
    }
}
