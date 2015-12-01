package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.util.CommonHelp;
import com.quliantrip.qulian.view.RollViewPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuly on 2015/11/9.
 */

public class MyFragment extends BaseFragment {
    private LinearLayout top_news_viewpager;//轮播的viewpage
    private LinearLayout dots_ll;//下面的小点
    private RelativeLayout roll_view;

    //添加图片和小点的集合
    private List<String> imageList = new ArrayList<String>();
    private List<View> dotList = new ArrayList<View>();

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_me, null);
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_container);

        roll_view = (RelativeLayout) View.inflate(mContext,
                R.layout.view_rool_image, null);
        dots_ll = (LinearLayout) roll_view.findViewById(R.id.dots_ll);
        top_news_viewpager = (LinearLayout) roll_view.findViewById(R.id.top_news_viewpager);

        ll.addView(roll_view);
        initRollView();

        return view;
    }


    @Override
    public void initDate() {

    }

    private void initRollView() {

        imageList.clear();
        dotList.clear();
        //添加小点的数量的和图片的URL获取到的数据一致，
//        int i;
//        for(i=1;i<=3;i++){
//            imageList.add("");
//        }
        imageList.add("http://www.quliantrip.com/public/attachment/201511/20/16/564ed3a64400b.png");
        imageList.add("http://www.quliantrip.com/public/attachment/201511/20/16/564ed3762c8e5.png");
        imageList.add("http://www.quliantrip.com/public/attachment/201511/20/16/564ed327a6642.png");
        if(imageList.size()>0){
            //初始化小点
            initDoc();
            //添加之定义的viewPage带有滚动效果的
            RollViewPage rollViewPage = new RollViewPage(mContext,imageList,dotList);
            rollViewPage.roll();
            rollViewPage.setOnTouchImage(new RollViewPage.OnTouchImage() {

                @Override
                public void touchImage(String url) {
                    //这里是进行点击图片是的操作
                }
            });
            top_news_viewpager.removeAllViews();
            top_news_viewpager.addView(rollViewPage);
        }

        //本布局中有listView的时候要进行简单的判断if (myAdapter == null) {
//        myAdapter = new MyAdapter(newList);
//        lv_item_news.setAdapter(myAdapter);
//    } else {
//        myAdapter.notifyDataSetChanged();
//    }

    }

    //初始化小点的个数
    private void initDoc() {
        dots_ll.removeAllViews();
        dotList.clear();
        for (int i = 0; i < imageList.size(); i++) {
            View view = new View(mContext);
            if (i == 0) {
                view.setBackgroundResource(R.drawable.shape_point_red);
            } else {
                view.setBackgroundResource(R.drawable.shape_point_gray);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(CommonHelp.dip2px(mContext,5), CommonHelp.dip2px(mContext,5));
            params.setMargins(CommonHelp.dip2px(mContext,5), 0, 0, 0);
            dots_ll.addView(view, params);
            dotList.add(view);
        }
    }


}
