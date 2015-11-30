package com.quliantrip.qulian.ui.showFragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;

import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;

/**
 * Created by yuly on 2015/11/9.
 */


public class HomeFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mContext,R.layout.fragment_main_home, null);
        LinearLayout homeTitle = (LinearLayout) view.findViewById(R.id.ll_home_title);
        ViewHelper.setAlpha(homeTitle,0.5f);
        return view;
    }

    @Override
    public void initDate() {
//        ViewAnimator.ofInt(0,255);
//
//        View
//        ViewHelper.setScaleX(mContext, 1.0f + (0.8f - 1.0f) * percent);
//        ViewHelper.setScaleY(mContext, 1.0f + (0.8f - 1.0f) * percent);
//        ViewHelper.setScaleX(mContext, 0.5f + (1.0f - 0.5f) * percent);
//        ViewHelper.setScaleY(mContext, 0.5f + (1.0f - 0.5f) * percent);
//
//
//        ViewHelper.setTranslationX(mLeftContent,
//                EvaluateUtil.evaluateFloat(percent, -mWidth * 0.5f, 0));
//        ViewHelper.setAlpha(mLeftContent,
//                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
//        getBackground().setColorFilter(
//                (Integer) EvaluateUtil.evaluateArgb(percent, Color.BLACK,
//                        Color.TRANSPARENT), PorterDuff.Mode.SRC_OVER);
    }
    //这里进行动画的监听，改变其透明度
    private void animViews(float percent) {
//        ViewHelper.setScaleX(mMainContent, 1.0f + (0.8f - 1.0f) * percent);
//        ViewHelper.setScaleY(mMainContent, 1.0f + (0.8f - 1.0f) * percent);
//        ViewHelper.setScaleX(mLeftContent, 0.5f + (1.0f - 0.5f) * percent);
//        ViewHelper.setScaleY(mLeftContent, 0.5f + (1.0f - 0.5f) * percent);
//
//
//        ViewHelper.setTranslationX(mLeftContent,
//                EvaluateUtil.evaluateFloat(percent, -mWidth * 0.5f, 0));
//        ViewHelper.setAlpha(mLeftContent,
//                EvaluateUtil.evaluateFloat(percent, 0.0f, 1.0f));
//        getBackground().setColorFilter(
//                (Integer) EvaluateUtil.evaluateArgb(percent, Color.BLACK,
//                        Color.TRANSPARENT), Mode.SRC_OVER);
    }

}
