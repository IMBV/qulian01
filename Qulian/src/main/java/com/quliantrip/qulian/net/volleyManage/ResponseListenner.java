package com.quliantrip.qulian.net.volleyManage;
import android.text.TextUtils;

import com.android.volley.*;
import com.google.gson.Gson;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.CommonHelp;

import de.greenrobot.event.EventBus;

public class ResponseListenner implements Response.Listener<String>{
	private BaseJson object;
	private OnLoadFinishListener onLoadFinishListener;
	public ResponseListenner(BaseJson object,OnLoadFinishListener onLoadFinishListener) {
		this.object=object;
		this.onLoadFinishListener = onLoadFinishListener;
	}
	@Override
	public void onResponse(String json) {
		String tag=null;
		if (object!=null) {
			tag=object.getTag();
		}
		object=new Gson().fromJson(json, object.getClass());
		object.setTag(tag);
		if("com.quliantrip.qulian.ui.fragment.listRefreshFragment.TestFragment" .equals(tag)){
			CommonHelp.saveStringSp(QulianApplication.getContext(),tag,json);
		}

		if(onLoadFinishListener != null){
			onLoadFinishListener.onLoadFinish(object);
		}
		EventBus.getDefault().post(object);
	}

	public interface OnLoadFinishListener {
		void onLoadFinish(BaseJson object);
	}


}
