package com.zxn.mytest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.zxn.mytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WebFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.wv_content)
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_web, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings set = webView.getSettings();
        //设置webview支持js
        set.setJavaScriptEnabled(true);
        //设置本地调用对象及其接口
        webView.addJavascriptInterface(new JsInteraction(), "control");
        webView.loadUrl("file:///android_asset/test.html");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn2:
                webView.loadUrl("javascript:sayHello()");
                break;
        }
    }

    public class JsInteraction {
        //提供给js调用的方法
        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        }
    }
}
