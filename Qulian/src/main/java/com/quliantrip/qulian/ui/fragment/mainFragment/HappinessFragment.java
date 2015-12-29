//package com.quliantrip.qulian.ui.fragment.mainFragment;
//
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.view.Gravity;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.AnimationSet;
//import android.view.animation.ScaleAnimation;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//import android.widget.RelativeLayout;
//
//import com.quliantrip.qulian.R;
//import com.quliantrip.qulian.base.BasePageCheckFragment;
//import com.quliantrip.qulian.domain.BaseJson;
//import com.quliantrip.qulian.domain.HomePageBean;
//import com.quliantrip.qulian.net.constant.HttpConstants;
//import com.quliantrip.qulian.net.volleyManage.QuestBean;
//import com.quliantrip.qulian.ui.fragment.happinessFragment.HotGoodsFragment;
//import com.quliantrip.qulian.ui.fragment.happinessFragment.RecommendRouteFragment;
//import com.quliantrip.qulian.util.CommonHelp;
//import com.quliantrip.qulian.util.ToastUtil;
//import com.quliantrip.qulian.view.RangeSeekBar;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
///**
// * Created by yuly on 2015/11/9.
// */
//
//
//public class HappinessFragment extends BasePageCheckFragment {
//    private Fragment currentFragment = new RecommendRouteFragment();
//    private FragmentManager mFragmentManager;
//
//    private PopupWindow popupWindow;
//    private View view;
//    @Bind(R.id.rl_find_condition)
//    RelativeLayout condition;
//    @Bind(R.id.bt_recommend_route)Button bt_left;
//    @Bind(R.id.bt_hot_goods) Button bt_right;
//
//    private RecommendRouteFragment recommendRouteFragment;
//    private HotGoodsFragment hotGoodsFragment;
//
//    @Override
//    protected View getSuccessView() {
//        view = View.inflate(mContext, R.layout.fragment_main_happiness, null);
//        ButterKnife.bind(this, view);
//        mFragmentManager = ((FragmentActivity)mContext).getSupportFragmentManager();
//        recommendRouteFragment = new RecommendRouteFragment();
//        hotGoodsFragment = new HotGoodsFragment();
//        mFragmentManager.beginTransaction().add(R.id.fl_happiness_container,recommendRouteFragment).commit();
//        setButtonColor(true);
//        return view;
//    }
//
//    @Override
//    protected QuestBean requestData() {
//        return new QuestBean(null, new HomePageBean().setTag(getClass().getName()), HttpConstants.TEST_URL);
//    }
//
//    @Override
//    public void onEventMainThread(BaseJson bean) {
//
//    }
//
//    @OnClick(R.id.bt_recommend_route) void showRecommendRoute(){
//        gotoSubFragmennt(recommendRouteFragment);
//        setButtonColor(true);
//
//    }
//    @OnClick(R.id.bt_hot_goods) void showHotGoods(){
//        gotoSubFragmennt(hotGoodsFragment);
//        setButtonColor(false);
//
//    }
//
//    private void setButtonColor(Boolean starte){
//        if(starte){
//            bt_left.setTextColor(0x7f040001);
//            bt_right.setTextColor(Color.rgb(127, 216, 249));
//        }else{
//            bt_right.setTextColor(0x7f040001);
//            bt_left.setTextColor(Color.rgb(127, 216, 249));
//        }
//    }
//    private void gotoSubFragmennt(Fragment fragment) {
//        if(currentFragment != fragment){
//            FragmentTransaction transaction = mFragmentManager.beginTransaction();
//            if(fragment.isAdded()){
//                transaction.show(fragment);
//            }else{
//                transaction.add(R.id.fl_happiness_container,fragment);
//            }
//            transaction.hide(currentFragment);
//            transaction.commit();
//            currentFragment = fragment;
//        }
//    }
//
//
//    @OnClick(R.id.iv_happiness_find)
//    void findCondition() {
//        showPopuWindow();
//    }
//
//    //显示popupWindow的内容
//    public void showPopuWindow() {
//        //记载布局并为其设置点击事件
//        final View popView = View.inflate(mContext, R.layout.popupwindow_sift_condition, null);
//
//        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(0, 100, mContext);
//        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
//            @Override
//            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar,
//                                                    Integer minValue, Integer maxValue) {
////                // handle changed range values
////                mMinText.setText(String.valueOf(minValue));
////                mMaxText.setText(String.valueOf(maxValue));
//            }
//        });
//
//        // add RangeSeekBar to pre-defined layout
//        ViewGroup layout = (ViewGroup) popView.findViewById(R.id.SeekBarlayout);
//        layout.addView(seekBar);
//
////        LinearLayout ll_popsoft_uninstall = (LinearLayout) popView.findViewById(R.id.ll_popsoft_uninstall);
//
//        popupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置可以使用动画
////        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        popupWindow.setOutsideTouchable(true);//设置点击外部进行隐藏。
//        ((Button) popView.findViewById(R.id.bt_comment_popupwindow)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hidePopupWindow();
//            }
//        });
//        //获取条目的坐标
//        int[] location = new int[2];//空的xy的坐标
//        condition.getLocationInWindow(location);
//        int x = location[0];
//        int y = location[1];
//        //popupwindow定义显示的位置
//        popupWindow.showAtLocation(condition, Gravity.LEFT | Gravity.TOP, x, y);
//
//        //前四个参数表示，xy方向的缩放的比例，后四个表示从哪里开始缩放和缩放的样式从自身左边的中间开始
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
//        scaleAnimation.setDuration(200);
//        //1.0f表示全部显示。从0。4开始显示
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 1.0f);
//        alphaAnimation.setDuration(200);
//        //建立动画的集合
//        AnimationSet animationSet = new AnimationSet(false);//参数表示是否有动画插入器
//        animationSet.addAnimation(scaleAnimation);
//        animationSet.addAnimation(alphaAnimation);
//        popView.startAnimation(animationSet);//动画的开始依附于背景进行显示，内有背景是不显示的，所以给popupwindow添加一个透明的背景
//        popupWindow.setOutsideTouchable(true);
//    }
//
//    //隐藏pouwindow
//    private void hidePopupWindow() {
//        //在onsrcll中的方法在oncreate会调用,所以判断是否为空
//        if (popupWindow != null) {
//            popupWindow.dismiss();
//            popupWindow = null;
//        }
//    }
//}
