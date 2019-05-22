package com.cyl.kaiyan.callback;

/**
 * Created by Administrator on 2019/5/14.
 */

public interface BaseCallBack<T> {
    void onSuccess(T bean);
    void onError(String str);

}
