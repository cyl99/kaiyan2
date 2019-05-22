package com.cyl.kaiyan.mview;


import com.cyl.kaiyan.base.BaseView;
import com.cyl.kaiyan.bean.EveryDayBean;

/**
 * Created by Administrator on 2019/5/14.
 */

public interface FMDayView extends BaseView {
    void onSuccess(EveryDayBean bean);

    void onError(String str);

}
