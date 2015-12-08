package com.quliantrip.qulian.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.quliantrip.qulian.global.QulianApplication;

/**
 * Created by yuly on 2015/11/9.
 */
public class CommonHelp {
    public static void runOnUIThread(Runnable r) {
		QulianApplication.getMainHandler().post(r);
	}

	public static void runOnUIThread(Runnable r, long delayMillis) {
		QulianApplication.getMainHandler().postDelayed(r, delayMillis);
	}

    //该方法表示把自己从ViewParent中移除
    public static void removeSelfFromParent(View child) {
        if(child!=null){
            ViewParent parent = child.getParent();
            if(parent!=null && parent instanceof ViewGroup){
                ViewGroup group = (ViewGroup) parent;
                group.removeView(child);//将子VIew从父View中移除
            }
        }
    }

    public static Resources getResources() {
        return QulianApplication.getContext().getResources();
    }

    public static String getString(int id) {
        return getResources().getString(id);
    }

    /**
     * 获取字符串数组资源
     *
     * @param id
     * @return
     */
    public static String[] getStringArray(int id) {
        return getResources().getStringArray(id);
    }

    public static int getColor(int id) {
        return getResources().getColor(id);
    }

    public static Drawable getDrawable(int id) {
        return getResources().getDrawable(id);
    }

    public static float getDimens(int id) {
        return getResources().getDimension(id);
    }

    /**
     * dip转化为px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转化为dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    private static final String CONFIG_NAME = "configQulian";

    //保存和获取boolean类型到sp中
    public static void saveSp(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG_NAME,
                context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getsp(Context context, String key,
                                boolean defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG_NAME,
                context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }

    //保存和获取String类型到sp中
    public static void saveStringSp(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG_NAME,
                context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getStringSp(Context context, String key,
                                     String defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG_NAME,
                context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }



}
