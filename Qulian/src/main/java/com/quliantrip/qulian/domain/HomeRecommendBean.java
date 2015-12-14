package com.quliantrip.qulian.domain;

/**
 * Created by Yuly on 2015/12/10.
 * www.quliantrip.com
 */
public class HomeRecommendBean extends BaseJson {

    public HomeRecommendBean(String des, String imageUrl) {
        this.des = des;
        this.imageUrl = imageUrl;
    }

    private String imageUrl;
    private String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
