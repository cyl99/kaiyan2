package com.cyl.kaiyan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cyl.kaiyan.R;
import com.cyl.kaiyan.bean.HotBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/21.
 */

public class ReHotAdapter extends RecyclerView.Adapter<ReHotAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<HotBean.ItemListBean> mList;

    public ReHotAdapter(Context context, ArrayList<HotBean.ItemListBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item_day, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HotBean.ItemListBean.DataBean data = mList.get(position).getData();
        int duration = data.getDuration();
        int last = duration % 60;
        String stringLast;
        if (last <= 9) {
            stringLast = "0" + last;
        } else {
            stringLast = last + "";
        }
        //获取视频时间
        String durationString;
        int minit = duration / 60;
        if (minit < 10) {
            durationString = "0" + minit;
        } else {
            durationString = "" + minit;
        }
        final String stringTime = durationString + "' " + stringLast + '"';
        holder.mTv1.setText(data.getTitle());
        holder.mTv2.setText("#" + data.getCategory() + "/" + stringTime);
        String feed = data.getCover().getFeed();
        Glide.with(mContext).load(feed).into(holder.mIv_bg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv_bg;
        private final TextView mTv1;
        private final TextView mTv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv_bg = itemView.findViewById(R.id.iv_bg);
            mTv1 = itemView.findViewById(R.id.tv1);
            mTv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
