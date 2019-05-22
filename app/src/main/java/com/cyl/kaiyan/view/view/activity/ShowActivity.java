package com.cyl.kaiyan.view.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cyl.kaiyan.R;
import com.cyl.kaiyan.customview.CustomTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowActivity extends AppCompatActivity {
    @BindView(R.id.tv1)
    TextView mTv1;
    @BindView(R.id.tv2)
    TextView mTv2;
    @BindView(R.id.tv3)
    TextView mTv3;
    @BindView(R.id.item_text)
    CustomTextView mItemText;
    @BindView(R.id.rlv)
    RelativeLayout mRlv;

    @BindView(R.id.iv_img)
    ImageView mIvImg;
    @BindView(R.id.iv_mohu)
    ImageView mIvMohu;
    @BindView(R.id.tv_love)
    TextView mTvLove;
    @BindView(R.id.tv_fenxiang)
    TextView mTvFenxiang;
    @BindView(R.id.tv_pinglun)
    TextView mTvPinglun;
    @BindView(R.id.tv_huancun)
    TextView mTvHuancun;
    @BindView(R.id.iv_return)
    ImageView mIvReturn;
    @BindView(R.id.iv_bofang)
    ImageView mIvBofang;
    private String mUrl;
    private String mText1;
    private String mExtra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        //   EventBus.getDefault().register(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        mExtra = intent.getStringExtra("img");
        mText1 = intent.getStringExtra("text1");
        String text2 = intent.getStringExtra("text2");
        String text3 = intent.getStringExtra("text3");
        String imgmohu = intent.getStringExtra("imgmohu");
        mUrl = intent.getStringExtra("url");

        Glide.with(this).load(mExtra).into(mIvImg);
        Glide.with(this).load(imgmohu).into(mIvMohu);
        mTv1.setText(mText1);
        mTv2.setText(text2);
        mTv3.setText(text3);
    }

    @OnClick({R.id.iv_return, R.id.iv_bofang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_return:
                finish();
                break;
            case R.id.iv_bofang:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("url", mUrl);
                intent.putExtra("text", mText1);
                intent.putExtra("img", mExtra);
                startActivity(intent);
                break;
        }
    }

}
