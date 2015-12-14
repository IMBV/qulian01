package com.quliantrip.qulian.net.volleyManage;

import com.android.volley.Response;
import com.quliantrip.qulian.base.ContentPage;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.ToastUtil;

import org.json.JSONObject;

/**
 * Created by Yuly on 2015/12/11.
 * www.quliantrip.com
 */
public class ResponseJsonListener implements Response.Listener<JSONObject> {
    private BaseJson object;
    private OnLoadFinishListener onLoadFinishListener;

    public ResponseJsonListener(BaseJson object, OnLoadFinishListener onLoadFinishListener) {
        this.object = object;
        this.onLoadFinishListener = onLoadFinishListener;
    }


    @Override
    public void onResponse(JSONObject response) {
        ToastUtil.showToast(QulianApplication.getContext(),"json请求成功");
//
//        String tag = null;
//        if (object != null) {
//            tag = object.getTag();
//        }
//        object = new Gson().fromJson(json, object.getClass());
//        object.setTag(tag);
        //这里使用||进行判断是否进行数据的缓存
//        if ("com.quliantrip.qulian.ui.fragment.mainFragment.HomeFragment".equals(tag)) {
//            CommonHelp.saveStringSp(QulianApplication.getContext(), tag, json);
//        }
        if (onLoadFinishListener != null) {
            onLoadFinishListener.onLoadFinish(ContentPage.STATE_SUCCESS);
        }
//        EventBus.getDefault().post(object);
    }

    public interface OnLoadFinishListener {
        void onLoadFinish(int object);
    }


}
