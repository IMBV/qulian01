package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.UIHelper;
import com.quliantrip.qulian.view.RollViewPage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuly on 2015/11/9.
 */

public class MyFragment extends BaseFragment {
    @Bind(R.id.tv_me_setting)
    Button setting;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_me, null);
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void initDate() {

    }
    @OnClick(R.id.tv_me_setting) void setting(){
        UIHelper.showMyActive(mContext);
    }
}
