package com.cyl.kaiyan;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cyl.kaiyan.adapter.VpHomeAdapter;
import com.cyl.kaiyan.base.BaseActivity;
import com.cyl.kaiyan.customview.CustomTextView;
import com.cyl.kaiyan.customview.CustomViewPager;
import com.cyl.kaiyan.mview.MainView;
import com.cyl.kaiyan.presenter.MainPresenter;
import com.cyl.kaiyan.view.view.activity.HuancunActivity;
import com.cyl.kaiyan.view.view.activity.JiluActivity;
import com.cyl.kaiyan.view.view.fragment.EveryDayFragment;
import com.cyl.kaiyan.view.view.fragment.FindmoreFragment;
import com.cyl.kaiyan.view.view.fragment.HotFragment;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainView, MainPresenter<MainView>> implements MainView {

    @BindView(R.id.main_toolbar_tv_time)
    CustomTextView mMainToolbarTvTime;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    CustomViewPager mVp;
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.login)
    TextView mLogin;
    @BindView(R.id.tv_huancun)
    TextView mTvHuancun;
    @BindView(R.id.tv_jilu)
    TextView mTvJilu;
    @BindView(R.id.tv_dianying)
    TextView mTvDianying;
    @BindView(R.id.tv_fenxiang)
    TextView mTvFenxiang;
    @BindView(R.id.tv_gengduo)
    TextView mTvGengduo;
    @BindView(R.id.weather_iv)
    ImageView mWeatherIv;
    @BindView(R.id.qiwen)
    TextView mQiwen;
    @BindView(R.id.shiqu)
    TextView mShiqu;
    @BindView(R.id.weather_rl)
    RelativeLayout mWeatherRl;
    @BindView(R.id.lv_top)
    LinearLayout mLvTop;
    @BindView(R.id.about)
    TextView mAbout;
    @BindView(R.id.them)
    TextView mThem;
    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @Override
    public void onSuccess(String bean) {

    }

    @Override
    public void onError(String str) {

    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.getData();

    }

    @Override
    public void initView(View inflate) {
        super.initView(inflate);
        Fresco.initialize(this);
        initFragment();
    }

    private void initFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<Integer> strings = new ArrayList<>();
        fragments.add(new EveryDayFragment());
        fragments.add(new FindmoreFragment());
        fragments.add(new HotFragment());
        strings.add(R.string.everydays);
        strings.add(R.string.findmore);
        strings.add(R.string.hot);
        VpHomeAdapter vpHomeAdapter = new VpHomeAdapter(getSupportFragmentManager(), fragments, strings, this);
        mVp.setAdapter(vpHomeAdapter);
        mTab.setupWithViewPager(mVp);
    }

    @Override
    protected MainPresenter<MainView> createPresenter() {
        return new MainPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_huancun, R.id.tv_jilu, R.id.tv_dianying, R.id.tv_fenxiang, R.id.tv_gengduo, R.id.about, R.id.them, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_huancun:
                startActivity(new Intent(MainActivity.this, HuancunActivity.class));
                break;
            case R.id.tv_jilu:
                startActivity(new Intent(MainActivity.this, JiluActivity.class));
                break;
            case R.id.tv_dianying:
                break;
            case R.id.tv_fenxiang:
                break;
            case R.id.tv_gengduo:
                break;
            case R.id.about:
                break;
            case R.id.them:
                break;
            case R.id.iv_right:
                break;
        }
    }
}
