package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.adapter.HomeRecommendAdapter;
import com.quliantrip.qulian.base.BasePageCheckFragment;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.ChangeCityBean;
import com.quliantrip.qulian.domain.CityListBean;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.mode.homeMode.HomeChoicenessMode;
import com.quliantrip.qulian.mode.homeMode.HomeFunctionMode;
import com.quliantrip.qulian.mode.homeMode.HomeSlideImageMode;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;
import com.quliantrip.qulian.net.volleyManage.QuestBean;
import com.quliantrip.qulian.scanner.activity.CaptureActivity;
import com.quliantrip.qulian.scanner.activity.OpenWifiActivity;
import com.quliantrip.qulian.ui.activity.GoodDetailActivity;
import com.quliantrip.qulian.ui.activity.mainAcivity.MainActivity;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.EvaluateUtil;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.util.UIHelper;
import com.quliantrip.qulian.view.MyListView;
import com.quliantrip.qulian.view.ObservableScroll.ObservableScrollView;
import com.quliantrip.qulian.view.ObservableScroll.ScrollViewListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuly on 2015/11/9.
 */

public class HomeFragment extends BasePageCheckFragment implements ScrollViewListener {
    @Bind(R.id.iv_home_title_location)
    TextView homeTitle;//首页的城市

    @Bind(R.id.iv_home_title_back)
    ImageView titleBackgroud;//标题的背景
    @Bind(R.id.sv_scroll)
    ObservableScrollView scroll;
    @Bind(R.id.ll_model_container)
    LinearLayout modelContainer;
    @Bind(R.id.iv_home_recommend)
    MyListView listView;
    //定义的model
    private HomeSlideImageMode homeSlideImageMode;
    HomeFunctionMode homeFunctionMode;
    HomeChoicenessMode homeChoicenessMode;

    private MainActivity activity ;

    @Override
    protected View getSuccessView() {
        View view = View.inflate(mContext, R.layout.fragment_main_home, null);
        ButterKnife.bind(this, view);
        ViewHelper.setAlpha(titleBackgroud, 0.0f);
        scroll.setScrollViewListener(this);
        activity = (MainActivity) getActivity();
        initModel();
        listView.setFocusable(false);
        return view;
    }


    //添加model到linearlayout中
    private void initModel() {
        homeSlideImageMode = new HomeSlideImageMode();
        modelContainer.addView(homeSlideImageMode.getModelView());
        homeFunctionMode = new HomeFunctionMode(activity);
        modelContainer.addView(homeFunctionMode.getModelView());
        homeFunctionMode.setData(null);
        homeChoicenessMode = new HomeChoicenessMode();
        homeChoicenessMode.setContext(mContext);

    }

    @Override
    protected QuestBean requestData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ctl", "index");
        map.put("act", "app");
        map.put("r_type", "1");
        return new QuestBean(map, new HomeBean().setTag(getClass().getName()), HttpConstants.HOST_ADDR_ROOT_NET);
    }

    @Override
    public void onEventMainThread(BaseJson bean) {
        if (bean != null && HomeFragment.this.getClass().getName().equals(bean.getTag())) {
            //想mode添加数据
            homeSlideImageMode.setData(null);
            //有时有if必须有else的数据的显示
            if (((HomeBean) bean).getQuality_goods() != null) {
                modelContainer.removeView(homeChoicenessMode.getModelView());
                modelContainer.addView(homeChoicenessMode.getModelView());
                homeChoicenessMode.setData(((HomeBean) bean).getQuality_goods());
            }else{
                modelContainer.removeView(homeChoicenessMode.getModelView());
            }
            homeTitle.setText(((HomeBean) bean).getCity_name());
            initListIView(((HomeBean) bean).getDeal_list());
        }
        if (bean != null && (this.getClass().getName()+"changeCity").equals(bean.getTag())) {
            ChangeCityBean beanCity = (ChangeCityBean)bean;
            Map<String, String> map = new HashMap<String, String>();
            map.put("ctl", "index");
            map.put("act", "app");
            map.put("sess_id", beanCity.getSess_id());
            map.put("r_type", "1");
            System.out.println("asdf");
            new PacketStringReQuest(HttpConstants.HOST_ADDR_ROOT_NET, new HomeBean().setTag(HomeFragment.this.getClass().getName()), map, null);
        }
        bean = null;
    }
    private HomeRecommendAdapter homeRecommendAdapter;
    private void initListIView(List<HomeBean.DealListEntity> dealList) {
        if(homeRecommendAdapter == null){
            homeRecommendAdapter = new HomeRecommendAdapter((ArrayList<HomeBean.DealListEntity>) dealList);
        }else{
            homeRecommendAdapter.upDataItem((ArrayList<HomeBean.DealListEntity>) dealList);
        }

        listView.setAdapter(homeRecommendAdapter);
        //条目数据适配
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, GoodDetailActivity.class);
                intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT+"?ctl=deal&data_id="+((HomeBean.DealListEntity) parent.getAdapter().getItem(position)).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        float percent = (float) y / (float) CommonHelp.dip2px(mContext, 550);
        ViewHelper.setAlpha(titleBackgroud,
                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
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
        } else if (requestCode == 1) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("ctl","city");
            map.put("act", "city_change");
            map.put("area_id", data.getStringExtra("cityId"));
            map.put("r_type", "1");
            new PacketStringReQuest(HttpConstants.HOST_ADDR_ROOT_NET, new ChangeCityBean().setTag(HomeFragment.this.getClass().getName()+"changeCity"), map, null);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        homeSlideImageMode.restarteRoll();
    }

    //点击切换城市
    @OnClick(R.id.rl_city_choose)
    void chooseSity() {
        UIHelper.showCityChoose(this, 1);
    }

    //点击加载更多
    @OnClick(R.id.tv_loading_more) void loadMore(){
        activity.changeChoicenessContion("全部分类","0");
    }

    //连接wifi
    @OnClick(R.id.iv_home_title_wifi)
    void connectWifi() {
        Intent openCameraIntent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(openCameraIntent, 0);
    }
}
