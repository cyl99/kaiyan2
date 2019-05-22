package com.cyl.kaiyan.presenter;


import com.cyl.kaiyan.base.BasePresenter;
import com.cyl.kaiyan.callback.BaseCallBack;
import com.cyl.kaiyan.model.FMHotModel;
import com.cyl.kaiyan.mview.FMHotView;

/**
 * Created by Administrator on 2019/5/14.
 */

public class FMHotPresenter<V extends FMHotView> extends BasePresenter<V> implements BaseCallBack<String> {
    private FMHotModel mFMHotModel = new FMHotModel();

    public void getData() {
        mFMHotModel.getData(this);
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
