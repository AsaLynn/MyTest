package com.zxn.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_start)
    ImageView ivStart;
    @BindView(R.id.cv_start)
    CardView cvStart;
    private int topDistance;
    private int fromTop;
    private int centerY;
    private String TAG = this.getClass().getSimpleName();
    private TranslateAnimation mHideAnimation;
    private AlphaAnimation alphaAnimation;
    private RotateAnimation rotateAnimation;
    private ScaleAnimation scaleAnim;
    private AnimationSet setAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        start();
    }

    private void initAnimationSet() {
        setAnim = new AnimationSet(true);
        initScaleAnimation();
//        initAlphaAnimation();
        initRotateAnimation();
        setAnim.addAnimation(scaleAnim);
        setAnim.addAnimation(rotateAnimation);
        setAnim.setFillAfter(true);
        //Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
        setAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                initTranslateAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cvStart.setAnimation(setAnim);
    }

    private void initScaleAnimation() {
        scaleAnim = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnim.setDuration(2 * 1000);
    }

    private void start() {
        cvStart.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                cvStart.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                centerY = getWindowManager().getDefaultDisplay().getHeight() / 2;
                topDistance = centerY
                        - cvStart.getMeasuredHeight() / 2;
                fromTop = cvStart.getMeasuredHeight() / 2;
//                initRotateAnimation();
                initAnimationSet();
//                cvStart.startAnimation(rotateAnimation);

            }
        });
    }

    private void initAlphaAnimation() {
        //AlphaAnimation(float fromAlpha, float toAlpha)
        float fromAlpha = 1.0f;
        float toAlpha = 0.0f;
        alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(1 * 1000);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
                home();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cvStart.setAnimation(alphaAnimation);
    }

    private void home() {
        finish();
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void initTranslateAnimation() {
        //动画集合
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.setFillAfter(false);
//        animationSet.setRepeatMode(Animation.REVERSE);
//        animationSet.setRepeatCount(1);

        mHideAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.ABSOLUTE, -topDistance);
        mHideAnimation.setDuration(1 * 1000);
        mHideAnimation.setFillAfter(true);
        mHideAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                initAlphaAnimation();
//                cvStart.setAnimation(alphaAnimation);
//                initAnimationSet();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cvStart.setAnimation(mHideAnimation);
    }

    private void initRotateAnimation() {
        float fromDegrees = 0;
        float toDegrees = 360;
        float pivotXValue = 0.5f;
        float pivotYValue = 0.5f;
        int pivotXType = Animation.RELATIVE_TO_SELF;
        int pivotYType = Animation.RELATIVE_TO_SELF;
        rotateAnimation = new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue,
                pivotYType, pivotYValue);
        rotateAnimation.setDuration(1000);//设置动画持续时间
        //android:repeatMode:reverse|restart,重复类型,reverse:表示倒序回访,restart:表示重新放一遍这个属性必须与repeatCount联合使用，因为它的前提是重复，即重复播放时的播放类型。
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(3);//开始一次+重复3次,会旋转4次.
        rotateAnimation.setFillAfter(true);
//        animationSet.addAnimation(rotateAnimation);
        //animation.setStartOffset(long startOffset);//执行前的等待时间
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i(TAG, "onAnimationStart: --->");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i(TAG, "onAnimationEnd: --->");
//                initTranslateAnimation();
//                cvStart.startAnimation(mHideAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i(TAG, "onAnimationRepeat: --->");
            }
        });
        cvStart.setAnimation(rotateAnimation);
    }
}
