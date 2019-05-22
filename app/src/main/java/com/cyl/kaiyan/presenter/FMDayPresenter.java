package com.cyl.kaiyan.presenter;


import com.cyl.kaiyan.base.BasePresenter;
import com.cyl.kaiyan.bean.EveryDayBean;
import com.cyl.kaiyan.callback.BaseCallBack;
import com.cyl.kaiyan.model.FMDayModel;
import com.cyl.kaiyan.mview.FMDayView;

/**
 * Created by Administrator on 2019/5/14.
 */

public class FMDayPresenter<V extends FMDayView> extends BasePresenter<V> implements BaseCallBack<EveryDayBean> {
    private FMDayModel mFMDayModel = new FMDayModel();

    public void getData() {
        mFMDayModel.getData(this);
    }

    @Override
    public void onSuccess(EveryDayBean bean) {
        mMView.onSuccess(bean);
    }

    @Override
    public void onError(String str) {
        mMView.onError(str);
    }


}
