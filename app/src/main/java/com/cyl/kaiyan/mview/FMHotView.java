package com.cyl.kaiyan.mview;


import com.cyl.kaiyan.base.BaseView;

/**
 * Created by Administrator on 2019/5/14.
 */

public interface FMHotView extends BaseView {
    void onSuccess(String bean);

    void onError(String str);

}
