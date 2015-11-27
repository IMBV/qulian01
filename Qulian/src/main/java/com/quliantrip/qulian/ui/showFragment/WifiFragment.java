package com.quliantrip.qulian.ui.showFragment;


import android.view.View;
import android.widget.TextView;

import com.quliantrip.qulian.base.BaseFragment;

/**
 * Created by yuly on 2015/11/9.
 */


public class WifiFragment extends BaseFragment {

    @Override
    public View initView() {
        TextView textview = new TextView(mContext);
        textview.setText("wifi");
        return textview;
    }

    @Override
    public void initDate() {
        System.out.println("wifi数据加载了。。。");
    }

}
