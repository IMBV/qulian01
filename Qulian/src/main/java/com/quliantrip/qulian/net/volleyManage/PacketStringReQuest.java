package com.quliantrip.qulian.net.volleyManage;

import android.text.TextUtils;

import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.CommonHelp;

import de.greenrobot.event.EventBus;

public class PacketStringReQuest extends StringRequest {
	private Map map;
	public PacketStringReQuest(String url, BaseJson object, Map map,ResponseListenner.OnLoadFinishListener onLoadFinishListener) {
		super(Method.POST, url,new ResponseListenner(object,onLoadFinishListener), new ResponseErrorListener(onLoadFinishListener,object));
		this.map=map;
		String tag = null;
		if (object != null) {
			tag = object.getTag();
		}
		String baseJson = CommonHelp.getStringSp(QulianApplication.getContext(), tag, "");
		if (!TextUtils.isEmpty(baseJson)) {
			object = new Gson().fromJson(baseJson, object.getClass());
			object.setTag(tag);
			EventBus.getDefault().post(object);
		}
		QulianApplication.getRequestQueue().add(this);
	}
	public PacketStringReQuest(String url, BaseJson object,ResponseListenner.OnLoadFinishListener onLoadFinishListener) {
		 super(url, new ResponseListenner(object,onLoadFinishListener), new ResponseErrorListener(onLoadFinishListener,object));
		String tag = null;
		if (object != null) {
			tag = object.getTag();
		}
		String baseJson = CommonHelp.getStringSp(QulianApplication.getContext(), tag, "");
		if (!TextUtils.isEmpty(baseJson)) {
			object = new Gson().fromJson(baseJson, object.getClass());
			object.setTag(tag);
			EventBus.getDefault().post(object);
		}
		QulianApplication.getRequestQueue().add(this);
	}
	
	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}


}
