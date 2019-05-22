package com.cyl.kaiyan.view.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cyl.kaiyan.R;
import com.cyl.kaiyan.adapter.ReDayAdapter;
import com.cyl.kaiyan.base.BaseFragment;
import com.cyl.kaiyan.bean.EveryDayBean;
import com.cyl.kaiyan.mview.FMDayView;
import com.cyl.kaiyan.presenter.FMDayPresenter;
import com.cyl.kaiyan.view.view.activity.ShowActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EveryDayFragment extends BaseFragment<FMDayView, FMDayPresenter<FMDayView>> implements FMDayView {
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder1;
    private ArrayList<EveryDayBean.IssueListBean.ItemListBean> mList;
    private ReDayAdapter mReDayAdapter;

    @Override
    public void onSuccess(EveryDayBean bean) {
        List<EveryDayBean.IssueListBean.ItemListBean> itemList = bean.getIssueList().get(0).getItemList();
        mList.addAll(itemList);
        mReDayAdapter.setList(mList);
        mReDayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String str) {
    }

    @Override
    public void initView(View inflate) {
        super.initView(inflate);
        Fresco.initialize(getContext());
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.getData();
        mList = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("weekend special");
        strings.add("weekend special");
        mReDayAdapter = new ReDayAdapter(getContext(), mList, strings);
        mRlv.setAdapter(mReDayAdapter);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mReDayAdapter.setOnClickListener(new ReDayAdapter.OnClickListener() {
            @Override
            public void OnClick(int position, EveryDayBean.IssueListBean.ItemListBean.DataBean beans, String str) {
                Intent intent = new Intent(getContext(), ShowActivity.class);
                /*EventBus.getDefault().postSticky(beans.getCover().getFeed());
                EventBus.getDefault().postSticky(beans.getTitle());
                EventBus.getDefault().postSticky(str);
                EventBus.getDefault().postSticky(beans.getDescription());*/
                intent.putExtra("img", beans.getCover().getFeed());
                intent.putExtra("text1", beans.getTitle());
                intent.putExtra("text2", str);
                intent.putExtra("text3", beans.getDescription());
                intent.putExtra("imgmohu", beans.getCover().getBlurred());
                intent.putExtra("url", beans.getPlayUrl());

                startActivity(intent);

            }
        });
    }

    @Override
    protected FMDayPresenter<FMDayView> createPresenter() {
        return new FMDayPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_every_day;
    }


}
