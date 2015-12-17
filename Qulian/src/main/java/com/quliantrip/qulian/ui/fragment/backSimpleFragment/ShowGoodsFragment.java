package com.quliantrip.qulian.ui.fragment.backSimpleFragment;

import android.media.MediaCodec;
import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.QuestBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/15.
 * www.quliantrip.com
 */
public class ShowGoodsFragment extends BasePageCheckFragment {
    @Override
    protected View getSuccessView() {
        View view = View.inflate(mContext, R.layout.fragment_show_goods,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected QuestBean requestData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctl", "index");
        map.put("act", "index");
        map.put("r_type", "1");
        return new QuestBean(map, new HomeBean().setTag(getClass().getName()), HttpConstants.HOST_ADDR_ROOT_Test);

    }

    @Override
    public void onEventMainThread(BaseJson bean) {

    }
}
