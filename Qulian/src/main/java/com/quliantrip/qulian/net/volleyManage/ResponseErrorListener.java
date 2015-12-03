package com.quliantrip.qulian.net.volleyManage;

import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.ToastUtil;

import de.greenrobot.event.EventBus;

public class ResponseErrorListener implements ErrorListener {
    private BaseJson object;
    private ResponseListenner.OnLoadFinishListener onLoadFinishListener;

    public ResponseErrorListener(ResponseListenner.OnLoadFinishListener onLoadFinishListener, BaseJson object) {
        this.onLoadFinishListener = onLoadFinishListener;
        this.object = object;
    }

    @Override
    public void onErrorResponse(VolleyError arg0) {
        ToastUtil.showToast(QulianApplication.getContext(), "网络请求错误，请检查网络。");
        String tag = null;
        if (object != null) {
            tag = object.getTag();
        }
        String homeFragmentJson = CommonHelp.getStringSp(QulianApplication.getContext(), tag, "");//保存时进行首页数据的判断
        if (!TextUtils.isEmpty(homeFragmentJson)) {
            object = new Gson().fromJson(homeFragmentJson, object.getClass());
            object.setTag(tag);
            if (onLoadFinishListener != null) {
                onLoadFinishListener.onLoadFinish(object);
            }
            EventBus.getDefault().post(object);
        } else {
            if (onLoadFinishListener != null) {
                onLoadFinishListener.onLoadFinish(null);
            }
        }
    }
}


