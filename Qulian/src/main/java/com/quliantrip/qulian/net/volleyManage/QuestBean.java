package com.quliantrip.qulian.net.volleyManage;

import com.quliantrip.qulian.domain.BaseJson;

import java.util.Map;

/**
 * Created by Yuly on 2015/12/3.
 * www.quliantrip.com
 */
public class QuestBean {

    public QuestBean(Map<String, String> map, BaseJson object, String url) {
        this.map = map;
        this.object = object;
        this.url = url;
    }

    private String url;
    private BaseJson object;
    private Map<String, String> map;

    public String getUrl() {
        return url;
    }

    public BaseJson getObject() {
        return object;
    }

    public void setObject(BaseJson object) {
        this.object = object;
    }

    public void setUrl(String url) {
        this.url = url;

    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
