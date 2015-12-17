package com.quliantrip.qulian.ui.fragment.backSimpleFragment;

import android.content.Intent;
import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.ui.activity.SimpleBackActivity;
import com.quliantrip.qulian.ui.activity.mainAcivity.MainActivity;
import com.quliantrip.qulian.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yuly on 2015/12/15.
 * www.quliantrip.com
 */
public class CityChooseFragment extends BasePageCheckFragment {

    @Override
    protected View getSuccessView() {
        View view = View.inflate(mContext, R.layout.fragment_city_choose, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected QuestBean requestData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctl", "init");
        map.put("act", "index");
        map.put("r_type", "1");
        return new QuestBean(map, new HomeBean().setTag(getClass().getName()), HttpConstants.CITY_CHOOSE_ADDR);
    }

    @Override
    public void onEventMainThread(BaseJson bean) {

    }

    @OnClick(R.id.bt_choose_finish)void finishChoose() {
        Intent intent = new Intent(mContext, MainActivity.class);
        ((SimpleBackActivity)mContext).setResult(((SimpleBackActivity)mContext).RESULT_OK, intent);
        ((SimpleBackActivity)mContext).finish();
    }
}
