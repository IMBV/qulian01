package com.quliantrip.qulian.ui.fragment.backSimpleFragment;

import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/14.
 * www.quliantrip.com
 */
public class MySetting extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_my_setting,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initDate() {

    }
}
