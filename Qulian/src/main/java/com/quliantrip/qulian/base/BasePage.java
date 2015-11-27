package com.quliantrip.qulian.base;

import android.content.Context;
import android.view.View;

/**
 * Created by yuly on 2015/11/9.
 */
public abstract class BasePage {

    public Context mContext;
    public View view;


    public BasePage(Context context) {
        this.mContext = context;
        this.view = initView();
    }

    /**
     * 加载布局文件
     */
    public abstract View initView();
    /**
     * 填充数据
     */
    public abstract void initData();

    public View getRootView() {
        return view;
    }

    //还要进行添加初始话title的一些方法
    public void initTileBar(){

    }

}
