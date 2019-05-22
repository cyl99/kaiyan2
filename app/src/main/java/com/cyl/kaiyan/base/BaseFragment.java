package com.cyl.kaiyan.base;

import android.view.View;

/**
 * Created by Administrator on 2019/5/15.
 */

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends SimpleFragment implements BaseView {

    public P mPresenter;

    @Override
    public void initView(View inflate) {
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        super.initView(inflate);
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
