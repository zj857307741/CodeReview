package com.adinnet.codeview.mvp.model;

import com.adinnet.codeview.mvp.bean.Girls;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoujian.
 * @date 2018/9/30
 */

public class GirlModelImpl implements IGirlModel {

    @Override
    public void loadGirl(GirlOnLoadListener girlOnLoadListener) {
        List<Girls> data = new ArrayList<>();
        data.add(new Girls());
        data.add(new Girls());
        data.add(new Girls());
        data.add(new Girls());
        data.add(new Girls());
        data.add(new Girls());
        girlOnLoadListener.onComplete(data);
    }
}
