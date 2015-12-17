package com.quliantrip.qulian.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.ui.fragment.findFragment.FragmentFindFactory;
import com.quliantrip.qulian.ui.fragment.orderFragment.FragmentOrderFactory;
import com.quliantrip.qulian.util.CommonHelp;

public class MyOrderAdapter extends FragmentPagerAdapter {
    private String[] tagNames;// 从string的获取数组的集合

    public MyOrderAdapter(FragmentManager fm) {
        super(fm);
        tagNames = CommonHelp.getStringArray(R.array.order_tab_names);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tagNames[position];
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentOrderFactory.create(position);
    }

    @Override
    public int getCount() {
        return tagNames.length;
    }

}
