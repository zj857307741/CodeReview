package com.adinnet.codeview.mvp.view;

import com.adinnet.codeview.mvp.bean.Girls;

import java.util.List;

/**
 * @author zoujian.
 * @date 2018/9/30
 */

public interface IGirlView {
    // 显示进度条
    public void showProgress();
    // 显示listView中的数据，使用回调方式返回数据
    public void showLists(List<Girls> girls);
}
