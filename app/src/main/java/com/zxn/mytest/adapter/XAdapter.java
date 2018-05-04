package com.zxn.mytest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zxn.mytest.R;
import com.zxn.mytest.entity.NewsBean;
import com.zxn.mytest.holder.XViewHolder;

import java.util.List;

public class XAdapter extends RecyclerView.Adapter<XViewHolder> {


    private List<NewsBean> mBeans;

    public XAdapter(List<NewsBean> beans) {
        mBeans = beans;

    }

    @NonNull
    @Override
    public XViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new XViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_x, null));
    }

    @Override
    public void onBindViewHolder(@NonNull XViewHolder holder, int position) {
        holder.setData(mBeans.get(position));
    }


    @Override
    public int getItemCount() {
        return mBeans == null ? 0 : mBeans.size();
    }
}
