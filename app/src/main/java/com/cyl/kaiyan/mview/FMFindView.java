package com.cyl.kaiyan.mview;


import com.cyl.kaiyan.base.BaseView;
import com.cyl.kaiyan.bean.FindMoreBean;

import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */

public interface FMFindView extends BaseView {
    void onSuccess(List<FindMoreBean> bean);

    void onError(String str);

}
