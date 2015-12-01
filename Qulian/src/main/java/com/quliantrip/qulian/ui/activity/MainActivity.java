package com.quliantrip.qulian.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.HomeFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.LanguageFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.LocationFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.MyFragment;
import com.quliantrip.qulian.ui.fragment.mainFragment.WifiFragment;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class MainActivity extends FragmentActivity{
    private static final int VIBRATE_DURATION = 20;
    private SwipeBackLayout mSwipeBackLayout;

    private ArrayList<BaseFragment> listFragment = new ArrayList<BaseFragment>();
    private RadioGroup radioGroup;
    private FrameLayout fullContent;
    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        applyKitKatTranslucency();
        setStatusBarTextColor(this,1);
        initData();
//        initBack();
    }

    //添加数据和对RadioGrope的显示进行监听
    private void initData() {
        radioGroup = (RadioGroup) findViewById(R.id.main_radio);
        fullContent = (FrameLayout) findViewById(R.id.fl_full_content);
        listFragment.clear();
        HomeFragment homeFragment = new HomeFragment();
        LocationFragment locationFragment = new LocationFragment();
        LanguageFragment languageFragment = new LanguageFragment();
        WifiFragment wifiFragment = new WifiFragment();
        MyFragment myFragment = new MyFragment();

        listFragment.add(homeFragment);
        listFragment.add(locationFragment);
        listFragment.add(languageFragment);
        listFragment.add(wifiFragment);
        listFragment.add(myFragment);

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
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_full_content, listFragment.get(index)).commit();


                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_full_content, listFragment.get(index)).commit();
                }
            }
        });
        radioGroup.check(R.id.rb_home_page);
    }

//    private Fragment preFragment;
//    //添加的添加子fragment,从新能上以后要使用add后的show或hide来进行
//    private void gotoSubFragment(Fragment fragment) {
//        //使用事物来进行添加
//        FragmentTransaction transaction = getSupportFragmentManager()
//                .beginTransaction();
//        if (preFragment != fragment) {
//            if (!fragment.isAdded()) {
//                transaction.add(R.id.fl_wrap_content, fragment).commit();
//            } else {
//                transaction.hide(preFragment).show(fragment).commit();
//            }
//            preFragment = fragment;
//        }
////        transaction.show(preFragment).commit();
//    }



    private void applyKitKatTranslucency() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setNavigationBarTintEnabled(true);
            mTintManager.setTintColor(android.R.color.white);
//            mTintManager.setNavigationBarTintColor(android.R.color.white);
//            mTintManager.setStatusBarTintColor(android.R.color.white);
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


    /**
     * 只支持MIUI V6
     * @param context
     * @param type 0--只需要状态栏透明 1-状态栏透明且黑色字体 2-清除黑色字体
     */
    public static void setStatusBarTextColor(Activity context, int type){
//        if (!isMiUIV6()){
////            DebugLog.d("isMiUIV6:"+false);
//            return;
//        }
//        DebugLog.d("isMiUIV6:"+true);
        Window window = context.getWindow();
        Class clazz = window.getClass();
        try {
            int tranceFlag = 0;
            int darkModeFlag = 0;
            Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT");
            tranceFlag = field.getInt(layoutParams);
            field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            if (type == 0){
                extraFlagField.invoke(window, tranceFlag, tranceFlag);//只需要状态栏透明
            }else if(type == 1){
                extraFlagField.invoke(window, tranceFlag | darkModeFlag, tranceFlag | darkModeFlag);//状态栏透明且黑色字体
            }else {
                extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
            }
        }catch (Exception e){

        }
    }

//    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
//    private static boolean isMiUIV6() {
//        try {
//            final BuildProperties prop = BuildProperties.newInstance();
//            String name = prop.getProperty(KEY_MIUI_VERSION_NAME, "");
//            if ("V6".equals(name)){
//                return  true;
//            }else {
//                return false;
//            }
////            return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null
////                    || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
////                    || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
//        } catch (final IOException e) {
//            return false;
//        }
//    }
}
