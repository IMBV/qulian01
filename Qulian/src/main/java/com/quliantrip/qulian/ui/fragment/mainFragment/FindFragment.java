package com.quliantrip.qulian.ui.fragment.mainFragment;


import android.view.View;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.net.volleyManage.QuestBean;

import butterknife.ButterKnife;

/**
 * Created by yuly on 2015/11/9.
 */


public class FindFragment extends BasePageCheckFragment {


    @Override
    protected View getSuccessView() {
        View view =  View .inflate(mContext, R.layout.fragment_main_find,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected QuestBean requestData() {
        return new QuestBean(null, new HomePageBean().setTag(getClass().getName()), "http://192.168.0.191:8080/01.jsp");
    }

    @Override
    public void onEventMainThread(BaseJson bean) {

    }

}
