package com.cyl.kaiyan.view.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cyl.kaiyan.R;
import com.cyl.kaiyan.adapter.ReHotAdapter;
import com.cyl.kaiyan.api.MyApi;
import com.cyl.kaiyan.bean.HotBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder;

    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_share, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initData();

        return inflate;

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MyApi.url).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        MyApi myApi = retrofit.create(MyApi.class);
        final Observable<HotBean> data = myApi.initDataHot();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean value) {

                        Toast.makeText(getContext(), "q", Toast.LENGTH_SHORT).show();
                        // Toast.makeText(getContext(), "q"+value.getItemList().get(2).getData().getTitle(), Toast.LENGTH_SHORT).show();


                       /* List<HotBean.ItemListBean> itemList = value.getItemList();
                        ArrayList<HotBean.ItemListBean> list = new ArrayList<>();
                        list.addAll(itemList);
                        ReHotAdapter reHotAdapter = new ReHotAdapter(getContext(), list);

                        mRlv.setAdapter(reHotAdapter);*/

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
