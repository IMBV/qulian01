package com.quliantrip.qulian.ui.showFragment;

import android.view.View;
import android.widget.Toast;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;

/**
 * Created by yuly on 2015/11/9.
 */


public class MyFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_me, null);
        return view;
    }

    @Override
    public void initDate() {

    }
    public void testheight(View v){
        Toast.makeText(mContext,getStatusBarHeight()+"",Toast.LENGTH_SHORT).show();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
