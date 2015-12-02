package com.quliantrip.qulian.ui.fragment.mainFragment;


import android.view.View;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.view.HorizontalScroll.HorizontalScrollViewAdapter;
import com.quliantrip.qulian.view.HorizontalScroll.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuly on 2015/11/9.
 */


public class LanguageFragment extends BaseFragment {
    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;

    private List<String> mDatas = new ArrayList<String>();

    @Override
    public View initView() {
        View view = View.inflate(mContext,R.layout.fragment_main_language, null);

        mHorizontalScrollView = (MyHorizontalScrollView) view.findViewById(R.id.id_horizontalScrollView);
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_01.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_02.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_03.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_04.png");
        mDatas.add("http://www.quliantrip.com/wap/Tpl/main/fanwe/images/wap_bk_05.png");
        mAdapter = new HorizontalScrollViewAdapter(mContext, mDatas);
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
                ToastUtil.showToast(mContext,"我被点击了。。。");
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);
        return view;
    }

    @Override
    public void initDate() {

    }

}
