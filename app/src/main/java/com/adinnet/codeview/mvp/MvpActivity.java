package com.adinnet.codeview.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.adinnet.codeview.R;
import com.adinnet.codeview.mvp.bean.Girls;
import com.adinnet.codeview.mvp.persenter.GirlPresenter;
import com.adinnet.codeview.mvp.view.IGirlView;

import java.util.List;

public class MvpActivity extends MvpBaseActivity<IGirlView,GirlPresenter<IGirlView>> implements IGirlView{


    @Override
    protected GirlPresenter<IGirlView> createPersenter() {
        return  new GirlPresenter<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        girlPresenter.fetch();
    }

    @Override
    public void showProgress() {

    }

    /**
     * 显示数据回调方法
     * @param girls
     */
    @Override
    public void showLists(List<Girls> girls) {

    }

}
