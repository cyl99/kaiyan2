package com.cyl.kaiyan.view.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cyl.kaiyan.R;
import com.cyl.kaiyan.adapter.VpFindAdapter;
import com.cyl.kaiyan.customview.CustomTextView;
import com.cyl.kaiyan.view.view.fragment.TimeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindShowActivity2 extends AppCompatActivity {

    @BindView(R.id.iv_return)
    ImageView mIvReturn;
    @BindView(R.id.item_text)
    CustomTextView mItemText;
    @BindView(R.id.iv_right)
    ImageView mIvRight;
    @BindView(R.id.rlv)
    RelativeLayout mRlv;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_show2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String extra = intent.getStringExtra("title");
        mItemText.setText(extra);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("按时间顺序");
        strings.add("分享排行");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new TimeFragment());
        fragments.add(new TimeFragment());
        VpFindAdapter vpFindAdapter = new VpFindAdapter(getSupportFragmentManager(), fragments, strings);
        mVp.setAdapter(vpFindAdapter);
        mTab.setupWithViewPager(mVp);
    }

    @OnClick(R.id.iv_return)
    public void onViewClicked() {
        finish();
    }
}
