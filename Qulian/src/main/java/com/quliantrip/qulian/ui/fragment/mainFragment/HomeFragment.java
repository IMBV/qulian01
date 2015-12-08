package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.mode.homeMode.HomeFunctionMode;
import com.quliantrip.qulian.mode.homeMode.HomeSlideImageMode;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.scanner.activity.CaptureActivity;
import com.quliantrip.qulian.scanner.activity.OpenWifiActivity;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.EvaluateUtil;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.ObservableScroll.ObservableScrollView;
import com.quliantrip.qulian.view.ObservableScroll.ScrollViewListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    HomeFunctionMode homeFunctionMode;


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
        homeFunctionMode = new HomeFunctionMode();
        modelContainer.addView(homeFunctionMode.getModelView());
    }

    @Override
    protected QuestBean requestData() {
        return new QuestBean(null, new HomePageBean().setTag(getClass().getName()), "http://192.168.0.193:8080/01.jsp");
    }

    @Override
    public void onEventMainThread(BaseJson bean) {
        if (bean != null && this.getClass().getName().equals(bean.getTag())) {
            homeSlideImageMode.setData((HomePageBean) bean);
        }
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        float percent = (float) y / (float) CommonHelp.dip2px(mContext, 550);
        ViewHelper.setAlpha(titleBackgroud,
                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
    }

    //连接wifi
    @OnClick(R.id.iv_home_title_wifi)
    void connectWifi() {
        Intent openCameraIntent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(openCameraIntent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == 0) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            if (scanResult.startsWith("SSID")) {
                data.setClass(mContext, OpenWifiActivity.class);
                startActivity(data);
            } else {
                ToastUtil.showToast(mContext, "请扫描正确的二维码");
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        homeSlideImageMode.restarteRoll();
    }

}
