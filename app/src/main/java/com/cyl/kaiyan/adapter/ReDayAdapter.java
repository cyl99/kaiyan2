package com.cyl.kaiyan.adapter;

import android.content.Context;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cyl.kaiyan.R;
import com.cyl.kaiyan.bean.EveryDayBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import retrofit2.http.Url;

/**
 * Created by Administrator on 2019/5/16.
 */

public class ReDayAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private ArrayList<EveryDayBean.IssueListBean.ItemListBean> mList;
    private ArrayList<String> mStrings;
    public ReDayAdapter(Context context, ArrayList<EveryDayBean.IssueListBean.ItemListBean> list, ArrayList<String> strings) {
        mContext = context;
        mList = list;
        mStrings = strings;
    }
    public void setList(ArrayList<EveryDayBean.IssueListBean.ItemListBean> list) {
        mList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item_text, parent, false);
            viewHolder = new MyViewHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item_day, parent, false);
            viewHolder = new MyViewHoler2(inflate);
        }
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder holder1 = (MyViewHolder) holder;
          //  holder1.mItem_text.setText(mStrings.get(position));
        } else if (holder instanceof MyViewHoler2) {
            final EveryDayBean.IssueListBean.ItemListBean.DataBean data = mList.get(position - 1).getData();
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
            MyViewHoler2 holer2 = (MyViewHoler2) holder;
            holer2.mTv1.setText(data.getTitle());
            holer2.mTv2.setText("#" + data.getCategory() + "/" + stringTime);
            String feed = data.getCover().getFeed();
          Glide.with(mContext).load(feed).into(holer2.mIv_bg);
          //  holer2.mIv_bg.setImageURI(Uri.parse(feed));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.OnClick(position-1,data,"#" + data.getCategory() + "/" + stringTime);
                }
            });
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position % 7 == 0 || position % 7 == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }
    class MyViewHolder extends ViewHolder {
        //private final TextView mItem_text;
        public MyViewHolder(View itemView) {
            super(itemView);
         //   mItem_text = itemView.findViewById(R.id.item_text);
        }
    }

    class MyViewHoler2 extends RecyclerView.ViewHolder {
        private final TextView mTv1;
        private final ImageView mIv_bg;
        private final TextView mTv2;
        public MyViewHoler2(View itemView) {
            super(itemView);
            mIv_bg = itemView.findViewById(R.id.iv_bg);
            mTv1 = itemView.findViewById(R.id.tv1);
            mTv2 = itemView.findViewById(R.id.tv2);
        }
    }
    OnClickListener mOnClickListener;
    public interface OnClickListener {
        void OnClick(int position, EveryDayBean.IssueListBean.ItemListBean.DataBean beans,String str);
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
