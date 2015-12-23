package com.quliantrip.qulian.net.volleyManage;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.quliantrip.qulian.base.ContentPage;
import com.quliantrip.qulian.domain.BaseJson;

import de.greenrobot.event.EventBus;

public class ResponseListenner implements Response.Listener<String> {
    private BaseJson object;
    private OnLoadFinishListener onLoadFinishListener;

    public ResponseListenner(BaseJson object, OnLoadFinishListener onLoadFinishListener) {
        this.object = object;
        this.onLoadFinishListener = onLoadFinishListener;
    }

    @Override
    public void onResponse(String json) {
        String tag = null;
        if (object != null) {
            tag = object.getTag();
        }
        //打印请求的字符串
        System.out.println(json);
        object = new Gson().fromJson(json.trim(), object.getClass());
        object.setTag(tag);
//        //这里使用||进行判断是否进行数据的缓存
//        if ("com.quliantrip.qulian.ui.fragment.mainFragment.HomeFragment".equals(tag)) {
//             CommonHelp.saveStringSp(QulianApplication.getContext(), tag, json);
//        }
        if (onLoadFinishListener != null) {
            onLoadFinishListener.onLoadFinish(ContentPage.STATE_SUCCESS);
        }
        EventBus.getDefault().post(object);
    }

    public interface OnLoadFinishListener {
        void onLoadFinish(int object);
    }


}
