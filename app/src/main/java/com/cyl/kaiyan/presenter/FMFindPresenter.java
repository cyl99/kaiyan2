package com.cyl.kaiyan.presenter;


import com.cyl.kaiyan.base.BasePresenter;
import com.cyl.kaiyan.bean.FindMoreBean;
import com.cyl.kaiyan.callback.BaseCallBack;
import com.cyl.kaiyan.model.FMFindModel;
import com.cyl.kaiyan.mview.FMFindView;

import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */

public class FMFindPresenter<V extends FMFindView> extends BasePresenter<V> implements BaseCallBack<List<FindMoreBean>> {
    private FMFindModel mFMFindModel = new FMFindModel();

    public void getData() {
        mFMFindModel.getData(this);
    }

    @Override
    public void onSuccess(List<FindMoreBean> bean) {
        mMView.onSuccess(bean);
    }

    @Override
    public void onError(String str) {
        mMView.onError(str);
    }


}
