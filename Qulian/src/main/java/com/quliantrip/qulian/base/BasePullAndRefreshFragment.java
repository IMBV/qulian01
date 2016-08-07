package com.quliantrip.qulian.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.global.QulianApplication;

public abstract class BasePullAndRefreshFragment extends BaseFragment {

	protected PullToRefreshListView refreshViewList;
	protected ListView listView;

	protected void initRefreshListView() {
		refreshViewList = (PullToRefreshListView) View.inflate(
				QulianApplication.getContext(), R.layout.view_pulltorefresh_listview, null);
		// 设置PullToRefu的mode
		refreshViewList.setMode(Mode.BOTH);
		listView = refreshViewList.getRefreshableView();
		listView.setSelector(new ColorDrawable(Color.TRANSPARENT));// 给listView添加一个设置透明背景。

		// 进行数据时的适配和是上啦还是下拉的操作
		refreshViewList.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// 根据不同的mode进行操作,mode中有要进行操作的类型的数据
				if (refreshViewList.getCurrentMode() == Mode.PULL_FROM_START) {
					// 这里的请求数据是在子线程中，
//					CommentUtil.runOnUIThread(new Runnable() {
//
//						@Override
//						public void run() {
//							ToastUtil.showToast("下拉刷新了");
//							refreshViewList.onRefreshComplete();
//						}
//					}, 500);
				} else {
					//下拉加载更多数据
//					contentPage.loadDataAndRefreshPage();
				}

			}
		});
	}

}
