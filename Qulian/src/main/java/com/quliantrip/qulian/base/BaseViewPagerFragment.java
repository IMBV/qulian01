package com.quliantrip.qulian.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.adapter.ViewPageFragmentAdapter;
import com.quliantrip.qulian.lib.PagerSlidingTabStrip;
import com.quliantrip.qulian.ui.widget.EmptyLayout;

/**
 * 带有导航条的基类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月6日 下午4:59:50
 *
 * 
 */
/*public class NewsViewPagerFragment extends BaseViewPagerFragment {

    // 重写了父类的 设置Tab选项及内容 方法, 根据当前页面的需求,
    // 通过ViewPageFragmentAdapter执行添加Tab操作, 添加一个Tab, 导航条就多一个选项, 点击就可以跳转到指定Fragment
    @Override
    protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
        String[] title = getResources().getStringArray(
                R.array.news_viewpage_arrays);

        // 参数介绍: (此处的添加条目的方式完全可以由自己决定, 以修改,拓展,更新方便为准)
        // title[0] 导航条的标题
        // "news" 普通的标签字符串, 这里没什么作用
        // NewsFragment.class 当前Tab对应的Fragment内容
        // getBundle(NewsList.CATALOG_ALL) : 通过getBundle方法构建一个Bundle对象, 用于传输给新打开的Fragment
        //NewsList.CATALOG_ALL 表示在新界面里需要加载的是[资讯]数据, 因为打开的都是NewsFragment对象, 只是数据不同
        //NewsList.CATALOG_WEEK 表示在新界面里需要加载的是[热点]数据, 因为打开的都是NewsFragment对象, 只是数据不同
        // 作用类似于打开新的Activity时, intent.putExtra设置参数, 在新界面通过getIntent获取参数.

        // 资讯
        adapter.addTab(title[0], "news", NewsFragment.class,
                getBundle(NewsList.CATALOG_ALL));
        // 热点
        adapter.addTab(title[1], "news_week", NewsFragment.class,
                getBundle(NewsList.CATALOG_WEEK));
        // 博客
        adapter.addTab(title[2], "latest_blog", DefaultFragment.class,
                getBundle(BlogList.CATALOG_LATEST));
        // 推荐
        adapter.addTab(title[3], "recommend_blog", DefaultFragment.class,
                getBundle(BlogList.CATALOG_RECOMMEND));

    }

    @Override
    protected void setScreenPageLimit() {
        mViewPager.setOffscreenPageLimit(3);
    }
    private Bundle getBundle(int newType) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, newType);
        bundle.putString("key", "我是综合里的: " + newType);
        return bundle;
    }

    *//**
     * 基类会根据不同的catalog展示相应的数据
     *
     *            要显示的数据类别
     * @return
     *//*
    private Bundle getBundle(String catalog) {
        Bundle bundle = new Bundle();
//        bundle.putString(BlogFragment.BUNDLE_BLOG_TYPE, catalog);
        bundle.putString("key", "我是综合里的: " + catalog);
        return bundle;
    }

}*/
public abstract class BaseViewPagerFragment extends Fragment {

    protected PagerSlidingTabStrip mTabStrip; // ViewPager顶部的导航条
    protected ViewPager mViewPager; // 展示内容用的滚动布局ViewPager
    protected ViewPageFragmentAdapter mTabsAdapter; // 封装了数据集合的ViewPager适配器
    protected EmptyLayout mErrorLayout; // 布局加载异常时, 显示的空布局.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	// 填充并返回一个公共的包含导航条和ViewPager的界面
        return inflater.inflate(R.layout.base_viewpage_fragment, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	// 导航条, 可以跟随ViewPapger左右滑动.可以设置自定义的导航条内容
        mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.pager_tabstrip);
        
        // 可以滑动的ViewPager
        mViewPager = (ViewPager) view.findViewById(R.id.pager);

        // 空布局
        mErrorLayout = (EmptyLayout) view.findViewById(R.id.error_layout);

        // 封装adapter, 注意这里是继承的FragmentStatePagerAdapter, 并且传入的是getChildFragmentManager()
        // 此处封装了PagerSlidingTabStrip, ViewPager, 在Adapter内部进行一系列的初始化.
        mTabsAdapter = new ViewPageFragmentAdapter(getChildFragmentManager(), mTabStrip, mViewPager);
        
        // 设置ViewPager左右两边保留页面的个数, 这里为空实现, 子类可以重写此方法进行设置
        setScreenPageLimit();
        
        // 通过ViewPageFragmentAdapter设置Tab选项及内容, 抽象方法, 由子类重写进行实现.
        onSetupTabAdapter(mTabsAdapter);

    }

    protected void setScreenPageLimit() {
    }
    
    protected abstract void onSetupTabAdapter(ViewPageFragmentAdapter adapter);

}