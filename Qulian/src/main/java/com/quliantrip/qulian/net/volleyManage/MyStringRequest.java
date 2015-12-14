package com.quliantrip.qulian.net.volleyManage;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyStringRequest extends StringRequest {

    private Map<String, String> params = new HashMap<String, String>();
    private String url;

    public MyStringRequest(String url, Map<String, String> params, Listener<String> listener,
                           ErrorListener errorListener) {
        super(url, listener, errorListener);
        this.url = url;
        this.params = params;
    }


    public MyStringRequest(int method, String url, Map<String, String> params, Listener<String> listener,
                           ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.url = url;
        this.params = params;
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
//         mApplication = ZZApplication.getInstance();
//        if (mApplication.isLogin()) {
//            mHeaders.put("Authorization", mApplication.mLogin.access_token);
//        }
        mHeaders.put("Content-Type", "application/x-www-form-urlencoded");
        return mHeaders;
    }

    public String getUrlPath(Map<String, String> params) {
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
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        // TODO Auto-generated method stub
        return super.parseNetworkResponse(response);
    }

}
