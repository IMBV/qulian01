package com.quliantrip.qulian.net.volleyManage;

import android.text.TextUtils;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.quliantrip.qulian.base.ContentPage;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.ToastUtil;

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
        String baseJson = CommonHelp.getStringSp(QulianApplication.getContext(), tag, "");//保存时进行首页数据的判断
        if (!TextUtils.isEmpty(baseJson)) {
            if (onLoadFinishListener != null) {
                onLoadFinishListener.onLoadFinish(ContentPage.STATE_SUCCESS);
            }
        } else {
            if (onLoadFinishListener != null) {
                onLoadFinishListener.onLoadFinish(ContentPage.STATE_ERROR);
            }
        }
    }
}


