package com.zxn.mytest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zxn.mytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ScreenFragment extends Fragment {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.tv_screen)
    TextView tvScreen;
    Unbinder unbinder;
    private int screenHeight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int height = tvScreen.getHeight();
        Toast.makeText(getActivity(), "tvScreenheight--->" + height, Toast.LENGTH_SHORT).show();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        // 屏幕高（像素，如：1280px）
        screenHeight = dm.heightPixels;
        tvScreen.setHeight(screenHeight/2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                if (tvScreen.getHeight() != screenHeight/2) {
                    tvScreen.setHeight(screenHeight/2);
                }else {
                    Toast.makeText(getContext(), "this height is sceen/2", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn2:
                if (tvScreen.getHeight() != screenHeight/4) {
                    tvScreen.setHeight(screenHeight/4);
                }else {
                    Toast.makeText(getContext(), "this height is sceen/4", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
