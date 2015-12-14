package com.quliantrip.qulian;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.MyJsonObjectRequest;
import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;
import com.quliantrip.qulian.util.ToastUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
//    http://www.quliantrip.com/wap/index.php?ctl=user&act=login


//    public void test(){
//        Map<String ,String> params = new HashMap<String,String>();
//        params.put("ctl","user");
//        params.put("act","login");
//        new PacketStringReQuest("http://www.quliantrip.com/wap/index.php",null,params);
//    }
    public void test2(){
        String url = "http://192.168.0.155/index.php";
        JsonObjectRequest objRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject obj) {
                        System.err.println("----------:" + obj);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.getMessage();
                System.err.println("----------:" + "a");
            }

        });
        QulianApplication.getRequestQueue().add(objRequest);

//        RequestQueue queue = Volley.newRequestQueue(QulianApplication.getContext());
//        String url = "http://dev.qulian.com/mapi/index.php";
//        JsonObjectRequest objRequest = new JsonObjectRequest(url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject obj) {
//                        System.out.println("----------:" + obj);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.getMessage();
//            }
//
//        });
//        objRequest.setTag("obj");
//        queue.add(objRequest);

//        Map<String, String> map = new HashMap<String,String>();
//        map.put("ctl","index");
//        map.put("act","index");
//        map.put("r_type","1");
//        new PacketStringReQuest(HttpConstants.HOST_ADDR_ROOT_Test,);
//        final Map<String, String> params = new HashMap<String, String>();
//
//        QulianApplication.getRequestQueue().add(new MyJsonObjectRequest(
//                "http://dev.qulian.com/mapi/index.php?ctl=index&act=index&r_type=1", params,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        ToastUtil.showToast(mContext, "网络异常");
//                        System.out.println(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                ToastUtil.showToast(mContext, "网络异常");
//            }
//        }));

//        QulianApplication.getRequestQueue().add(new MyJsonObjectRequest("http://192.168.0.155/mapi/index.php?ctl=index&act=index&r_type=1",                        params,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                System.out.println(response);
//                            }
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                ToastUtil.showToast(mContext, "网络异常");
//                                System.err.println("网络异常");
//                            }
//                        }));

    }
}