package com.zxn.mytest.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zxn.mytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_demo)
    public SimpleDraweeView ivDemo;
    @BindView(R.id.tv_subject)
    public TextView tvSubject;
    @BindView(R.id.tv_summary)
    public TextView tvSummary;

    public MyViewHolder(View itemView) {
        super(itemView);
//        ButterKnife.bind(itemView);
        ButterKnife.bind(this,itemView);
    }
}
