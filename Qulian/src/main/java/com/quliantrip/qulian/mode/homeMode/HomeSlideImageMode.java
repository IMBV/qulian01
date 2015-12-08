package com.quliantrip.qulian.mode.homeMode;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.mode.BaseMode;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.view.RollViewPage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuly on 2015/12/2.
 */


/**
 * 使用 ：在oncreate中进行返回view,通过addView(mode.getModeView(），
 * 请求数据后进行加载mode.setData(),来加载数据
 */
public class HomeSlideImageMode extends BaseMode<HomePageBean> {

    private View view;
    private RollViewPage rollViewPage;
    @Bind(R.id.top_news_viewpager)
    LinearLayout top_news_viewpager;//轮播的viewpage
    @Bind(R.id.dots_ll)
    LinearLayout dots_ll;//下面的小点

    //添加图片和小点的集合
    private List<String> imageList = new ArrayList<String>();
    private List<View> dotList = new ArrayList<View>();

    public HomeSlideImageMode() {
        view = View.inflate(QulianApplication.getContext(), R.layout.mode_home_slideimage, null);
    }

    @Override
    public View getModelView() {
        ButterKnife.bind(this, view);
        return view;
    }

    //在这里进行数据的添加,o表示传如的类，进行空间的加载布局
    @Override
    public void setData(HomePageBean homePageBean) {
        initRollView(homePageBean);
    }

    private void initRollView(HomePageBean homePageBean) {

        imageList.clear();
        dotList.clear();
        imageList.addAll(homePageBean.getName());
        if (imageList.size() > 0) {
            //初始化小点
            initDoc();
            //添加之定义的viewPage带有滚动效果的
            rollViewPage = new RollViewPage(QulianApplication.getContext(), imageList, dotList);
            rollViewPage.roll();
            rollViewPage.setCurrentItem(imageList.size()*50);
            rollViewPage.setOnTouchImage(new RollViewPage.OnTouchImage() {

                @Override
                public void touchImage(String url) {
                    //这里是进行点击图片是的操作
                }
            });
            top_news_viewpager.removeAllViews();
            top_news_viewpager.addView(rollViewPage);
        }
    }

    //初始化小点的个数
    private void initDoc() {
        dots_ll.removeAllViews();
        dotList.clear();
        for (int i = 0; i < imageList.size(); i++) {
            View view = new View(QulianApplication.getContext());
            if (i == 0) {
                view.setBackgroundResource(R.drawable.shape_point_red);
            } else {
                view.setBackgroundResource(R.drawable.shape_point_gray);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(CommonHelp.dip2px(QulianApplication.getContext(), 5), CommonHelp.dip2px(QulianApplication.getContext(), 5));
            params.setMargins(CommonHelp.dip2px(QulianApplication.getContext(), 5), 0, 0, 0);
            dots_ll.addView(view, params);
            dotList.add(view);
        }
    }

    public void restarteRoll(){
        if(rollViewPage != null){
            rollViewPage.roll();
        }
    }
}
