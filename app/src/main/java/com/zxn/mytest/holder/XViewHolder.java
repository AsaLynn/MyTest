package com.zxn.mytest.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxn.mytest.R;
import com.zxn.mytest.api.ApiServer;
import com.zxn.mytest.entity.NewsBean;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_x)
    public ImageView ivX;
    @BindView(R.id.tv_subject)
    public TextView tvSubject;
    @BindView(R.id.tv_summary)
    public TextView tvSummary;
    private final ImageOptions imageOptions;

    public XViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        imageOptions = new ImageOptions
                .Builder()
                .setRadius(10)//设置拐角弧度
                .setFadeIn(true) //淡入效果
                .setCircular(true) //设置图片显示为圆形
                .setSquare(false) //设置图片显示为正方形
                .setCrop(true)
                .setSize(300, 300) //设置大小
                //.setAnimation(animation) //设置动画
                //.setFailureDrawable(Drawable failureDrawable) //设置加载失败的动画
                .setFailureDrawableId(R.mipmap.ic_launcher_round) //以资源id设置加载失败的动画
                //.setLoadingDrawable(Drawable loadingDrawable) //设置加载中的动画
                .setLoadingDrawableId(R.mipmap.icon_progress_bar) //以资源id设置加载中的动画
                .setIgnoreGif(false) //忽略Gif图片
                .setUseMemCache(true) //设置使用MemCache，默认true
                .build();
        //.setParamsBuilder(ParamsBuilder paramsBuilder) //在网络请求中添加一些参数
    }

    public void setData(NewsBean newsBean) {
        tvSubject.setText(newsBean.getSubject());
        tvSummary.setText(newsBean.getSummary());
        x
                .image()
                .bind(ivX, ApiServer.BASE_URL.concat(newsBean.getCover()),imageOptions);
    }
}
