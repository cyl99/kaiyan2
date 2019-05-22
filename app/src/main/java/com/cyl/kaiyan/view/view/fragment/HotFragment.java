package com.cyl.kaiyan.view.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cyl.kaiyan.R;
import com.cyl.kaiyan.adapter.VpHotAdapter;
import com.cyl.kaiyan.base.BaseFragment;
import com.cyl.kaiyan.customview.CustomViewPager;
import com.cyl.kaiyan.mview.FMHotView;
import com.cyl.kaiyan.presenter.FMHotPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<FMHotView, FMHotPresenter<FMHotView>> implements FMHotView {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    CustomViewPager mVp;
    Unbinder unbinder1;

    @Override
    public void onSuccess(String bean) {

    }

    @Override
    public void onError(String str) {

    }

    @Override
    public void initView(View inflate) {
        super.initView(inflate);
        mPresenter.getData();
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("周排行");
        strings.add("月排行");
        strings.add("总排行");
        fragments.add(new ShareFragment());
        fragments.add(new ShareFragment());
        fragments.add(new ShareFragment());
        VpHotAdapter vpHotAdapter = new VpHotAdapter(getChildFragmentManager(), fragments, strings);
        mVp.setAdapter(vpHotAdapter);
        mTab.setupWithViewPager(mVp);


    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    protected FMHotPresenter<FMHotView> createPresenter() {
        return new FMHotPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_hot;
    }


}
