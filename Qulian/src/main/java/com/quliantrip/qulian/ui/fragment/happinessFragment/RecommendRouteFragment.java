package com.quliantrip.qulian.ui.fragment.happinessFragment;

import android.view.View;

import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.net.volleyManage.QuestBean;

/**
 * Created by Yuly on 2015/12/7.
 * www.quliantrip.com
 */
public class RecommendRouteFragment extends BasePageCheckFragment {
    private static RecommendRouteFragment recommendRouteFragment = new RecommendRouteFragment();
    private QuestBean questBean;

    public static RecommendRouteFragment getRecommendRouteFragment(QuestBean questBean) {
        return recommendRouteFragment;
    }

    @Override
    protected View getSuccessView() {
        return null;
    }

    @Override
    protected QuestBean requestData() {
        return null;
    }

    @Override
    public void onEventMainThread(BaseJson bean) {

    }
}
