package com.zxn.mytest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.stx.xhb.commontitlebar.CustomTitleBar;
import com.stx.xhb.commontitlebar.widget.UIAlphaImageButton;
import com.zxn.mytest.adapter.MyFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.titlebar)
    CustomTitleBar mTopBar;
    @BindView(R.id.tl_top)
    TabLayout tlTop;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initTop();
        initTabLayout();
    }

    private void initTabLayout() {
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpContent.setAdapter(adapter);
        tlTop.setupWithViewPager(vpContent);
        for (int i = 0; i < adapter.getCount(); i++) {
            tlTop.newTab().setText(adapter.getPageTitle(i));
        }
    }

    private void initTop() {
        int rightId = 102;
        UIAlphaImageButton button = mTopBar.addLeftBackImageButton();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "back", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mTopBar.addRightTextButton("share", rightId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "share", Toast.LENGTH_SHORT).show();
                showShare();

            }
        });
        mTopBar.setTitle("title");

    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(getString(R.string.share));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("If life is divided by two,the former is \"no hesitation\" and the latter is \"no regret\".");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/1.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(this);
    }
}
