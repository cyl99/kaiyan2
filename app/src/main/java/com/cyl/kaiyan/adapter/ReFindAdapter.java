package com.cyl.kaiyan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cyl.kaiyan.R;
import com.cyl.kaiyan.bean.FindMoreBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/17.
 */

public class ReFindAdapter extends RecyclerView.Adapter<ReFindAdapter.MyViewHolder>{
    private Context mContext;
    private ArrayList<FindMoreBean> mList;

    public ReFindAdapter(Context context, ArrayList<FindMoreBean> list) {

        mContext = context;
        mList = list;
    }

    public void setList(ArrayList<FindMoreBean> list) {
        mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_find, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final FindMoreBean findMoreBean = mList.get(position);
        if (position%2 == 0) {
          holder.mfl.setPadding(0,0,8,8);
        } else if (position%2 == 1) {
            holder.mfl.setPadding(0,0,0,8);
        }
        holder.mTv.setText(findMoreBean.getName());
        Glide.with(mContext).load(findMoreBean.getBgPicture()).into(holder.mIv_bg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.OnClick(position,findMoreBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv_bg;
        private final TextView mTv;
        private final FrameLayout mfl;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv_bg = itemView.findViewById(R.id.iv_bg);
            mTv = itemView.findViewById(R.id.tv);
            mfl = itemView.findViewById(R.id.fl);
        }
    }
     OnClickListener mOnClickListener;

         public interface OnClickListener{
             void OnClick(int position,FindMoreBean beans);
         }

         public void setOnClickListener(OnClickListener onClickListener) {
             mOnClickListener = onClickListener;
         }
}
