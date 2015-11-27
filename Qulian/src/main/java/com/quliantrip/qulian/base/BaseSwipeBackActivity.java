package com.quliantrip.qulian.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
/**
 * 这里activity的主题使用的是的android:theme="@style/SwipeBackActivity">
 * */
public abstract class BaseSwipeBackActivity extends SwipeBackActivity {

    private static final int VIBRATE_DURATION = 20;//这里表示的震动的持续时间
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initSwipe();
        initFindView();
    }

    //这是让子类来进行添加布局
    public abstract int getContentView();

    //添加布局文件
    public abstract void initFindView();

    //添加布局中的数据
    public abstract void initData();

    //添加可以滑动销毁activity的方法
    private void initSwipe() {
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        //添加滑动手机震动的监听
        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {

            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                vibrate(VIBRATE_DURATION);
            }

            @Override
            public void onScrollOverThreshold() {
                vibrate(VIBRATE_DURATION);
            }
        });
    }

    //添加手机抖动的效果
    private void vibrate(long duration) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {
                0, duration
        };
        vibrator.vibrate(pattern, -1);
    }

}
