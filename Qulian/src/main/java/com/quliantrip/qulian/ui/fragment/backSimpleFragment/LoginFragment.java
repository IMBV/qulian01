package com.quliantrip.qulian.ui.fragment.backSimpleFragment;

import android.view.View;
import android.widget.TextView;

import com.quliantrip.qulian.base.BaseFragment;


public class LoginFragment extends BaseFragment {

    @Override
    public View initView() {
        TextView text = new TextView(mContext);
        text.setText("登录");
        return text;
    }

    @Override
    public void initDate() {

    }
}
