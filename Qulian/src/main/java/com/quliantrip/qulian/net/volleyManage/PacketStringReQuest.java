package com.quliantrip.qulian.net.volleyManage;

import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;

public class PacketStringReQuest extends StringRequest {
	private Map map;

	public PacketStringReQuest(String url, BaseJson object, Map map,ResponseListenner.OnLoadFinishListener onLoadFinishListener) {
		super(Method.POST, url,new ResponseListenner(object,onLoadFinishListener), new ResponseErrorListener(onLoadFinishListener,object));
		this.map=map;
		QulianApplication.getRequestQueue().add(this);
	}
	public PacketStringReQuest(String url, BaseJson object,ResponseListenner.OnLoadFinishListener onLoadFinishListener) {
		 super(url, new ResponseListenner(object,onLoadFinishListener), new ResponseErrorListener(onLoadFinishListener,object));
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
