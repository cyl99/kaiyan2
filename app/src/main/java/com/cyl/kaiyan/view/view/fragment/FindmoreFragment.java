package com.cyl.kaiyan.view.view.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cyl.kaiyan.R;
import com.cyl.kaiyan.adapter.ReFindAdapter;
import com.cyl.kaiyan.base.BaseFragment;
import com.cyl.kaiyan.bean.FindMoreBean;
import com.cyl.kaiyan.mview.FMFindView;
import com.cyl.kaiyan.presenter.FMFindPresenter;
import com.cyl.kaiyan.view.view.activity.FindShowActivity2;
import com.cyl.kaiyan.widget.ColorDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindmoreFragment extends BaseFragment<FMFindView, FMFindPresenter<FMFindView>> implements FMFindView {
    private static final String TAG = "FindmoreFragment";
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ReFindAdapter mReFindAdapter;
    private ArrayList<FindMoreBean> mList;

    @Override
    public void initView(View inflate) {
        super.initView(inflate);
        mPresenter.getData();
    }

    @Override
    public void initData() {
        super.initData();
        mList = new ArrayList<>();
        mRlv.setLayoutManager(new GridLayoutManager(getContext(),2));
        mReFindAdapter = new ReFindAdapter(getContext(), mList);
        mRlv.setAdapter(mReFindAdapter);
      //  mRlv.addItemDecoration();
        /* mRlv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mRlv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));*/
      /*  mRlv.addItemDecoration(new ColorDividerItemDecoration(
                Color.parseColor("#00ffffff"),20));*/
        mReFindAdapter.setOnClickListener(new ReFindAdapter.OnClickListener() {
            @Override
            public void OnClick(int position, FindMoreBean beans) {
                Intent intent = new Intent(getContext(), FindShowActivity2.class);
                intent.putExtra("title",beans.getName());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onSuccess(List<FindMoreBean> bean) {
        mList.addAll(bean);
        mReFindAdapter.setList(mList);
        mReFindAdapter.notifyDataSetChanged();
    }
    @Override
    public void onError(String str) {
    }
    @Override
    protected FMFindPresenter<FMFindView> createPresenter() {
        return new FMFindPresenter<>();
    }

    @Override
    protected int createLayout() {
        return R.layout.fragment_findmore;
    }

}
