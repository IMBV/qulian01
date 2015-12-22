package com.quliantrip.qulian.global;


import com.quliantrip.qulian.R;
import com.quliantrip.qulian.ui.fragment.backSimpleFragment.CityChooseFragment;
import com.quliantrip.qulian.ui.fragment.backSimpleFragment.LoginFragment;
import com.quliantrip.qulian.ui.fragment.backSimpleFragment.MySetting;
import com.quliantrip.qulian.ui.fragment.backSimpleFragment.OrderFragment;

public enum SimpleBackPage {
    MY_ACTIVE(1, R.string.actionbar_title_active, LoginFragment.class),
    MY_SETTING(2,R.string.actionbar_title_setting,MySetting.class),
    CITY_CHOOSE(3,R.string.actionbar_city_choose, CityChooseFragment.class),
    ORDER_LIST(4,R.string.actionbar_order_list, OrderFragment.class);

    private int title;
    private Class<?> clz;
    private int value;

    private SimpleBackPage(int value, int title, Class<?> clz) {
        this.value = value;
        this.title = title;
        this.clz = clz;
    }



    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static SimpleBackPage getPageByValue(int val) {
        for (SimpleBackPage p : values()) {
            if (p.getValue() == val)
                return p;
        }
        return null;
    }
}
