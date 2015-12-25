//package com.quliantrip.qulian.base;
//
//import android.os.Bundle;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AbsListView;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListView;
//
//import com.quliantrip.qulian.R;
//import com.quliantrip.qulian.domain.BaseJson;
//import com.quliantrip.qulian.domain.ListEntity;
//
//import java.io.InputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
///**
// * 包含ListView列表的Fragment基类
// * <p/>
// * 实现接口: 刷新监听, 条目点击监听, ListView滚动监听
// * <p/>
// * 实现功能:
// * 1. 从网络或本地缓存获取到的 数据的解析 (得到数据对象集合)
// * 2. 给ListView设置数据适配器. 数据适配器 通过抽象方法getListAdapter()由子类实现创建Adapter.
// * 3. 下拉刷新, 上拉加载更多功能的ListView
// *
// * @param <T>
// */
//public abstract class BaseListFragment<T extends BaseJson> extends BaseFragment implements
//        SwipeRefreshLayout.OnRefreshListener,
//        OnItemClickListener,
//        OnScrollListener {
//    public static final int STATE_NONE = 0;
//    public static final int STATE_REFRESH = 1;
//    public static final int STATE_LOADMORE = 2;
//    public static final int STATE_NOMORE = 3;
//    public static final int STATE_PRESSNONE = 4;// 正在下拉但还没有到刷新的状态
//
//
//
//    public static int mState = STATE_NONE;
//    protected LayoutInflater mInflater;
//
//
//    public static final String BUNDLE_KEY_CATALOG = "BUNDLE_KEY_CATALOG";
//
//    @Bind(R.id.swiperefreshlayout)
//    protected SwipeRefreshLayout mSwipeRefreshLayout;
//
//    @Bind(R.id.listview)
//    protected ListView mListView;
//
//    protected ListBaseAdapter<T> mAdapter;
//
//    protected int mCurrentPage = 0;
//
//    protected int mCatalog = 1;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        mInflater = inflater;
//        View view = inflater.inflate(R.layout.fragment_pull_refresh_listview, container, false);
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(this, view);
//        initView(view);
//    }
//
//    @Override
//    public void onCreate(android.os.Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Bundle args = getArguments();
//        if (args != null) {
//            mCatalog = args.getInt(BUNDLE_KEY_CATALOG, 0);
//        }
//    }
//
//    public void initView(View view) {
//
//        mSwipeRefreshLayout.setOnRefreshListener(this);
//        mSwipeRefreshLayout.setColorSchemeResources(
//                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
//                R.color.swiperefresh_color3, R.color.swiperefresh_color4);
//
//        mListView.setOnItemClickListener(this);
//        mListView.setOnScrollListener(this);
//
//        if (mAdapter != null) {
//            mListView.setAdapter(mAdapter);
//        } else {
//            mAdapter = getListAdapter();
//            mListView.setAdapter(mAdapter);
//
//            if (requestDataIfViewCreated()) {
//                mState = STATE_NONE;
//                requestData(false);
//            } else {
//            }
//        }
//    }
//
//    protected abstract ListBaseAdapter<T> getListAdapter();
//
//    // 下拉刷新数据
//    @Override
//    public void onRefresh() {
//        if (mState == STATE_REFRESH) {
//            return;
//        }
//        // 设置顶部正在刷新
//        mListView.setSelection(0);
//        setSwipeRefreshLoadingState();
//        mCurrentPage = 0;
//        mState = STATE_REFRESH;
//        requestData(true);
//    }
//
//    protected boolean requestDataIfViewCreated() {
//        return true;
//    }
//
//    protected String getCacheKeyPrefix() {
//        return null;
//    }
//
//    protected ListEntity<T> parseList(InputStream is) throws Exception {
//        return null;
//    }
//
//    protected ListEntity<T> readList(Serializable seri) {
//        return null;
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//    }
//
//    private String getCacheKey() {
//        return new StringBuilder(getCacheKeyPrefix()).append("_")
//                .append(mCurrentPage).toString();
//    }
//
//
//    protected void executeOnLoadDataSuccess(List<T> data) {
//        if (data == null) {
//            data = new ArrayList<T>();
//        }
//
//        if (mResult != null && !mResult.OK()) {
//            AppContext.showToast(mResult.getErrorMessage());
//            // 注销登陆，密码已经修改，cookie，失效了
//            AppContext.getInstance().Logout();
//        }
//
//        if (mCurrentPage == 0) {
//            mAdapter.clear();
//        }
//
//        // 去掉重复数据
//        for (int i = 0; i < data.size(); i++) {
//            if (compareTo(mAdapter.getData(), data.get(i))) {
//                data.remove(i);
//                i--;
//            }
//        }
//        int adapterState = ListBaseAdapter.STATE_EMPTY_ITEM;
//        if ((mAdapter.getCount() + data.size()) == 0) {
//            adapterState = ListBaseAdapter.STATE_EMPTY_ITEM;
//        } else if (data.size() == 0
//                || (data.size() < getPageSize() && mCurrentPage == 0)) {
//            adapterState = ListBaseAdapter.STATE_NO_MORE;
//            mAdapter.notifyDataSetChanged();
//        } else {
//            adapterState = ListBaseAdapter.STATE_LOAD_MORE;
//        }
//        mAdapter.setState(adapterState);
//        mAdapter.addData(data);
//        // 判断等于是因为最后有一项是listview的状态
//        if (mAdapter.getCount() == 1) {
//
//            if (needShowEmptyNoData()) {
//                mErrorLayout.setErrorType(EmptyLayout.NODATA);
//            } else {
//                mAdapter.setState(ListBaseAdapter.STATE_EMPTY_ITEM);
//                mAdapter.notifyDataSetChanged();
//            }
//        }
//    }
//    protected void executeOnLoadDataError(String error) {
//        if (mCurrentPage == 0) {
//            mErrorLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
//        } else {
//            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
//            mAdapter.setState(ListBaseAdapter.STATE_NETWORK_ERROR);
//            mAdapter.notifyDataSetChanged();
//        }
//    }
//
//    /***
//     * 获取列表数据
//     */
//    protected void requestData(boolean refresh) {
//        String key = getCacheKey();
//        sendRequestData();
//    }
//
//
//    protected void sendRequestData() {
//    }
//
//
//    protected void onRefreshNetworkSuccess() {
//    }
//
//    // 完成刷新
//    protected void executeOnLoadFinish() {
//        setSwipeRefreshLoadedState();
//        mState = STATE_NONE;
//    }
//
//    /**
//     * 设置顶部正在加载的状态
//     */
//    private void setSwipeRefreshLoadingState() {
//        if (mSwipeRefreshLayout != null) {
//            mSwipeRefreshLayout.setRefreshing(true);
//            // 防止多次重复刷新
//            mSwipeRefreshLayout.setEnabled(false);
//        }
//    }
//
//    /**
//     * 设置顶部加载完毕的状态
//     */
//    private void setSwipeRefreshLoadedState() {
//        if (mSwipeRefreshLayout != null) {
//            mSwipeRefreshLayout.setRefreshing(false);
//            mSwipeRefreshLayout.setEnabled(true);
//        }
//    }
//
//    @Override
//    public void onScrollStateChanged(AbsListView view, int scrollState) {
//        if (mAdapter == null || mAdapter.getCount() == 0) {
//            return;
//        }
//        // 数据已经全部加载，或数据为空时，或正在加载，不处理滚动事件
//        if (mState == STATE_LOADMORE || mState == STATE_REFRESH) {
//            return;
//        }
//        // 判断是否滚动到底部
//        boolean scrollEnd = false;
//        try {
//            if (view.getPositionForView(mAdapter.getFooterView()) == view
//                    .getLastVisiblePosition())
//                scrollEnd = true;
//        } catch (Exception e) {
//            scrollEnd = false;
//        }
//
//        if (mState == STATE_NONE && scrollEnd) {
//            if (mAdapter.getState() == ListBaseAdapter.STATE_LOAD_MORE
//                    || mAdapter.getState() == ListBaseAdapter.STATE_NETWORK_ERROR) {
//                mCurrentPage++;
//                mState = STATE_LOADMORE;
//                requestData(false);
//                mAdapter.setFooterViewLoading();
//            }
//        }
//    }
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem,
//                         int visibleItemCount, int totalItemCount) {
//        // 数据已经全部加载，或数据为空时，或正在加载，不处理滚动事件
//    }
//}
