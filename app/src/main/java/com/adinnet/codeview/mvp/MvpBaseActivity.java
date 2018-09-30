package com.adinnet.codeview.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adinnet.codeview.mvp.persenter.BasePresenter;

/**
 * @author zoujian.
 * @date 2018/9/30
 */

public abstract class MvpBaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    public T girlPresenter;

    protected abstract T createPersenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        girlPresenter = createPersenter();
        girlPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        girlPresenter.detachView();
    }
}
