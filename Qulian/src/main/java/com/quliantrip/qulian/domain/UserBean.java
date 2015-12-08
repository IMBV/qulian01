package com.quliantrip.qulian.domain;

import java.io.Serializable;

/**
 * Created by Yuly on 2015/12/8.
 * www.quliantrip.com
 */
public class UserBean extends BaseJson implements Serializable {
    private int uId;
    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }
}
