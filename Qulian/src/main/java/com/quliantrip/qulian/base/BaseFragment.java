package com.quliantrip.qulian.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;

/**
 * Created by yuly on 2015/11/26.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    public View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (Context) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = initView();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initDate();
        super.onActivityCreated(savedInstanceState);
    }

    public abstract View initView();

    public abstract void initDate();

    // 设置fragment的适配的内容显示当前的
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        // getView()该视图的fragment对象
        if (getView() != null) {
            getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
