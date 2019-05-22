package com.cyl.kaiyan.view.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cyl.kaiyan.R;
import com.cyl.kaiyan.adapter.ReFindListAdapter;
import com.cyl.kaiyan.api.MyApi;
import com.cyl.kaiyan.bean.FindTwoBean;
import com.cyl.kaiyan.view.view.activity.ShowActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder;

    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_time, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initData();
        return inflate;

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MyApi.findUrl).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        final MyApi myApi = retrofit.create(MyApi.class);
        Observable<FindTwoBean> data = myApi.initDatafind_two();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindTwoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindTwoBean value) {
                        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
                        ArrayList<FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean> list = new ArrayList<>();
                        list.addAll(value.getItemList().get(0).getData().getItemList());

                        ReFindListAdapter adapter = new ReFindListAdapter(getContext(), list);
                        mRlv.setAdapter(adapter);
                        adapter.setOnClickListener(new ReFindListAdapter.OnClickListener() {
                            @Override
                            public void OnClick(int position, FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean.DataBean beans, String str) {
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
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(), "no" + e.getMessage(), Toast.LENGTH_SHORT).show();
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
