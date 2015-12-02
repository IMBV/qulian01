package com.quliantrip.qulian.mode;

import android.app.Activity;
import android.view.View;

/**
 * Created by yuly on 2015/12/2.
 */


/**
 * 使用 ：在oncreate中进行返回view,通过addView(mode.getModeView(），
 *请求数据后进行加载mode.setData(),来加载数据
 * */
public class HomeSlideImageMode extends BaseMode {
    private View view;
    private Activity mActivity;

    //下面进行添加不布局是的空间



    public HomeSlideImageMode(Activity activity) {
        this.mActivity = activity;
//        view = View.inflate()//进行加载布局的xml文件

    }

    @Override
    public View getModelView() {
        return view;
    }

    //在这里进行数据的添加,o表示传如的类，进行空间的加载布局
    @Override
    public void setData(Object o) {


    }
}
