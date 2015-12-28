package com.quliantrip.qulian.ui.fragment.mainFragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quliantrip.qulian.R;
import com.quliantrip.qulian.base.BaseFragment;
import com.quliantrip.qulian.net.constant.HttpConstants;
import com.quliantrip.qulian.ui.activity.GoodDetailActivity;
import com.quliantrip.qulian.util.UIHelper;
import com.quliantrip.qulian.view.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuly on 2015/11/9.
 */

public class MyFragment extends BaseFragment {
    //    @Bind(R.id.rg_order_state)
//    RadioGroup orderRadioGroup;
    @Bind(R.id.ll_user_loading)
    LinearLayout userLoading;
    @Bind(R.id.tv_me_userImage)
    CircleImageView userImage;
    @Bind(R.id.tv_me_username)
    TextView userName;
    @Bind(R.id.tv_me_loading)
    Button loading;
    @Bind(R.id.tv_me_loadout)
    Button loadout;
    @Bind(R.id.wb_login_info)
    WebView checkLoginWebView;

    private Bundle bundle = new Bundle();
    private View view;

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.fragment_main_me, null);
        ButterKnife.bind(this, view);
//        checkLogin();
        initLogin();
        return view;
    }

    //检查是否登录
    private void initLogin() {
        checkLoginWebView.loadUrl(HttpConstants.WEBVIEW_ROOT + "?ctl=user_center");
        checkLoginWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        checkLoginWebView.getSettings().setJavaScriptEnabled(true);

        checkLoginWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (checkLoginWebView.getUrl().endsWith("ctl=user&act=login")) {
                    loading.setVisibility(View.VISIBLE);
                    loadout.setVisibility(View.GONE);
                } else {
                    loading.setVisibility(View.GONE);
                    loadout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
//        checkLogin();
        initLogin();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == 2) {
            loading.setVisibility(View.GONE);
            loadout.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.ll_user_loading)
    void setAllInfo() {
        UIHelper.showMeSetting(mContext);
    }

    @Override
    public void initDate() {

    }

    //点击登录
    @OnClick(R.id.tv_me_loading)
    void loading() {
        //使用借口登录
//        UIHelper.showMyActive(mContext);
        //使用web进行登录
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT + "?ctl=user&act=login");
        startActivityForResult(intent, 2);
        initLogin();
    }

    //点击退出
    @OnClick(R.id.tv_me_loadout)
    void loadout() {
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("isFinish", "finish");
        intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT + "?ctl=user&act=loginout");
        mContext.startActivity(intent);
    }

    //我的积分
    @OnClick(R.id.ll_me_integral)
    void showIntegral() {
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT + "?ctl=uc_ecv&act=exchange");
        mContext.startActivity(intent);
    }

    //我的收藏
    @OnClick(R.id.ll_me_collect)
    void showCollect() {
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT + "?ctl=uc_collect");
        mContext.startActivity(intent);
    }

    //我的订单
    @OnClick(R.id.ll_me_orderList)
    void showOrderList() {
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT + "?ctl=uc_order");
        mContext.startActivity(intent);
    }

    //设置
    @OnClick(R.id.ll_me_setting_out)
    void goOutLogin() {
        Intent intent = new Intent(mContext, GoodDetailActivity.class);
        intent.putExtra("goodId", HttpConstants.WEBVIEW_ROOT + "?ctl=user&act=getpassword");
        mContext.startActivity(intent);
    }


    //    public void checkLogin(){
//        if (QulianApplication.getInstance().isLogin()) {
//            userLoading.setVisibility(View.VISIBLE);
//            loading.setVisibility(View.GONE);
//            userName.setText(QulianApplication.getInstance().getLoginUser().getUser_name());
//        } else {
//            userLoading.setVisibility(View.GONE);
//            loading.setVisibility(View.VISIBLE);
//        }
//    }

//    @OnClick(R.id.bt_map)
//    void enterMap() {
//        Intent intent = new Intent(mContext,MapActivity.class);
//        startActivity(intent);
//
//    }
    //    @OnClick(R.id.rb_order_all)
//    void orderAll() {
//        bundle.putInt("orderState", 0);
//        UIHelper.showOrderList(mContext, bundle);
//    }
//
//    @OnClick(R.id.rb_order_nor)
//    void ordernor() {
//        bundle.putInt("orderState", 1);
//        UIHelper.showOrderList(mContext, bundle);
//    }
//
//    @OnClick(R.id.rb_order_norUser)
//    void ordernorUser() {
//        bundle.putInt("orderState", 2);
//        UIHelper.showOrderList(mContext, bundle);
//    }
//
//    @OnClick(R.id.rb_order_norAssess)
//    void orderNorAssess() {
//        bundle.putInt("orderState", 3);
//        UIHelper.showOrderList(mContext, bundle);
//    }

    private void initMap() {

//        WebSettings settings = map.getSettings();
//        map.loadUrl("http://www.quliantrip.com/index.php?ctl=deal&act=188");
//        settings.setJavaScriptEnabled(true);
//        map.loadUrl("http://www.quliantrip.com/wap/index.php?ctl=deal&act=map&id=192");
//        WebSettings ws = map.getSettings();
//        ws.setAllowFileAccess(true);
//        ws.setJavaScriptEnabled(true);
//        map.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
//
//                return true;
//            }
//        });


//        这里使用的是加载完成后的回调监听
//        map.setWebViewClient(new WebViewClient() {
//            //    ؽ     ɵ
//            @Override
//            public void onPageFinished(WebView view, String url) {
////                loading.setVisibility(View.GONE);
//                map.setVisibility(View.VISIBLE);
//                super.onPageFinished(view, url);
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//
//                super.onPageStarted(view, url, favicon);
//            }
//        });
    }
}
