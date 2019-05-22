package com.cyl.kaiyan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2019/5/14.
 */

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflate = LayoutInflater.from(this).inflate(createLayout(), null);
        setContentView(inflate);
        mUnbinder = ButterKnife.bind(this);
        initView(inflate);
        initData();
    }

    public void initData() {

    }

    public void initView(View inflate) {

    }

    protected abstract int createLayout();

    @Override
    protected void onDestroy() {
        if (mUnbinder  == null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }
}
