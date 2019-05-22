package com.cyl.kaiyan.base;

/**
 * Created by Administrator on 2019/5/14.
 */

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends SimpleActivity {

    public P mPresenter;

    @Override
    public void initData() {
        super.initData();
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);

    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter == null) {
            mPresenter.destoryView();
            mPresenter = null;
        }
    }
}
