package com.quliantrip.qulian.ui.fragment.backSimpleFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.adapter.MyOrderAdapter;
import com.quliantrip.qulian.adapter.ViewPageFragmentAdapter;
import com.quliantrip.qulian.base.BaseViewPagerFragment;
import com.quliantrip.qulian.lib.PagerSlidingTab;
import com.quliantrip.qulian.ui.fragment.orderFragment.ShowFram;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/16.
 * www.quliantrip.com
 */
public class OrderFragment extends BaseViewPagerFragment {
//    @Bind(R.id.pt_me_order)
//    PagerSlidingTab tab;
//    @Bind(R.id.vp_order_container)
//    ViewPager orderVp;
//
//    protected Context mContext;
//    public View view;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mContext = (Context) getActivity();
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_my_order,null);
//        ButterKnife.bind(this,view);
//        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(((FragmentActivity)mContext).getSupportFragmentManager());
//        Bundle bundle = getArguments();
//        getArguments();
//        orderVp.setAdapter(myOrderAdapter);
//        tab.setViewPager(orderVp);
//        orderVp.setCurrentItem(bundle.getInt("orderState"));
//        return view;
//    }

    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[] title = getResources().getStringArray(
                R.array.order_viewpage_arrays);

        // 参数介绍: (此处的添加条目的方式完全可以由自己决定, 以修改,拓展,更新方便为准)
        // title[0] 导航条的标题
        // "news" 普通的标签字符串, 这里没什么作用
        // NewsFragment.class 当前Tab对应的Fragment内容
        // getBundle(NewsList.CATALOG_ALL) : 通过getBundle方法构建一个Bundle对象, 用于传输给新打开的Fragment
        //NewsList.CATALOG_ALL 表示在新界面里需要加载的是[资讯]数据, 因为打开的都是NewsFragment对象, 只是数据不同
        //NewsList.CATALOG_WEEK 表示在新界面里需要加载的是[热点]数据, 因为打开的都是NewsFragment对象, 只是数据不同
        // 作用类似于打开新的Activity时, intent.putExtra设置参数, 在新界面通过getIntent获取参数.

        // 资讯
        adapter.addTab(title[0], "news", ShowFram.class,
                getBundle());
        // 热点
        adapter.addTab(title[1], "news_week", ShowFram.class,
                getBundle());
        // 博客
        adapter.addTab(title[2], "latest_blog", ShowFram.class,
                getBundle());
        // 推荐
        adapter.addTab(title[3], "recommend_blog", ShowFram.class,
                getBundle());
        mViewPager.setCurrentItem(getArguments().getInt("orderState"));
    }
    @Override
    protected void setScreenPageLimit() {
        mViewPager.setOffscreenPageLimit(3);
    }
    private Bundle getBundle() {
        Bundle bundle = new Bundle();
//        bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, newType);
        bundle.putString("key", "测试 " );
        return bundle;
    }

}
