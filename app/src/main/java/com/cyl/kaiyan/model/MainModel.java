package com.cyl.kaiyan.model;


import com.cyl.kaiyan.callback.BaseCallBack;

/**
 * Created by Administrator on 2019/5/14.
 */

public class MainModel {
    public void getData(BaseCallBack baseCallBack) {
        baseCallBack.onSuccess("你好,世界");
        
    }
}
