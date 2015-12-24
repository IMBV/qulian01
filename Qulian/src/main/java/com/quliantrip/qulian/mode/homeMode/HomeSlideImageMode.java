package com.quliantrip.qulian.mode.homeMode;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.BaseJson;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.mode.BaseMode;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.RollViewPage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yuly on 2015/12/2.
 */


/**
 * 首页的图片的滑动模块
 */
public class HomeSlideImageMode extends BaseMode<List<HomeBean.AdvsEntity>>{

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
    public void setData(List<HomeBean.AdvsEntity> advs) {
        initRollView(advs);
    }

    private void initRollView(List<HomeBean.AdvsEntity> advs) {

        imageList.clear();
        dotList.clear();
//        for (HomeBean.AdvsEntity adv:advs) {
//            imageList.add(adv.getImg());
//        }
        imageList.add("http://www.quliantrip.com/public/attachment/201511/20/16/564ed3a64400b.png");
        imageList.add("http://www.quliantrip.com/public/attachment/201511/20/16/564ed3762c8e5.png");
        imageList.add("http://www.quliantrip.com/public/attachment/201511/20/16/564ed327a6642.png");
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
//                    ToastUtil.showToast(QulianApplication.getContext(),url);
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

    //重新开始滚动
    public void restarteRoll(){
        if(rollViewPage != null){
            rollViewPage.roll();
        }
    }

}
