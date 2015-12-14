package com.quliantrip.qulian.mode.homeMode;

import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.mode.BaseMode;

import butterknife.ButterKnife;

/**
 * 首页商店信息的模块
 * Created by Yuly on 2015/12/11.
 * www.quliantrip.com
 */
public class HomeChoicenessMode extends BaseMode {
    private View view;

    public HomeChoicenessMode() {
        view = View.inflate(QulianApplication.getContext(), R.layout.mode_home_choiceness, null);
    }

    @Override
    public View getModelView() {
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setData(Object o) {

    }
}
