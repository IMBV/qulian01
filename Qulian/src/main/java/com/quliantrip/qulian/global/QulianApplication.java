package com.quliantrip.qulian.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.quliantrip.qulian.util.CommonHelp;

public class QulianApplication extends Application {

    private static Handler mainHandler;
    private static RequestQueue queue;
    private static Context mContext;

    private boolean isLogin;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
        mContext = this;
        mainHandler = new Handler();
        initImageLoader(getContext());

        initLogin();
    }


    private void initLogin() {
        //用户的唯一表示来进行判断
//        if(null != getUniquenUserId()){
//
//        }


    }

//    private int getUniquenUserId(){
//        return null;
//    }


    //从sp中获取获取登录状态，通过获取用户的唯一标示来进行显示的数据
    private boolean getIsLogin() {
        return CommonHelp.getsp(mContext, "loginCondition", false);
    }
    //保存


    //这里是返回voley的消息的队列
    public static RequestQueue getRequestQueue() {
        return queue;
    }

    // 添加获取的方法进行调用
    public static Context getContext() {
        return mContext;
    }

    //获取应用的handle
    public static Handler getMainHandler() {
        return mainHandler;
    }

    //初始化imageLoader
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
                context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();// 不会在内存中缓存多个大小的图片
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());// 为了保证图片名称唯一
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        // 内存缓存大小默认是：app可用内存的1/8
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
        // ImageLoader.getInstance().init(
        // ImageLoaderConfiguration.createDefault(this));
    }
}
