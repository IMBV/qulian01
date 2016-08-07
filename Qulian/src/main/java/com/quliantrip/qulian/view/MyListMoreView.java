package com.quliantrip.qulian.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.quliantrip.qulian.R;

/**
 * Created by Yuly on 2015/12/30.
 * www.quliantrip.com
 */
public class MyListMoreView extends ListView implements AbsListView.OnScrollListener {

    private View footer;
    private boolean isStop = false;
    private ProgressBar progressBar;
    private TextView loadInfo;

    public MyListMoreView(Context context) {
        this(context, null);
    }

    public MyListMoreView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyListMoreView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFooter();
    }

    public void initFooter(){
        footer = View.inflate(getContext(), R.layout.view_list_footer, null);
        progressBar = (ProgressBar) footer.findViewById(R.id.pb_load_more);
        loadInfo = (TextView)footer.findViewById(R.id.tv_load_info);
        footer.measure(0, 0);
        heightFooter = footer.getMeasuredHeight();
        footer.setPadding(0,-heightFooter, 0, 0);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE ||scrollState == SCROLL_STATE_FLING) {
            if (getLastVisiblePosition()==getCount()-1&&!isStop) {
                footer.setPadding(0, 0, 0, 0);
                isStop = true;
                if(onloadMoreListener != null){
                    onloadMoreListener.loadMore();
                }
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
    }

    //加载更多的监听数据
    private OnloadMoreListener onloadMoreListener;
    private int heightFooter;

    public interface OnloadMoreListener{
        public void loadMore();
    }

    public void setOnloadMoreListener(OnloadMoreListener onloadMoreListener) {
        this.onloadMoreListener = onloadMoreListener;
    }

    public OnloadMoreListener getOnloadMoreListener() {
        return onloadMoreListener;
    }

    public void LoadMoreFinish() {
        if(isStop) {
            footer.setPadding(0, -heightFooter, 0, 0);
            isStop = false;
        }
    }
    public void setAllItem(){
        progressBar.setVisibility(View.GONE);
    }
}
