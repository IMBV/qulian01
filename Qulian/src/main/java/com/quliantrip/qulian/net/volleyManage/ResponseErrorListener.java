package com.quliantrip.qulian.net.volleyManage;

import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public class ResponseErrorListener implements ErrorListener{

	@Override
	public void onErrorResponse(VolleyError arg0) {
		  Log.i("ResponseErrorListener", "+++++++++错了");
	}

}
