package com.cyl.kaiyan.model;


import com.cyl.kaiyan.api.MyApi;
import com.cyl.kaiyan.bean.FindMoreBean;
import com.cyl.kaiyan.callback.BaseCallBack;
import com.cyl.kaiyan.httputils.BaseObserver;
import com.cyl.kaiyan.httputils.HttpUtils;
import com.cyl.kaiyan.httputils.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2019/5/14.
 */

public class FMFindModel {
    public void getData(final BaseCallBack baseCallBack) {
        MyApi apiserver = HttpUtils.getInstance().getApiserver(MyApi.kaiurl, MyApi.class);
        Observable<List<FindMoreBean>> findMoreBeanObservable = apiserver.initDatafind();
        findMoreBeanObservable.compose(RxUtils.<List<FindMoreBean>>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<List<FindMoreBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<FindMoreBean> dailyNewsBean) {
                        baseCallBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
