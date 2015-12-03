package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.mode.HomeSlideImageMode;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.EvaluateUtil;
import com.quliantrip.qulian.view.ObservableScroll.ObservableScrollView;
import com.quliantrip.qulian.view.ObservableScroll.ScrollViewListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuly on 2015/11/9.
 */

public class HomeFragment extends BasePageCheckFragment implements ScrollViewListener {
    @Bind(R.id.iv_home_title_back)
    ImageView titleBackgroud;//标题的背景
    @Bind(R.id.sv_scroll)
    ObservableScrollView scroll;
    @Bind(R.id.ll_model_container)
    LinearLayout modelContainer;

    //定义的model
    private HomeSlideImageMode homeSlideImageMode;


    private HomePageBean aahomePageBean;

    @Override
    protected View getSuccessView() {
        View view = View.inflate(mContext, R.layout.fragment_main_home, null);
        ButterKnife.bind(this, view);
        ViewHelper.setAlpha(titleBackgroud, 0.0f);
        scroll.setScrollViewListener(this);
        initModel();
        return view;
    }

    //添加model到linearlayout中
    private void initModel() {
        homeSlideImageMode = new HomeSlideImageMode();
        modelContainer.addView(homeSlideImageMode.getModelView());

    }

    //在这里可以进行空间内容的初始化
    public void onEventMainThread(HomePageBean homePageBean) {
        if (homePageBean != null && this.getClass().getName().equals(homePageBean.getTag())) {
            homeSlideImageMode.setData(homePageBean);
        }
    }

    @Override
    protected QuestBean requestData() {
        return new QuestBean(null, new HomePageBean().setTag(getClass().getName()), "http://192.168.0.193:8080/01.jsp");
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        float percent = (float) y / (float) CommonHelp.dip2px(mContext, 550);
        ViewHelper.setAlpha(titleBackgroud,
                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
    }

}
