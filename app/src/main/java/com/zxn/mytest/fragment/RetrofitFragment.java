package com.zxn.mytest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zxn.mytest.MyApplication;
import com.zxn.mytest.R;
import com.zxn.mytest.adapter.MyAdapter;
import com.zxn.mytest.api.ApiServer;
import com.zxn.mytest.entity.NewsBean;
import com.zxn.mytest.model.NewsInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFragment extends Fragment {

    @BindView(R.id.rv_retrofit)
    RecyclerView rvRetrofit;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.retrofit_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvRetrofit.setHasFixedSize(true);
        rvRetrofit
                .setLayoutManager(new LinearLayoutManager(getContext(),
                        LinearLayoutManager.VERTICAL,
                        false));
        rvRetrofit
                .addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        request();

    }

    private void request() {
        new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getNewsInfo(ApiServer.URL)
                .enqueue(new Callback<NewsInfo>() {
                    @Override
                    public void onResponse(Call<NewsInfo> call, Response<NewsInfo> response) {
                        refreshView(response.body());
                        saveDb(response.body());
                    }

                    @Override
                    public void onFailure(Call<NewsInfo> call, Throwable t) {
                        Log.i(RetrofitFragment.this.getClass().getSimpleName(), "onFailure: ".concat(t.getMessage()));
                    }
                });

    }

    private void saveDb(NewsInfo body) {
        ArrayList<NewsBean> list = new ArrayList<>();
        for (int i = 0; i < body.getParamz().getFeeds().size(); i++) {
            NewsBean bean = new NewsBean();
            NewsInfo.ParamzBean.FeedsBean.DataBean data = body.getParamz().getFeeds().get(i).getData();
            bean.setSubject(data.getSubject());
            bean.setCover(data.getCover());
            bean.setSummary(data.getSummary());
            list.add(bean);
        }
        MyApplication application = (MyApplication) getActivity().getApplication();
        try {
            application.getDb().save(list);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(application, "save db is error !", Toast.LENGTH_SHORT).show();
        }
    }

    private void refreshView(NewsInfo info) {
        rvRetrofit.setAdapter(new MyAdapter(info));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
