package com.quliantrip.qulian;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.quliantrip.qulian.global.QulianApplication;

import org.json.JSONObject;

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
//    public void testJieshon(){
//        String json = "{\n" +
//                "    \"0\": [\n" +
//                "        {\n" +
//                "            \"id\": \"8\",\n" +
//                "            \"name\": \"韩国\",\n" +
//                "            \"pid\": \"0\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"9\",\n" +
//                "            \"name\": \"日本\",\n" +
//                "            \"pid\": \"0\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"8\": [\n" +
//                "        {\n" +
//                "            \"id\": \"51\",\n" +
//                "            \"name\": \"济州岛\",\n" +
//                "            \"pid\": \"8\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"52\",\n" +
//                "            \"name\": \"仁川\",\n" +
//                "            \"pid\": \"8\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"20\",\n" +
//                "            \"name\": \"屏山\",\n" +
//                "            \"pid\": \"8\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"14\",\n" +
//                "            \"name\": \"首尔\",\n" +
//                "            \"pid\": \"8\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"13\",\n" +
//                "            \"name\": \"釜山\",\n" +
//                "            \"pid\": \"8\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"9\": [\n" +
//                "        {\n" +
//                "            \"id\": \"44\",\n" +
//                "            \"name\": \"东京\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"43\",\n" +
//                "            \"name\": \"大阪\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"61\",\n" +
//                "            \"name\": \"箱根\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"45\",\n" +
//                "            \"name\": \"北海道\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"53\",\n" +
//                "            \"name\": \"京都\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"60\",\n" +
//                "            \"name\": \"静冈\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"55\",\n" +
//                "            \"name\": \"富士山\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"56\",\n" +
//                "            \"name\": \"冲绳\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"57\",\n" +
//                "            \"name\": \"名古屋\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"58\",\n" +
//                "            \"name\": \"横滨\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"59\",\n" +
//                "            \"name\": \"福冈\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": \"46\",\n" +
//                "            \"name\": \"新宿\",\n" +
//                "            \"pid\": \"9\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//        try {
//
//
//            JSONObject jsonObject = new JSONObject(json);
//
////            Map result = new HashMap();
////            Iterator<String> iter =  jsonObject.keys();
////
////            String key = null;
////            String value = null;
////
////            while (iter.hasNext()){
////                JSONArray array = JSONArray.optJSONArray(iter.next());
////                int i,j;
////                for (i=0;i<array.length();i++) {
////                    for (j=0;array.optJSONArray(i).length();j++){
////
////                    }
////
////                }
////
////            }
//
//            System.out.println(jsonObject.opt("8"));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
    public void testJieshon2(){
        String json = "{\n" +
                "        \"8\": \"韩国\",\n" +
                "        \"9\": \"日本\"\n" +
                "    }";


                String json2 = "{\n" +
                "    \"0\": [\n" +
                "        {\n" +
                "            \"id\": \"8\",\n" +
                "            \"name\": \"韩国\",\n" +
                "            \"pid\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"9\",\n" +
                "            \"name\": \"日本\",\n" +
                "            \"pid\": \"0\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"8\": [\n" +
                "        {\n" +
                "            \"id\": \"51\",\n" +
                "            \"name\": \"济州岛\",\n" +
                "            \"pid\": \"8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"52\",\n" +
                "            \"name\": \"仁川\",\n" +
                "            \"pid\": \"8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"20\",\n" +
                "            \"name\": \"屏山\",\n" +
                "            \"pid\": \"8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"14\",\n" +
                "            \"name\": \"首尔\",\n" +
                "            \"pid\": \"8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"13\",\n" +
                "            \"name\": \"釜山\",\n" +
                "            \"pid\": \"8\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"9\": [\n" +
                "        {\n" +
                "            \"id\": \"44\",\n" +
                "            \"name\": \"东京\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"43\",\n" +
                "            \"name\": \"大阪\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"61\",\n" +
                "            \"name\": \"箱根\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"45\",\n" +
                "            \"name\": \"北海道\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"53\",\n" +
                "            \"name\": \"京都\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"60\",\n" +
                "            \"name\": \"静冈\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"55\",\n" +
                "            \"name\": \"富士山\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"56\",\n" +
                "            \"name\": \"冲绳\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"57\",\n" +
                "            \"name\": \"名古屋\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"58\",\n" +
                "            \"name\": \"横滨\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"59\",\n" +
                "            \"name\": \"福冈\",\n" +
                "            \"pid\": \"9\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"46\",\n" +
                "            \"name\": \"新宿\",\n" +
                "            \"pid\": \"9\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
//        try {
//            Test test = new Test();
//            JSONObject jsonObject = new JSONObject(json);
//            Iterator<String> iter = jsonObject.keys();//转化为支付串1的key的值
//
//            JSONObject jsonObject2 = new JSONObject(json2);
//            while (iter.hasNext()){
//                JSONArray jsonArray = jsonObject2.getJSONArray(iter.next()+"");
//
//                ArrayList<Test.TextCity> cityList = new ArrayList<Test.TextCity>();
//                for (int i= 0;i<jsonArray.length();i++){
//                    JSONObject object = jsonArray.optJSONObject(i);
//
////                    cityList.add(new Test.TextCity(object.getString("id"),object.getString("name")
////                    ,object.getString("pid")));
//                }
//
//                test.getCityList().put(iter.next(),cityList);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }
}