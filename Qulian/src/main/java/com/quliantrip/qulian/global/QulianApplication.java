package com.quliantrip.qulian.global;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class QulianApplication extends Application {
//	private String phone;
//	private String password;
	private static RequestQueue queue;
//	private int tag = 0;
//	private SharedPreferences sp;
private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		queue = Volley.newRequestQueue(getApplicationContext());
		context = this;
		initImageLoader(getContext());
//		sp = getSharedPreferences("login_register", MODE_PRIVATE);
//		tag = sp.getInt("isdenglu", 0);

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


//	public int getTag() {
//		return tag;
//	}
//
//	public void setTag(int tag) {
//		this.tag = tag;
//	}

//	private boolean getPassword = false;// 是否记住密码
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public boolean isGetPassword() {
//		return getPassword;
//	}
//
//	public void setGetPassword(boolean getPassword) {
//		this.getPassword = getPassword;
//	}


	//这里是返回voley的消息的队列
	public static RequestQueue getRequestQueue(){
		return queue;
	}
	// 添加获取的方法进行调用
	public static Context getContext() {
		return context;
	}



}
