package com.quliantrip.qulian.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Yuly on 2015/12/7.
 * www.quliantrip.com
 */
public class DialogToMe extends Dialog {
    int layoutRes;//布局文件
    Context context;
    public DialogToMe(Context context) {
        super(context);
        this.context = context;
    }
    /**
     * 自定义布局的构造方法
     * @param context
     * @param resLayout
     */
    public DialogToMe(Context context, int resLayout){
        super(context);
        this.context = context;
        this.layoutRes=resLayout;
    }
    /**
     * 自定义主题及布局的构造方法
     * @param context
     * @param theme
     * @param resLayout
     */
    public DialogToMe(Context context, int theme,int resLayout){
        super(context, theme);
        this.context = context;
        this.layoutRes=resLayout;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layoutRes);
    }
}
