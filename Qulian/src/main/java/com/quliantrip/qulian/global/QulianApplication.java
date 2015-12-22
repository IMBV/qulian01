package com.quliantrip.qulian.global;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.quliantrip.qulian.domain.UserInfoBean;
import com.quliantrip.qulian.util.CommonHelp;

import java.util.Properties;
import java.util.UUID;

public class QulianApplication extends Application {

    private static Handler mainHandler;
    private static RequestQueue queue;
    private static Context mContext;

    private String userId;
    private boolean isLogin;
    private UserInfoBean user;


    private static QulianApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());

        instance = this;
        mContext = this;
        mainHandler = new Handler();
        initImageLoader(getContext());
        initLogin();
    }

    public static QulianApplication getInstance() {
        return instance;
    }


    public boolean containsProperty(String key) {
        Properties props = getProperties();
        return props.containsKey(key);
    }

    public void setProperties(Properties ps) {
        AppConfig.getAppConfig(this).set(ps);
    }

    public Properties getProperties() {
        return AppConfig.getAppConfig(this).get();
    }

    public void setProperty(String key, String value) {
        AppConfig.getAppConfig(this).set(key, value);
    }

    /**
     * 获取cookie时传AppConfig.CONF_COOKIE
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        String res = AppConfig.getAppConfig(this).get(key);
        return res;
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(this).remove(key);
    }


    private void initLogin() {
        user = getLoginUser();
        if (null != user && 1==user.getStatus()) {
            this.isLogin = true;
            userId = user.getId();
        } else {
            this.cleanLoginInfo();
        }
    }

    /**
     * 获取App唯一标识
     *
     * @return
     */
    public String getAppId() {
        String uniqueID = getProperty(AppConfig.CONF_APP_UNIQUEID);
        if (TextUtils.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            setProperty(AppConfig.CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }


    /**
     * 更新用户信息
     *
     * @param user
     */
    @SuppressWarnings("serial")
    public void updateUserInfo(final UserInfoBean user) {
        setProperties(new Properties() {
            {
                setProperty("user.act", user.getAct());
                setProperty("user.city_name", user.getCity_name());
                setProperty("user.ctl", user.getCtl());
                setProperty("user.email", user.getEmail());
                setProperty("user.id", user.getId());
                setProperty("user.info", user.getInfo());
                setProperty("user.is_tmp", user.getIs_tmp());
                setProperty("user.mobile", user.getMobile());
                setProperty("user.returnX", String.valueOf(user.getReturnX()));
                setProperty("user.sess_id", user.getSess_id());
                setProperty("user.status", String.valueOf(user.getStatus()));
                setProperty("user.user_name", user.getUser_name());
                setProperty("user.user_pwd", user.getUser_pwd());
            }
        });
    }

    public String getLoginUid() {
        return userId;
    }

    public boolean isLogin() {
        return this.isLogin;
    }


    /**
     * 用户注销
     */
    public void Logout() {
        cleanLoginInfo();
        this.isLogin = false;
        this.userId = "0";
    }

    /**
     * 保存登录信息
     */
    public void saveUserInfo(final UserInfoBean user) {
        this.userId = user.getId();

        this.isLogin = true;
        setProperties(new Properties() {
            {
                setProperty("user.act", user.getAct());
                setProperty("user.city_name", user.getCity_name());
                setProperty("user.ctl", user.getCtl());
                setProperty("user.email", user.getEmail());
                setProperty("user.id", user.getId());
                setProperty("user.info", user.getInfo());
                setProperty("user.is_tmp", user.getIs_tmp());
                setProperty("user.mobile", user.getMobile());
                setProperty("user.returnX", String.valueOf(user.getReturnX()));
                setProperty("user.sess_id", user.getSess_id());
                setProperty("user.status", String.valueOf(user.getStatus()));
                setProperty("user.user_name", user.getUser_name());
                setProperty("user.user_pwd", user.getUser_pwd());

            }
        });

    }

    /**
     * 获得登录用户的信息
     *
     * @return
     */
    public UserInfoBean getLoginUser() {
        UserInfoBean user = new UserInfoBean();
        user.setAct(getProperty("user.act"));
        user.setCity_name(getProperty("user.city_name"));
        user.setCtl(getProperty("user.ctl"));
        user.setEmail(getProperty("user.email"));
        user.setId(getProperty("user.id"));

        user.setInfo(getProperty("user.info"));
        user.setIs_tmp(getProperty("user.is_tmp"));
        user.setMobile(getProperty("user.mobile"));
        user.setReturnX(CommonHelp.toInt(getProperty("user.returnX"),0));
        user.setSess_id(getProperty("user.sess_id"));

        user.setStatus(CommonHelp.toInt(getProperty("user.status"),0));
        user.setUser_name(getProperty("user.user_name"));
        user.setUser_pwd(getProperty("user.user_pwd"));
        return user;
    }
    /**
     * 清除登录信息
     */
    public void cleanLoginInfo() {
        this.userId = "0";
        this.isLogin = false;
        removeProperty("user.act", "user.city_name","user.ctl","user.email","user.id",
                "user.info","user.is_tmp","user.mobile","user.returnX","user.sess_id"
                ,"user.status","user.user_name","user.user_pwd");
    }


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
