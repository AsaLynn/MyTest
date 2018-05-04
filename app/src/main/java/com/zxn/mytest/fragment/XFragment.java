package com.zxn.mytest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxn.mytest.MyApplication;
import com.zxn.mytest.R;
import com.zxn.mytest.adapter.XAdapter;
import com.zxn.mytest.entity.NewsBean;

import org.xutils.common.util.LogUtil;
import org.xutils.ex.DbException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class XFragment extends Fragment {
    @BindView(R.id.rv_retrofit)
    RecyclerView rvRetrofit;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.retrofit_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecyclerView();
        inidDb();
    }

    private void inidDb() {
        MyApplication application = (MyApplication) getActivity().getApplication();
        try {
            List<NewsBean> beans = application
                    .getDb()
                    .findAll(NewsBean.class);
            LogUtil.i(beans.toString());
            rvRetrofit.setAdapter(new XAdapter(beans));
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    private void initRecyclerView() {
        rvRetrofit
                .setHasFixedSize(true);
        rvRetrofit
                .setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvRetrofit
                .addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
