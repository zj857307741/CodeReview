package com.adinnet.codeview.mvp.persenter;

import java.lang.ref.WeakReference;

/**
 * @author zoujian.
 * @date 2018/9/30
 */

public class BasePresenter<T> {

    protected WeakReference<T> girlView;
    // 进行绑定
    public void attachView(T view){
        girlView = new WeakReference<T>(view);
    }
    // 进行解绑
    public void detachView(){
        if(girlView!=null){
            girlView.clear();
        }
    }
}
