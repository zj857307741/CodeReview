package com.adinnet.codeview.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author zoujian.
 * @date 2018/9/19
 */

public class MyAnimation extends Animation {
    /**
     *
     * @param interpolatedTime 表示动画的时间进行比
     * @param t 表示补间动画在不同时刻对view的变形程度
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
    }
}
