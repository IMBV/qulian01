package com.quliantrip.qulian.util;

import android.util.Log;

public class LogUtils {

    public static boolean isShow = true;

    // 用于答应那个tag表示的日志
    public static void d(String tag, String msg) {
        if (isShow) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isShow) {
            Log.e(tag, msg);
        }
    }

    // 用于打印那个类的名字出现的错误的日志，使用是logUtil.d(this,String);
    public static void d(Object object, String msg) {
        if (isShow) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void e(Object object, String msg) {
        if (isShow) {
            Log.e(object.getClass().getSimpleName(), msg);
        }
    }
}