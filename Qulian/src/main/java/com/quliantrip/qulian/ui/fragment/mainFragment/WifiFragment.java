package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
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
import com.quliantrip.qulian.scanner.activity.CaptureActivity;
import com.quliantrip.qulian.scanner.activity.OpenWifiActivity;
import com.quliantrip.qulian.util.UIHelper;

/**
 * Created by yuly on 2015/11/9.
 */


public class WifiFragment extends BaseFragment implements View.OnClickListener{
    private PopupWindow popupWindow;
    private Button bt;
    private Button pop;
    private FrameLayout frameLayout;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_main_wifi, null);
        bt = (Button)view.findViewById(R.id.wifiManage);
        view.findViewById(R.id.wifiManage_test).setOnClickListener(this);
        bt.setOnClickListener(this);
        frameLayout = (FrameLayout) view.findViewById(R.id.fl_container);
        pop = (Button) view.findViewById(R.id.wifiManage_popUp);
        pop.setOnClickListener(this);
        return view;
    }

    @Override
    public void initDate() {
        System.out.println("wifi数据加载了。。。");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wifiManage:
                Intent openCameraIntent = new Intent(mContext,CaptureActivity.class);
                startActivityForResult(openCameraIntent,0);
                break;
            case R.id.wifiManage_test:
                UIHelper.showMyActive(getActivity());
            case R.id.wifiManage_popUp:
                showPopuWindow();
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == 0) {
            data.setClass(mContext, OpenWifiActivity.class);
            startActivity(data);
        }
    }

    public void showPopuWindow(){
        //记载布局并为其设置点击事件
        View popView = View.inflate(mContext, R.layout.popupwindow_sift_condition, null);
//        加载布局进行显示
//        LinearLayout ll_popsoft_uninstall = (LinearLayout) popView.findViewById(R.id.ll_popsoft_uninstall);
//        LinearLayout ll_popsoft_start = (LinearLayout) popView.findViewById(R.id.ll_popsoft_start);
//        LinearLayout ll_popsoft_share = (LinearLayout) popView.findViewById(R.id.ll_popsoft_share);
//        LinearLayout ll_popsoft_content = (LinearLayout) popView.findViewById(R.id.ll_popsoft_content);
//        ll_popsoft_uninstall.setOnClickListener(SoftManageActivity.this);
//        ll_popsoft_start.setOnClickListener(SoftManageActivity.this);
//        ll_popsoft_share.setOnClickListener(SoftManageActivity.this);
//        ll_popsoft_content.setOnClickListener(SoftManageActivity.this);

        popupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置可以使用动画

        //获取条目的坐标
        int[] location = new int[2];//空的xy的坐标
        view.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        //popupwindow定义显示的位置
        popupWindow.showAtLocation(pop, Gravity.LEFT|Gravity.TOP, x+550, y);

        //前四个参数表示，xy方向的缩放的比例，后四个表示从哪里开始缩放和缩放的样式从自身左边的中间开始
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(200);
        //1.0f表示全部显示。从0。4开始显示
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 1.0f);
        alphaAnimation.setDuration(200);
        //建立动画的集合
        AnimationSet animationSet = new AnimationSet(false);//参数表示是否有动画插入器
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        popView.startAnimation(animationSet);//动画的开始依附于背景进行显示，内有背景是不显示的，所以给popupwindow添加一个透明的背景
    }

}
