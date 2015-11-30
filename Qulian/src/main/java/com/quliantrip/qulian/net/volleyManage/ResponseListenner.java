package com.quliantrip.qulian.net.volleyManage;
import com.android.volley.*;
import com.google.gson.Gson;
import com.quliantrip.qulian.base.BaseJson;

import de.greenrobot.event.EventBus;

public class ResponseListenner implements Response.Listener<String>{
	private BaseJson object;
	public ResponseListenner(BaseJson object) {
		this.object=object;
	}
	@Override
	public void onResponse(String json) {
		String tag=null;
		if (object!=null) {
			tag=object.getTag();
		}
		object=new Gson().fromJson(json, object.getClass());
		object.setTag(tag);
		EventBus.getDefault().post(object);
	}
}
