package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.domain.HomePageBean;
import com.quliantrip.qulian.scanner.activity.CaptureActivity;
import com.quliantrip.qulian.scanner.activity.OpenWifiActivity;
import com.quliantrip.qulian.util.ToastUtil;
import com.quliantrip.qulian.util.UIHelper;
import com.quliantrip.qulian.view.RangeSeekBar;

import de.greenrobot.event.EventBus;

/**
 * Created by yuly on 2015/11/9.
 */

public class WifiFragment extends BaseFragment implements View.OnClickListener{
    private PopupWindow popupWindow;
    private Button bt;
    private Button pop;
    private FrameLayout frameLayout;
    public Integer mintxt = new Integer(0);
    public Integer maxint = new Integer(100);

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_wifi, null);
        EventBus.getDefault().register(this);//有注册也要有OnEventMainThread()来接受有要是相当于发过来的handle处理消息队列
        view.findViewById(R.id.wifiManage_test).setOnClickListener(this);
        view.findViewById(R.id.check_asdf).setOnClickListener(this);
        frameLayout = (FrameLayout) view.findViewById(R.id.fl_container);
        pop = (Button) view.findViewById(R.id.wifiManage_popUp);
        pop.setOnClickListener(this);
        return view;
    }

    public void onEventMainThread(HomePageBean homePageBean) {

    }
    @Override
    public void initDate() {
        System.out.println("wifi数据加载了。。。");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wifiManage_test:
                UIHelper.showMyActive(getActivity());
                break;
            case R.id.wifiManage_popUp:
                showPopuWindow();
                break;
            case R.id.check_asdf:
                UIHelper.showSeak(getActivity());
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == 0) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            if(scanResult.startsWith("SSID")){
                data.setClass(mContext, OpenWifiActivity.class);
                startActivity(data);
            }else{
                ToastUtil.showToast(mContext,"请扫描正确的二维码");
            }

        }
    }

    //显示popupWindow的内容
    public void showPopuWindow(){
        //记载布局并为其设置点击事件
        final View popView = View.inflate(mContext, R.layout.popupwindow_sift_condition, null);
//        加载布局进行显示
//        Integer mintxt = new Integer(0);
//        Integer maxint = new Integer(100);

        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(0, 100 , mContext);
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar,
                                                    Integer minValue, Integer maxValue) {
//                // handle changed range values
//                mMinText.setText(String.valueOf(minValue));
//                mMaxText.setText(String.valueOf(maxValue));
            }
        });

        // add RangeSeekBar to pre-defined layout
        ViewGroup layout = (ViewGroup) popView.findViewById(R.id.SeekBarlayout);
        layout.addView(seekBar);

//        LinearLayout ll_popsoft_uninstall = (LinearLayout) popView.findViewById(R.id.ll_popsoft_uninstall);
//        LinearLayout ll_popsoft_start = (LinearLayout) popView.findViewById(R.id.ll_popsoft_start);
//        LinearLayout ll_popsoft_share = (LinearLayout) popView.findViewById(R.id.ll_popsoft_share);
//        LinearLayout ll_popsoft_content = (LinearLayout) popView.findViewById(R.id.ll_popsoft_content);
//        ll_popsoft_uninstall.setOnClickListener(SoftManageActivity.this);
//        ll_popsoft_start.setOnClickListener(SoftManageActivity.this);
//        ll_popsoft_share.setOnClickListener(SoftManageActivity.this);
//        ll_popsoft_content.setOnClickListener(SoftManageActivity.this);

        popupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置可以使用动画
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);//设置点击外部进行隐藏。
        ((Button)popView.findViewById(R.id.bt_comment_popupwindow)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidePopupWindow();
            }
        });
        //获取条目的坐标
        int[] location = new int[2];//空的xy的坐标
        view.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        //popupwindow定义显示的位置
        popupWindow.showAtLocation(pop, Gravity.LEFT|Gravity.TOP, x, y+200);

        //前四个参数表示，xy方向的缩放的比例，后四个表示从哪里开始缩放和缩放的样式从自身左边的中间开始
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
        scaleAnimation.setDuration(200);
        //1.0f表示全部显示。从0。4开始显示
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 1.0f);
        alphaAnimation.setDuration(200);
        //建立动画的集合
        AnimationSet animationSet = new AnimationSet(false);//参数表示是否有动画插入器
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        popView.startAnimation(animationSet);//动画的开始依附于背景进行显示，内有背景是不显示的，所以给popupwindow添加一个透明的背景
        popupWindow.setOutsideTouchable(true);
    }
    //隐藏pouwindow
    private void hidePopupWindow(){
        //在onsrcll中的方法在oncreate会调用,所以判断是否为空
        if(popupWindow != null){
            popupWindow.dismiss();
            popupWindow = null;
        }
    }

}
