package com.adinnet.codeview.mvp.persenter;

import com.adinnet.codeview.mvp.bean.Girls;
import com.adinnet.codeview.mvp.model.GirlModelImpl;
import com.adinnet.codeview.mvp.model.IGirlModel;
import com.adinnet.codeview.mvp.view.IGirlView;

import java.lang.ref.WeakReference;
import java.util.List;


/**
 * @author zoujian.
 * @date 2018/9/30
 */

public class GirlPresenter<T extends IGirlView> extends BasePresenter<T> {

    // mode 层的引用
    IGirlModel girlModel = new GirlModelImpl();
    // 构造方法
    public GirlPresenter(){
    }

    // 执行操作UI逻辑
    public void fetch(){
        if(girlView.get()!=null){
            if(girlView.get() instanceof IGirlView){
            }
            (girlView.get()).showProgress();

            if(girlModel!=null){
                girlModel.loadGirl(new IGirlModel.GirlOnLoadListener() {
                    @Override
                    public void onComplete(List<Girls> grilses) {
                        if(girlView!=null){
                            girlView.get().showLists(grilses);
                        }
                    }
                });
            }
        }


    }

}
