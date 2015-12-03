package com.quliantrip.qulian;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;

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


    public void test(){
        Map<String ,String> params = new HashMap<String,String>();
        params.put("ctl","user");
        params.put("act","login");
        new PacketStringReQuest("http://www.quliantrip.com/wap/index.php",null,params);
    }
}