package com.quliantrip.qulian.ui.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.ui.showFragment.HomeFragment;
import com.quliantrip.qulian.ui.showFragment.LanguageFragment;
import com.quliantrip.qulian.ui.showFragment.LocationFragment;
import com.quliantrip.qulian.ui.showFragment.MyFragment;
import com.quliantrip.qulian.ui.showFragment.WifiFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {
    private static final int VIBRATE_DURATION = 20;
    private SwipeBackLayout mSwipeBackLayout;

    private ArrayList<BaseFragment> listFragment = new ArrayList<BaseFragment>();
    private RadioGroup radioGroup;
    private FrameLayout wrapContent;
    private FrameLayout fullContent;
    private SystemBarTintManager mTintManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applyKitKatTranslucency();
        initData();
        initBack();

    }

    //添加数据和对RadioGrope的显示进行监听
    private void initData() {
        radioGroup = (RadioGroup) findViewById(R.id.main_radio);
        wrapContent = (FrameLayout) findViewById(R.id.fl_wrap_content);
        fullContent = (FrameLayout) findViewById(R.id.fl_full_content);
        listFragment.clear();
        getSupportFragmentManager().beginTransaction();
        listFragment.add(new HomeFragment());
        listFragment.add(new LocationFragment());
        listFragment.add(new LanguageFragment());
        listFragment.add(new WifiFragment());
        listFragment.add(new MyFragment());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.rb_home_page:
                        index = 0;
                        break;
                    case R.id.rb_local_page:
                        index = 1;
                        break;
                    case R.id.rb_language_page:
                        index = 2;
                        break;
                    case R.id.rb_wifi_page:
                        index = 3;
                        break;
                    case R.id.rb_myinfo_page:
                        index = 4;
                        break;
                }

                //进行UI显示是否到顶
                if (index != 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_wrap_content, listFragment.get(index)).commit();
                    fullContent.setVisibility(View.GONE);
                    wrapContent.setVisibility(View.VISIBLE);
                    mTintManager.setStatusBarTintResource(R.color.background_tab_pressed);
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_full_content, listFragment.get(index)).commit();
                    fullContent.setVisibility(View.VISIBLE);
                    wrapContent.setVisibility(View.GONE);
                    mTintManager.setStatusBarTintResource(Color.TRANSPARENT);
                }
            }
        });
        radioGroup.check(R.id.rb_home_page);
    }

    //添加的添加子fragment,从新能上以后要使用add后的show或hide来进行
    private void gotoSubFragment(Fragment fragment){
        //使用事物来进行添加
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_full_content, listFragment.get(index)).commit();

    }


    //设置拖拽返回
    private void initBack() {
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
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

    private void applyKitKatTranslucency() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
//            mTintManager.setNavigationBarTintEnabled(true);
            int color = Color.argb(00, 00, 00, 00);
            mTintManager.setTintColor(color);
        }

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
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
