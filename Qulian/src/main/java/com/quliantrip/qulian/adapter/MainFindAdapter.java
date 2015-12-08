package com.quliantrip.qulian.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.ui.fragment.findFragment.FragmentFactory;
import com.quliantrip.qulian.util.CommonHelp;

public class MainFindAdapter extends FragmentPagerAdapter {
    private String[] tagNames;// 从string的获取数组的集合

    public MainFindAdapter(FragmentManager fm) {
        super(fm);
        tagNames = CommonHelp.getStringArray(R.array.find_tab_names);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tagNames[position];
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.create(position);
    }

    @Override
    public int getCount() {
        return tagNames.length;
    }

}
