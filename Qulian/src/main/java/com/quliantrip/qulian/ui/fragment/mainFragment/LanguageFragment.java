package com.quliantrip.qulian.ui.fragment.mainFragment;


import android.view.View;
import android.widget.TextView;

import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.net.volleyManage.QuestBean;

/**
 * Created by yuly on 2015/11/9.
 */


public class LanguageFragment extends BasePageCheckFragment {


    @Override
    protected View getSuccessView() {
        TextView textView = new TextView(mContext);
        textView.setText("语音");
        return textView;
    }

    @Override
    protected QuestBean requestData() {
        return new QuestBean(null, new HomePageBean().setTag(getClass().getName()), "http://192.168.0.193:8080/01.jsp");
    }

    @Override
    public void onEventMainThread(BaseJson bean) {

    }

}
