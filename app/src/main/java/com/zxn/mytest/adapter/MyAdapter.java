package com.zxn.mytest.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.zxn.mytest.R;
import com.zxn.mytest.api.ApiServer;
import com.zxn.mytest.holder.MyViewHolder;
import com.zxn.mytest.model.NewsInfo;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final NewsInfo mInfo;


    public MyAdapter(NewsInfo info) {
        mInfo = info;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_news, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        NewsInfo.ParamzBean.FeedsBean.DataBean data
                = mInfo.getParamz().getFeeds().get(i).getData();
        myViewHolder.tvSubject.setText(data.getSubject());
        myViewHolder.tvSummary.setText(data.getSummary());
        Uri uri = Uri.parse(ApiServer.BASE_URL.concat(data.getCover()));
        myViewHolder.ivDemo.setImageURI(uri);

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setAutoRotateEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();
        myViewHolder.ivDemo.setController(controller);
    }

    @Override
    public int getItemCount() {
        return mInfo == null ? 0 : mInfo.getParamz().getFeeds().size();
    }
}
