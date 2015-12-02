package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.net.volleyManage.PacketStringReQuest;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.EvaluateUtil;
import com.quliantrip.qulian.view.ObservableScroll.ObservableScrollView;
import com.quliantrip.qulian.view.ObservableScroll.ScrollViewListener;

/**
 * Created by yuly on 2015/11/9.
 */


public class HomeFragment extends BaseFragment implements ScrollViewListener {
    private RelativeLayout homeTitle;
    private ImageView titleBackgroud;
    @Override
    public View initView() {
        View view = View.inflate(mContext,R.layout.fragment_main_home, null);
        homeTitle = (RelativeLayout) view.findViewById(R.id.ll_home_title);
        titleBackgroud = (ImageView)view.findViewById(R.id.iv_home_title_back);
        ViewHelper.setAlpha(titleBackgroud,0.0f);
//        ViewHelper.setAlpha(homeTitle,0.5f);
        ((ObservableScrollView)view.findViewById(R.id.sv_scroll)).setScrollViewListener(this);
        return view;
    }

    @Override
    public void initDate() {

    }
    public void loadHeadBuy() {
        PacketStringReQuest quest = new PacketStringReQuest(HttpConstants.HOST_ADDR_ROOT,
                new FlashBuyMessage().setTag(getClass().getName()));
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        float percent = (float)y/(float)CommonHelp.dip2px(mContext,250);
        ViewHelper.setAlpha(titleBackgroud,
                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));

    }
}
