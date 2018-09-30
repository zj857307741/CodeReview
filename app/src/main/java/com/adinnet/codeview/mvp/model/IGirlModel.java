package com.adinnet.codeview.mvp.model;

import com.adinnet.codeview.mvp.bean.Girls;

import java.util.List;

/**
 * @author zoujian.
 * @date 2018/9/30
 */

public interface IGirlModel {
    void loadGirl(GirlOnLoadListener girlOnLoadListener);
    // 设计内部回调接口
    interface GirlOnLoadListener{
        void onComplete(List<Girls> grilses);
    }
}
