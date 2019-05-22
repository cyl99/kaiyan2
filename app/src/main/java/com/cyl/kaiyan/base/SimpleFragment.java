package com.cyl.kaiyan.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/5/14.
 */

public abstract class SimpleFragment extends Fragment {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(createLayout(), null);
        mUnbinder = ButterKnife.bind(this, inflate);
        initView(inflate);
        initData();
        return inflate;
    }

    public void initData() {

    }

    public  void initView(View inflate) {

    }

    protected abstract int createLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder == null) {
            mUnbinder.unbind();
        }

    }
}
