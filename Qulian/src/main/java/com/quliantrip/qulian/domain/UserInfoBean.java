package com.quliantrip.qulian.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yuly on 2015/12/17.
 * www.quliantrip.com
 */
public class UserInfoBean extends BaseJson{


    /**
     * act : dologin
     * city_name : 东京
     * ctl : user
     * email : dev@quliantrip.com
     * id : 71
     * info : 登录成功
     * is_tmp : 0
     * mobile : 17001288684
     * return : 1
     * sess_id : qhukm9ima3ekqli379pm0iuaj5
     * status : 1
     * user_name : fanwe
     * user_pwd : 6714ccb93be0fda4e51f206b91b46358
     */

    private String act;
    private String city_name;
    private String ctl;
    private String email;
    private String id;
    private String info;
    private String is_tmp;
    private String mobile;
    @SerializedName("return")
    private int returnX;
    private String sess_id;
    private int status;
    private String user_name;
    private String user_pwd;

    public void setAct(String act) {
        this.act = act;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setCtl(String ctl) {
        this.ctl = ctl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setIs_tmp(String is_tmp) {
        this.is_tmp = is_tmp;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setReturnX(int returnX) {
        this.returnX = returnX;
    }

    public void setSess_id(String sess_id) {
        this.sess_id = sess_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getAct() {
        return act;
    }

    public String getCity_name() {
        return city_name;
    }

    public String getCtl() {
        return ctl;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public String getIs_tmp() {
        return is_tmp;
    }

    public String getMobile() {
        return mobile;
    }

    public int getReturnX() {
        return returnX;
    }

    public String getSess_id() {
        return sess_id;
    }

    public int getStatus() {
        return status;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }
}
