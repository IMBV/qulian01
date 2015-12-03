package com.quliantrip.qulian.domain;

import java.io.Serializable;

/**
 * Created by Yuly on 2015/12/2.
 * www.quliantrip.com
 */
public class HomePageBean extends BaseJson implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
