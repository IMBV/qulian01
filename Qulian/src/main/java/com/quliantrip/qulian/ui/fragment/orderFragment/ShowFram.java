package com.quliantrip.qulian.ui.fragment.orderFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.quliantrip.qulian.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yuly on 2015/12/16.
 * www.quliantrip.com
 */
public class ShowFram extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener,
        AbsListView.OnScrollListener {
    protected Context mContext;

    @Bind(R.id.swiperefreshlayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.listview)
    protected ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (Context) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(mContext, R.layout.fragment_pull_refresh_listview,null);
        ButterKnife.bind(this,view);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);
        mListView.setOnItemClickListener(this);
        mListView.setOnScrollListener(this);
//        //这里是比较乱的代码暂时不能是使用
//        if (mAdapter != null) {
//            mListView.setAdapter(mAdapter);
//            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
//        } else {
//            mAdapter = getListAdapter();
//            mListView.setAdapter(mAdapter);
//
//            if (requestDataIfViewCreated()) {
//                mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
//                mState = STATE_NONE;
//                requestData(false);
//            } else {
//                mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
//            }
//
//        }
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onRefresh() {
        // 设置顶部正在刷新
        mListView.setSelection(0);
        setSwipeRefreshLoadingState();
//        mCurrentPage = 0;
//        mState = STATE_REFRESH;
//        requestData(true);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //在这里最后一条时进行相应的操作



    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
    /** 设置顶部正在加载的状态 */
    private void setSwipeRefreshLoadingState() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(true);
            // 防止多次重复刷新
            mSwipeRefreshLayout.setEnabled(false);
        }
    }

    /** 设置顶部加载完毕的状态 */
    private void setSwipeRefreshLoadedState() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
            mSwipeRefreshLayout.setEnabled(true);
        }
    }
}
