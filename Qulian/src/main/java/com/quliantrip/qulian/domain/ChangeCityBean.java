package com.quliantrip.qulian.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yuly on 2015/12/25.
 * www.quliantrip.com
 */
public class ChangeCityBean extends BaseJson{

    private String ctl;
    private String act;
    private int status;
    private String info;
    private String city_name;
    @SerializedName("return")
    private int returnX;
    private String sess_id;
    private Object ref_uid;

    public void setCtl(String ctl) {
        this.ctl = ctl;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setReturnX(int returnX) {
        this.returnX = returnX;
    }

    public void setSess_id(String sess_id) {
        this.sess_id = sess_id;
    }

    public void setRef_uid(Object ref_uid) {
        this.ref_uid = ref_uid;
    }

    public String getCtl() {
        return ctl;
    }

    public String getAct() {
        return act;
    }

    public int getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public String getCity_name() {
        return city_name;
    }

    public int getReturnX() {
        return returnX;
    }

    public String getSess_id() {
        return sess_id;
    }

    public Object getRef_uid() {
        return ref_uid;
    }
}
