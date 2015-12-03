package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.EvaluateUtil;
import com.quliantrip.qulian.view.ObservableScroll.ObservableScrollView;
import com.quliantrip.qulian.view.ObservableScroll.ScrollViewListener;

import de.greenrobot.event.EventBus;

/**
 * Created by yuly on 2015/11/9.
 */

public class HomeFragment extends BaseFragment implements ScrollViewListener {
    private RelativeLayout homeTitle;
    private ImageView titleBackgroud;
    @Override
    public View initView() {
        View view = View.inflate(mContext,R.layout.fragment_main_home, null);
//        EventBus.getDefault().register(this);
        homeTitle = (RelativeLayout) view.findViewById(R.id.ll_home_title);
        titleBackgroud = (ImageView)view.findViewById(R.id.iv_home_title_back);
        ViewHelper.setAlpha(titleBackgroud,0.0f);
        ((ObservableScrollView)view.findViewById(R.id.sv_scroll)).setScrollViewListener(this);
        return view;
    }

    @Override
    public void initDate() {
        String homeFragmentJson = CommonHelp.getStringSp(mContext,"homeFragmentJson","");//保存时进行首页数据的判断
        if(!TextUtils.isEmpty(homeFragmentJson)){

        }
//        loadHeadBuy();
    }


//    public void loadHeadBuy() {
//        PacketStringReQuest quest = new PacketStringReQuest("",
//                new HomePageBean().setTag(getClass().getName()));
//    }


//    public void onEventMainThread(HomePageBean homePageBean) {
//        if (homePageBean != null
//                && this.getClass().getName().equals(homePageBean.getTag())) {
//            //这里进行空间数据的添加
//        }
//
//    }
    //把数据对象添加到布局中
    private void initView(HomePageBean homePageBean){

    }



    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        float percent = (float)y/(float)CommonHelp.dip2px(mContext,550);
        ViewHelper.setAlpha(titleBackgroud,
                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
    }

}
