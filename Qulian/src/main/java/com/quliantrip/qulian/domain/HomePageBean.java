package com.quliantrip.qulian.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Yuly on 2015/12/2.
 * www.quliantrip.com
 */
public class HomePageBean extends BaseJson {
    private ArrayList<String> name;

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }
}
