package com.cyl.kaiyan.presenter;


import com.cyl.kaiyan.base.BasePresenter;
import com.cyl.kaiyan.callback.BaseCallBack;
import com.cyl.kaiyan.model.MainModel;
import com.cyl.kaiyan.mview.MainView;

/**
 * Created by Administrator on 2019/5/14.
 */

public class MainPresenter<V extends MainView> extends BasePresenter<V> implements BaseCallBack<String> {
    private MainModel mMainModel = new MainModel();

    public void getData() {
        mMainModel.getData(this);
    }

    @Override
    public void onSuccess(String bean) {
        mMView.onSuccess(bean);
    }

    @Override
    public void onError(String str) {
        mMView.onError(str);
    }


}
