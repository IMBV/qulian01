package com.quliantrip.qulian.domain;

/**
 * Created by Yuly on 2015/12/23.
 * www.quliantrip.com
 */
public class ImageBean extends BaseJson {

    public ImageBean(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String id;
    public String name;
    public String url;

}
