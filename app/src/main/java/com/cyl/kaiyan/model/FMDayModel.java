package com.cyl.kaiyan.model;


import com.cyl.kaiyan.api.MyApi;
import com.cyl.kaiyan.bean.EveryDayBean;
import com.cyl.kaiyan.callback.BaseCallBack;
import com.cyl.kaiyan.httputils.BaseObserver;
import com.cyl.kaiyan.httputils.HttpUtils;
import com.cyl.kaiyan.httputils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2019/5/14.
 */

public class FMDayModel {
    public void getData(final BaseCallBack baseCallBack) {
        MyApi apiserver = HttpUtils.getInstance().getApiserver(MyApi.url, MyApi.class);
        Observable<EveryDayBean> bannerBeanObservable = apiserver.initData();
        bannerBeanObservable.compose(RxUtils.<EveryDayBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<EveryDayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EveryDayBean dailyNewsBean) {
                        baseCallBack.onSuccess(dailyNewsBean);
                    }
                });

    }

}
