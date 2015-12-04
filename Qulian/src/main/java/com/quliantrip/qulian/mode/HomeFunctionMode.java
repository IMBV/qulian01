package com.quliantrip.qulian.mode;

import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.global.QulianApplication;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.HorizontalScroll.HorizontalScrollViewAdapter;
import com.quliantrip.qulian.view.HorizontalScroll.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuly on 2015/12/4.
 * www.quliantrip.com
 */
public class HomeFunctionMode extends BaseMode<HomePageBean> {

    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;

    private List<String> mDatas = new ArrayList<String>();

    @Override
    public View getModelView() {
        View view = View.inflate(QulianApplication.getContext(), R.layout.mode_home_function, null);
        mHorizontalScrollView = (MyHorizontalScrollView) view.findViewById(R.id.id_horizontalScrollView);
        mDatas.clear();
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_01.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_02.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_03.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_04.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_05.png");
        mAdapter = new HorizontalScrollViewAdapter(QulianApplication.getContext(), mDatas);
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
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener()
        {

            @Override
            public void onClick(View view, int position)
            {
                ToastUtil.showToast(QulianApplication.getContext(),"我被点击了。。。");
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);
        return view;
    }

    @Override
    public void setData(HomePageBean homePageBean) {

    }
}
