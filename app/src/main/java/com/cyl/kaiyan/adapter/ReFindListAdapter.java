package com.cyl.kaiyan.adapter;

import android.content.Context;
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
import com.cyl.kaiyan.bean.FindTwoBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/16.
 */

public class ReFindListAdapter extends RecyclerView.Adapter<ReFindListAdapter.MyViewHoler2> {
    private Context mContext;
    private ArrayList<FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean> mList;


    public ReFindListAdapter(Context context, ArrayList<FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean> list) {


        mContext = context;
        mList = list;
    }

    public void setList(ArrayList<FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean> list) {
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHoler2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item_day, parent, false);
        MyViewHoler2 myViewHoler2 = new MyViewHoler2(inflate);

        return myViewHoler2;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHoler2 holder, final int position) {
   if (holder instanceof MyViewHoler2) {
       final FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = mList.get(position).getData();
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
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.OnClick(position,data,"#" + data.getCategory() + "/" + stringTime);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyViewHoler2 extends ViewHolder {
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
        void OnClick(int position, FindTwoBean.ItemListBeanX.DataBeanX.ItemListBean.DataBean beans, String str);
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

}
