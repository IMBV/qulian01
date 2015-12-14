package com.quliantrip.qulian.net.volleyManage;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.quliantrip.qulian.domain.BaseJson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyJsonObjectRequest extends JsonObjectRequest {

    private Map<String, String> params = new HashMap<String, String>();

//    public MyJsonObjectRequest(String url, Map<String, String> params, Listener<JSONObject> listener,
//                               ErrorListener errorListener) {
//        super(url + getUrlPath(params), listener, errorListener);
//        this.params = params;
//
//    }


    public MyJsonObjectRequest(String url, BaseJson object, Map map, ResponseListenner.OnLoadFinishListener onLoadFinishListener) {
        super(Method.GET, url,  new ResponseJsonListener(object, onLoadFinishListener), new ResponseErrorListener(onLoadFinishListener, object));
        this.params = map;
    }

    public static String getUrlPath(Map<String, String> params) {
        Iterator iter = params.entrySet().iterator();
        StringBuffer mBuffer = new StringBuffer();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            mBuffer.append(key + "=" + val + "&");
        }
        if (mBuffer.length() > 0) {
            mBuffer.deleteCharAt(mBuffer.length() - 1);
            mBuffer.insert(0, "?");
        }
        return mBuffer.toString();
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        // TODO Auto-generated method stub
        return params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        // TODO Auto-generated method stub
        Map<String, String> mHeaders = new HashMap<String, String>();
        mHeaders.put("Content-Type", "application/x-www-form-urlencoded");
        return mHeaders;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        // TODO Auto-generated method stub
        return super.parseNetworkResponse(response);
    }


}
