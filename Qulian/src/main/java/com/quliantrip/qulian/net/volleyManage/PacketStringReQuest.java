package com.quliantrip.qulian.net.volleyManage;

import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.quliantrip.qulian.base.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;

public class PacketStringReQuest extends StringRequest {
	private Map map;

	public PacketStringReQuest(String url, BaseJson object, Map map) {
		super(Method.POST, url,new ResponseListenner(object), new ResponseErrorListener());
		this.map=map;
		QulianApplication.getRequestQueue().add(this);
	}
	public PacketStringReQuest(String url, BaseJson object) {
		 super(url, new ResponseListenner(object), new ResponseErrorListener());
		QulianApplication.getRequestQueue().add(this);
	}
	
	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return map;
	}
}
