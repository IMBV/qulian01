package com.quliantrip.qulian.global;

import android.app.Application;
import android.content.SharedPreferences;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class QulianApplication extends Application {
//	private String phone;
//	private String password;
	private static RequestQueue queue;
//	private int tag = 0;
//	private SharedPreferences sp;

	@Override
	public void onCreate() {
		super.onCreate();
		queue = Volley.newRequestQueue(getApplicationContext());
//		sp = getSharedPreferences("login_register", MODE_PRIVATE);
//		tag = sp.getInt("isdenglu", 0);

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




}
