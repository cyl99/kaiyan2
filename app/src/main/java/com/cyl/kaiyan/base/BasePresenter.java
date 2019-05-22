package com.cyl.kaiyan.base;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2019/5/14.
 */

public class BasePresenter<V> {

    private WeakReference<V> mVWeakReference;
    public V mMView;

    public void attachView(V v) {
        mVWeakReference = new WeakReference<V>(v);
        mMView = mVWeakReference.get();
    }
    public void destoryView(){
        if (mVWeakReference !=null) {
            mVWeakReference.clear();
        }
    }


}
