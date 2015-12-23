package com.quliantrip.qulian.mode.homeMode;

import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.HomeBean;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.mode.BaseMode;
import com.quliantrip.qulian.ui.activity.mainAcivity.MainActivity;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.HorizontalScroll.HorizontalScrollViewAdapter;
import com.quliantrip.qulian.view.HorizontalScroll.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页的功能导航的模块
 * Created by Yuly on 2015/12/4.
 * www.quliantrip.com
 */
public class HomeFunctionMode extends BaseMode<List<HomeBean.IndexsEntity>> {

    @Bind(R.id.id_horizontalScrollView)
    MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private View view;

    //添加图片和小点的集合
    private List<String> imageList = new ArrayList<String>();
    private List<View> dotList = new ArrayList<View>();

    private MainActivity mMainActivity;

    public HomeFunctionMode(MainActivity activity) {
        view = View.inflate(QulianApplication.getContext(), R.layout.mode_home_function, null);
        this.mMainActivity = activity;
    }

    @Override
    public View getModelView() {
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setData(final List<HomeBean.IndexsEntity> list) {
        mAdapter = new HorizontalScrollViewAdapter(QulianApplication.getContext(), list);
//        //添加滚动回调
//        mHorizontalScrollView
//                .setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener()
//                {
//                    @Override
//                    public void onCurrentImgChanged(int position,
//                                                    View viewIndicator)
//                    {
////                        ToastUtil.showToast("我被点击了。。。");
//                    }
//                });
        //添加点击回调
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                if (mMainActivity == null) {
                    ToastUtil.showToast(QulianApplication.getContext(), list.get(position).getName());
                } else {
                    //这里可以通过适配的类获取数据的名称和筛选的id
                    mMainActivity.changeChoicenessContion("玩乐", "8");//这里可以进行切换
                }
            }
        });
        mHorizontalScrollView.initDatas(mAdapter);
    }

}